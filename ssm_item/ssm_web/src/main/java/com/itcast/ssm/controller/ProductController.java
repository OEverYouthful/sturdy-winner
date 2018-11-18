package com.itcast.ssm.controller;

import com.itcast.ssm.domain.Product;
import com.itcast.ssm.service.IProductService;
import com.itcast.ssm.utils.DateUtils;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.naming.Name;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/12 0012 14:06
 * @Description:
 */
@Controller
@RequestMapping("/product")
public class ProductController {

 @Autowired
 private IProductService iProductService;

 @RequestMapping("/findAll.do")
 public ModelAndView findAll() throws Exception {
  List<Product> list = iProductService.findAll();
  ModelAndView mv = new ModelAndView();
  System.out.println(">>>>>>>>>>>>>>>>>>>>>>>>>>>"+list);
  mv.addObject("productList", list);
  mv.setViewName("product-list");
  return mv;
 }

 @RequestMapping("/save.do")
 public String save(Product product) throws Exception {
//  Date date = DateUtils.string2Date(departureTimeStr, "dd-mm-yyyy hh:mi:ss");
//  product.setDepartureTime(date);
  iProductService.save(product);
      return "redirect:findAll.do";
 }
}
