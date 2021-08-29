package com.home.gmall.service;



import com.home.gmall.pojo.UserAddress;

import java.util.List;

public interface UserService {

    /**
     * 按照用户id返回所有的收获地址
     * @param userId
     * @return
     */
    public List<UserAddress> getUserAddressList(String userId);
}
