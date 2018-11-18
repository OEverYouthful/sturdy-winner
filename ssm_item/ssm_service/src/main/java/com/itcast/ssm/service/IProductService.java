package com.itcast.ssm.service;

import com.itcast.ssm.domain.Product;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/12 0012 11:01
 * @Description:
 */
public interface IProductService {
 List<Product> findAll() throws Exception;

 void save(Product product) throws Exception;
}
