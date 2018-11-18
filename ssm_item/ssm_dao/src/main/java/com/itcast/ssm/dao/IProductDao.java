package com.itcast.ssm.dao;


import com.itcast.ssm.domain.Product;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/12 0012 10:55
 * @Description:
 */
@Repository
public interface IProductDao {

 @Select("select * from product")
 List<Product> findAll() throws Exception;

 @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) " +
  "values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
 void save(Product product) throws Exception;

 @Select("select * from product where id =#{id}")
 Product findById(String id)throws Exception;
}
