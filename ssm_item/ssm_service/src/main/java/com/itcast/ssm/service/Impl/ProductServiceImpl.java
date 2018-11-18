package com.itcast.ssm.service.Impl;

import com.itcast.ssm.dao.IProductDao;
import com.itcast.ssm.domain.Product;
import com.itcast.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/12 0012 13:59
 * @Description:
 */
@Service
@Transactional
public class ProductServiceImpl implements IProductService {

 @Autowired
 private IProductDao iProductDao;

 public List<Product> findAll() throws Exception {
  List<Product> list = iProductDao.findAll();
  return list;
 }

 @Override
 public void save(Product product) throws Exception {
  iProductDao.save(product);
 }
}
