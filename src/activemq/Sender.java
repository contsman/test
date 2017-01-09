package activemq;

import org.apache.activemq.ActiveMQConnection;
import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;
import java.util.Stack;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtiecai
 * Date: 2016/3/3
 * Time: 12:49
 * To change this template use File | Settings | File Templates.
 */
public class Sender {
    public static void main(String[] args) {
        try {
            sendMessage();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendMessage() throws Exception{
        final int num1 = 2000;
        final int num2 = 2000;
        final int num3 = 2000;
        new Thread(new Runnable()  {
            @Override
            public void run() {
                // ConnectionFactory ：连接工厂，JMS 用它创建连接
                ConnectionFactory connectionFactory;
                // Connection ：JMS 客户端到JMS Provider 的连接
                Connection connection = null;
                // Session： 一个发送或接收消息的线程
                Session session;
                // Destination ：消息的目的地;消息发送给谁.
                Destination destination;
                // 消费者，消息接收者
                MessageProducer producer;
                connectionFactory = new ActiveMQConnectionFactory(
                        ActiveMQConnection.DEFAULT_USER,
                        ActiveMQConnection.DEFAULT_PASSWORD,
                        "tcp://localhost:61616");
                try {
                    // 构造从工厂得到连接对象
                    connection = connectionFactory.createConnection();
                    // 启动
                    connection.start();
                    // 获取操作连接
                    session = connection.createSession(Boolean.FALSE,
                            Session.AUTO_ACKNOWLEDGE);
                    // 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置
                    destination = session.createQueue("FirstQueue");
                    producer = session.createProducer(destination);
                    String msg = Thread.currentThread().getName()+",Active mq 发送的消息:%d";
                    for(int i=0;i<num1;i++){
                        TextMessage message = null;
                        try {
                            message = session.createTextMessage(String.format(msg,i));
                            System.out.println(Thread.currentThread().getName()+",发送消息：" + "ActiveMq 发送的消息:" + i);
                            producer.send(message);
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (null != connection)
                            connection.close();
                    } catch (Throwable ignore) {
                    }
                }

            }
        }).start();

        new Thread(new Runnable()  {
            @Override
            public void run() {
                // ConnectionFactory ：连接工厂，JMS 用它创建连接
                ConnectionFactory connectionFactory;
                // Connection ：JMS 客户端到JMS Provider 的连接
                Connection connection = null;
                // Session： 一个发送或接收消息的线程
                Session session;
                // Destination ：消息的目的地;消息发送给谁.
                Destination destination;
                // 消费者，消息接收者
                MessageProducer producer;
                connectionFactory = new ActiveMQConnectionFactory(
                        ActiveMQConnection.DEFAULT_USER,
                        ActiveMQConnection.DEFAULT_PASSWORD,
                        "tcp://localhost:61616");
                try {
                    // 构造从工厂得到连接对象
                    connection = connectionFactory.createConnection();
                    // 启动
                    connection.start();
                    // 获取操作连接
                    session = connection.createSession(Boolean.FALSE,
                            Session.AUTO_ACKNOWLEDGE);
                    // 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置
                    destination = session.createQueue("FirstQueue");
                    producer = session.createProducer(destination);
                    String msg = Thread.currentThread().getName()+",Active mq 发送的消息:%d";
                    for(int i=0;i<num2;i++){
                        TextMessage message = null;
                        try {
                            message = session.createTextMessage(String.format(msg,i));
                            System.out.println(Thread.currentThread().getName()+",发送消息：" + "ActiveMq 发送的消息:" + i);
                            producer.send(message);
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (null != connection)
                            connection.close();
                    } catch (Throwable ignore) {
                    }
                }

            }
        }).start();

        new Thread(new Runnable()  {
            @Override
            public void run() {
                // ConnectionFactory ：连接工厂，JMS 用它创建连接
                ConnectionFactory connectionFactory;
                // Connection ：JMS 客户端到JMS Provider 的连接
                Connection connection = null;
                // Session： 一个发送或接收消息的线程
                Session session;
                // Destination ：消息的目的地;消息发送给谁.
                Destination destination;
                // 消费者，消息接收者
                MessageProducer producer;
                connectionFactory = new ActiveMQConnectionFactory(
                        ActiveMQConnection.DEFAULT_USER,
                        ActiveMQConnection.DEFAULT_PASSWORD,
                        "tcp://localhost:61616");
                try {
                    // 构造从工厂得到连接对象
                    connection = connectionFactory.createConnection();
                    // 启动
                    connection.start();
                    // 获取操作连接
                    session = connection.createSession(Boolean.FALSE,
                            Session.AUTO_ACKNOWLEDGE);
                    // 获取session注意参数值xingbo.xu-queue是一个服务器的queue，须在在ActiveMq的console配置
                    destination = session.createQueue("FirstQueue");
                    producer = session.createProducer(destination);
                    String msg = Thread.currentThread().getName()+",Active mq 发送的消息:%d";
                    for(int i=0;i<num3;i++){
                        TextMessage message = null;
                        try {
                            message = session.createTextMessage(String.format(msg,i));
                            System.out.println(Thread.currentThread().getName()+",发送消息：" + "ActiveMq 发送的消息:" + i);
                            producer.send(message);
                        } catch (JMSException e) {
                            e.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    try {
                        if (null != connection)
                            connection.close();
                    } catch (Throwable ignore) {
                    }
                }

            }
        }).start();

    }
}
