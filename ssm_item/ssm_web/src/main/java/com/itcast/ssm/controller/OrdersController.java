package com.itcast.ssm.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.itcast.ssm.domain.Orders;
import com.itcast.ssm.service.OrdersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/12 0012 21:32
 * @Description:
 */
@Controller
@RequestMapping("/orders")
public class OrdersController {

 @Autowired
 private OrdersService ordersService;

 @RequestMapping("/findAll.do")
 ModelAndView findAll(@RequestParam(name = "page",required = true,defaultValue = "1") int page,
                      @RequestParam(name = "size",required = true,defaultValue = "5") int size
                      ){
  ModelAndView mv = new ModelAndView();
  List<Orders> orders = ordersService.findAll(page,size);
  PageInfo pi = new PageInfo(orders);
  mv.addObject("pi",pi);
  mv.setViewName("orders-list");
  return mv;
}


@RequestMapping("/findById.do")
ModelAndView findById(@RequestParam(name = "id")String ordersId){
 ModelAndView mv = new ModelAndView();
 Orders orders = ordersService.findById(ordersId);
mv.addObject("orders",orders);
mv.setViewName("orders-show");
 return mv;
}
}
