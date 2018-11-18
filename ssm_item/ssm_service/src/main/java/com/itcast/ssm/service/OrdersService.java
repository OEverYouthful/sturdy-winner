package com.itcast.ssm.service;

import com.itcast.ssm.domain.Orders;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/12 0012 21:36
 * @Description:
 */
public interface OrdersService {
 List<Orders> findAll(int page,int size);

 Orders findById(String id);
}
