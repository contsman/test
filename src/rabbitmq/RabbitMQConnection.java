package rabbitmq;

import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

/**
 * Created with IntelliJ IDEA.
 * User: Wangtc
 * Date: 2016/5/4
 * Time: 11:16
 * To change this template use File | Settings | File Templates.
 */
public class RabbitMQConnection {
    private static ConnectionFactory connectionFactory = new ConnectionFactory();
    private static Connection conn = null;
    static{
        try{
//            connectionFactory.setUsername(userName);
//            connectionFactory.setPassword(password);
//            connectionFactory.setVirtualHost(virtualHost);
//            connectionFactory.setHost(hostName);
//            connectionFactory.setPort(portNumber);
            conn = connectionFactory.newConnection();
        }catch (TimeoutException e){
            e.printStackTrace();
            System.out.println("RabbitMQ Connect Time Out...");
        }catch (IOException e){
            e.printStackTrace();
            System.out.println("Create RabbitMQ Connection Failed...");
        }

    }
}
