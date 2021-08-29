package com.home.gmall;

import com.home.gmall.service.OrderService;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.io.IOException;

public class MainApplication {
    public static void main(String[] args) throws IOException {
        ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("consumer.xml");
        OrderService orderService = cpx.getBean(OrderService.class);
        orderService.initOrder("1");
        System.out.println("调用完成.....");
        System.in.read();
    }
}
