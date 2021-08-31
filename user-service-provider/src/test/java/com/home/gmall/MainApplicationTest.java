package com.home.gmall;

import com.home.gmall.impl.UserServiceImpl;
import com.home.gmall.pojo.UserAddress;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:provider.xml")
public class MainApplicationTest {

    @Test
    public void main() {
        ClassPathXmlApplicationContext cpx = new ClassPathXmlApplicationContext("provider.xml");
        UserServiceImpl userServiceImpl =(UserServiceImpl) cpx.getBean("userServiceImpl");
        List<UserAddress> userAddressList = userServiceImpl.getUserAddressList("1");
        for (UserAddress userAddress : userAddressList) {
            System.out.println(userAddress);
        }
    }
}