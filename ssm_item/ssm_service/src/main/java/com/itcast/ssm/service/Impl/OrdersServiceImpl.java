package com.itcast.ssm.service.Impl;

import com.github.pagehelper.PageHelper;
import com.itcast.ssm.dao.OrdersDao;
import com.itcast.ssm.domain.Orders;
import com.itcast.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/12 0012 21:36
 * @Description:
 */
@Service
public class OrdersServiceImpl implements OrdersService {

 @Autowired
 private OrdersDao ordersDao;

 @Override
 public List<Orders> findAll(int page, int size) {

//  实现分页
  PageHelper.startPage(page, size);
  List<Orders> all = ordersDao.findAll();
  return all;
 }

 @Override
 public Orders findById(String id) {
  Orders orders = ordersDao.findById(id);
  return orders;
 }
}
