package com.home.gmall.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddress implements Serializable {

    private Integer id;

    private String userAddress;

    private String userId;

    private String consignee;//收货码

    private String phoneNum;

    private String isDefault;//是否为默认地址
}
