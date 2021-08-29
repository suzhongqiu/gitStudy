package com.home.gmall.service.impl;


import com.home.gmall.pojo.UserAddress;
import com.home.gmall.service.OrderService;
import com.home.gmall.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    UserService userService;
    @Override
    public void initOrder(String userId) {
        System.out.println("用户id:" + userId);
        //查询用户的收获地址
        List<UserAddress> addressList = userService.getUserAddressList(userId);
        System.out.println(addressList);
        for (UserAddress userAddress : addressList) {
            System.out.println(userAddress.getUserAddress());
        }
    }
}
