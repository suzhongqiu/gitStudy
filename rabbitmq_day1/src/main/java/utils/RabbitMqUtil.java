package utils;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;

import java.io.IOException;
import java.util.concurrent.TimeoutException;


public class RabbitMqUtil {

    private static ConnectionFactory connectionFactory;

    static {
        // 重量级资源，只执行了一次
        connectionFactory = new ConnectionFactory();
        connectionFactory.setHost("192.168.10.27");
        connectionFactory.setPort(5672);
        connectionFactory.setVirtualHost("/ems");
        connectionFactory.setUsername("admin");
        connectionFactory.setPassword("szq999yy.");
    }
    public static Connection getConnection(){
        try {
            return connectionFactory.newConnection();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void closeConnectionAndChannel(Channel channel, Connection connection) throws IOException, TimeoutException {
        try {
            if(channel != null){
                channel.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("通道关闭IO异常");
        } catch (TimeoutException e) {
            e.printStackTrace();
            throw new TimeoutException("关闭通道超时");
        }
        try {
            if(connection != null) {
                connection.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new IOException("关闭连接IO异常");
       }
    }
}
