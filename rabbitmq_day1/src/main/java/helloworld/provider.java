package helloworld;

import com.rabbitmq.client.Channel;
import com.rabbitmq.client.Connection;
import com.rabbitmq.client.ConnectionFactory;
import utils.RabbitMqUtil;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.concurrent.TimeoutException;

public class provider {
    // 生产消息
    public static void main(String[] args) throws IOException, TimeoutException {
        // // 创建连接工厂
        // ConnectionFactory connectionFactory = new ConnectionFactory();
        // // 设置连接的主机
        // connectionFactory.setHost("192.168.10.27");
        // // 设置端口号
        // connectionFactory.setPort(5672);
        // // 设置连接那个虚拟主机
        //  connectionFactory.setVirtualHost("/ems");
        //  // 设置访问虚拟主机的用户名和密码
        // connectionFactory.setUsername("admin");
        // connectionFactory.setPassword("szq999yy.");
        //
        // //获取连接对象
        // Connection connection = connectionFactory.newConnection();

        Connection connection = RabbitMqUtil.getConnection();

        // 获取连接中的通道
        Channel channel = connection.createChannel();

        // 获取通道中的队列
        // 参数1队列名，如果不存在则创建
        // 2，持久化， 3.是否独占，当前队列只能被当前连接可用 4消费挖不出后是否删除队列 5 额外参数
        channel.queueDeclare("hello",false, false,false,null);

        // 发布消息
        // 1交换机名称 2队列名称 3 额外参数 4 消息具体内容
        channel.basicPublish("","hello",null,"rabbitmq hello".getBytes(StandardCharsets.UTF_8));

        // channel.close();
        // connection.close();
        RabbitMqUtil.closeConnectionAndChannel(channel,connection);
    }
}
