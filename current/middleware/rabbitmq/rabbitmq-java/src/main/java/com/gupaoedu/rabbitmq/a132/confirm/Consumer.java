package com.gupaoedu.rabbitmq.a132.confirm;

import com.rabbitmq.client.*;
import com.rabbitmq.tools.json.JSONUtil;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeoutException;

public class Consumer {
    private static Runnable receive = new Runnable() {
        @Override
        public void run() {
            // 1、创建连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            // 2、设置连接属性
            factory.setHost("192.168.3.33");
            factory.setUsername("admin");
            factory.setPassword("admin");

            Connection connection = null;
            Channel channel = null;
            final String clientName = Thread.currentThread().getName();

            try {
                // 3、从连接工厂获取连接
                connection = factory.newConnection("消费者");
                // ###死信队列相关：专门用来存储 出错 出异常的数据
                channel = connection.createChannel();
                // 1、创建一个exchange
                channel.exchangeDeclare("dlq_exchange", "fanout");
                // 2、创建一个queue，和exchange绑定起来
                channel.queueDeclare("dlq_queue1", false, false, false, null);
                channel.queueBind("dlq_queue1", "dlq_exchange", "");
                // ######死信队列结束

                // 4、从连接中创建通道
                channel = connection.createChannel();
                // 代码定义交换器
                channel.exchangeDeclare("ps_test", "fanout");
                // 还可以定义一个临时队列，连接关闭后会自动删除，此队列是一个排他队列
                String queueName = "queue1";
                // 队列中有死信产生时，消息会转发到交换机dlq_exchange.
                Map<String, Object> args = new HashMap<>();
                args.put("x-dead-letter-exchange", "dlq_exchange");
                channel.queueDeclare(queueName, false, false, false, args);
                // 将队列和交换机绑定
                channel.queueBind(queueName, "ps_test", "");

                // 监听队列
                Channel finalChannel = channel;
                channel.basicConsume(queueName, false, "消费者-手动回执",
                        new DefaultConsumer(finalChannel) {
                            @Override
                            public void handleDelivery(String consumerTag,
                                                       Envelope envelope,
                                                       AMQP.BasicProperties properties,
                                                       byte[] body) throws IOException {

                                try {
                                    System.out.println("收到消息：" + new String(body));
                                    // TODO 业务处理
                                    long deliveryTag = envelope.getDeliveryTag();
                                    // 模拟业务处理耗时
                                    Thread.sleep(1000L);
                                    // 正常消费
                                     finalChannel.basicAck(deliveryTag,false);
                                    // 异常消费
//                                    finalChannel.basicNack(envelope.getDeliveryTag(), false, false);
                                } catch (InterruptedException e) {
                                    // 异常消费，requeue参数true重发，false不重发（丢弃或者移动DLQ死信队列
                                    // finalChannel.basicNack(envelope.getDeliveryTag(),false,false);
                                    e.printStackTrace();
                                }
                            }
                        });
                System.out.println(clientName + " 开始接受消息");
                System.in.read();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (TimeoutException e) {
                e.printStackTrace();
            } finally {
                // 8、关闭通道
                if (channel != null && channel.isOpen()) {
                    try {
                        channel.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    } catch (TimeoutException e) {
                        e.printStackTrace();
                    }
                }
                // 9、关闭连接
                if (connection != null && connection.isOpen()) {
                    try {
                        connection.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    public static void main(String[] args) {
        new Thread(receive, "c1").start();
    }
}
