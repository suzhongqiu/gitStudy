package helloworld;

import com.rabbitmq.client.*;
import utils.RabbitMqUtil;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SuppressWarnings("AlibabaClassMustHaveAuthor")
public class Consumer {
    public static void main(String[] args) throws IOException, TimeoutException {
        // // 创建连接工厂
        // ConnectionFactory connectionFactory = new ConnectionFactory();
        // // 设置连接的主机
        // connectionFactory.setHost("192.168.10.27");
        // // 设置端口号
        // connectionFactory.setPort(5672);
        // // 设置连接那个虚拟主机
        // connectionFactory.setVirtualHost("/ems");
        // // 设置访问虚拟主机的用户名和密码
        // connectionFactory.setUsername("admin");
        // connectionFactory.setPassword("szq999yy.");

        //获取连接对象
        // Connection connection = connectionFactory.newConnection();
        Connection connection = RabbitMqUtil.getConnection();

        // 获取连接中的通道
        Channel channel = connection.createChannel();

        // 消费者参数与生产者保持一致
        channel.queueDeclare("hello",false, false,false,null);

        //消费消息时的回调接口
        channel.basicConsume("hello",true, new DefaultConsumer(channel){

            // 消息队列中取出的消息
            @Override
            public void handleDelivery(String consumerTag, Envelope envelope, AMQP.BasicProperties properties, byte[] body) throws IOException {
                super.handleDelivery(consumerTag, envelope, properties, body);
                System.out.println("new String(body):" + new String(body));
            }
        });
        // 不建议关闭，consumer一直运行
        // channel.close();
        // connection.close();
    }
}
