package com.home.gmall;

import com.home.gmall.service.OrderService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:consumer.xml")
public class MainApplicationTest {

    @Test
    public void main() {
        ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("consumer.xml");
        OrderService orderService = cpx.getBean(OrderService.class);
        orderService.initOrder("1");
        System.out.println("调用完成");
    }
}