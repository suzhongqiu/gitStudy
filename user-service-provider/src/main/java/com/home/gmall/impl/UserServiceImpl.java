package com.home.gmall.impl;


import com.home.gmall.pojo.UserAddress;
import com.home.gmall.service.UserService;

import java.util.Arrays;
import java.util.List;

public class UserServiceImpl implements UserService {
    @Override
    public List<UserAddress> getUserAddressList(String userId) {
        UserAddress address1 = new UserAddress(1,"南京市江宁区大里聚福城","1","苏中秋","156xxx","Y");
        UserAddress address2 = new UserAddress(2,"南京市秦淮区99号","1","竖琴","178xxx","N");

        return Arrays.asList(address1, address2);
    }
}
