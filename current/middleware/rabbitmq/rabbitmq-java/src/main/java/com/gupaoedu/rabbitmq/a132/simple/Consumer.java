package com.gupaoedu.rabbitmq.a132.simple;

import com.rabbitmq.client.*;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

public class Consumer {
    public static void main(String[] args) {
        // 1、创建连接工厂
        ConnectionFactory factory = new ConnectionFactory();
        // 2、设置连接属性
        factory.setHost("192.168.0.108");
        factory.setUsername("admin");
        factory.setPassword("admin");

        Connection connection = null;
        Channel channel = null;

        // 3、从连接工厂获取连接
        try {
            connection = factory.newConnection("消费者");
            // 4、从连接中创建通道
            channel = connection.createChannel();

            channel.queueDeclare("queue3", false, false, false, null);
            // 6、定义收到消息后的回调
            DeliverCallback callback = new DeliverCallback() {
                @Override
                public void handle(String consumerTag, Delivery message) throws IOException {
                    System.out.println("收到消息：" + new String(message.getBody(), "UTF-8"));
                }
            };
            // 7、监听队列
            channel.basicConsume("queue3", true, callback, new CancelCallback() {
                @Override
                public void handle(String consumerTag) throws IOException {

                }
            });
            System.out.println("开始接收消息");
            System.in.read();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }finally {
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
}
