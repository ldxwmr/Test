package com.gupaoedu.rabbitmq.a132.routing;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * @Author ldxwmr
 * @Date 2021/11/23 17:37
 */
public class Consumer {
    private static Runnable receive = new Runnable() {
        @Override
        public void run() {
            // 1、创建连接工厂
            ConnectionFactory factory = new ConnectionFactory();
            // 2、设置连接属性
            factory.setHost("192.168.0.108");
            factory.setPort(5672);
            factory.setUsername("admin");
            factory.setPassword("admin");

            Connection connection = null;
            Channel channel = null;

            final String queueName = Thread.currentThread().getName();

            try {
                // 3、从连接工厂获取连接
                connection = factory.newConnection("消费者");
                // 4、从连接中创建通道
                channel = connection.createChannel();
                // 定义消息接受回调对象
                DeliverCallback callback = new DeliverCallback() {
                    @Override
                    public void handle(String consumerTag, Delivery message) throws IOException {
                        System.out.println(queueName + " 收到消息: " + new String(message.getBody(), "UTF-8"));
                    }
                };
                // 监听队列
                channel.basicConsume(queueName, true, callback, new CancelCallback() {
                    @Override
                    public void handle(String consumerTag) throws IOException {

                    }
                });
                System.out.println(queueName + " 开始接收消息");
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
        new Thread(receive, "queue-1").start();
        new Thread(receive, "queue-2").start();
        new Thread(receive, "queue-3").start();
    }
}
