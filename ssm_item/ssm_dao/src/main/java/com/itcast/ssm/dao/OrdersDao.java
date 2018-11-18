package com.itcast.ssm.dao;

import com.itcast.ssm.domain.Member;
import com.itcast.ssm.domain.Orders;
import com.itcast.ssm.domain.Product;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/12 0012 21:37
 * @Description:
 */
public interface OrdersDao {

 @Select("select * from orders")
 @Results({
  @Result(id = true, property = "id", column = "id"),
  @Result(property = "orderNum", column = "orderNum"),
  @Result(property = "orderTime", column = "orderTime"),
  @Result(property = "orderStatus", column = "orderStatus"),
  @Result(property = "peopleCount", column = "peopleCount"),
  @Result(property = "payType", column = "payType"),
  @Result(property = "orderDesc", column = "orderDesc"),
  @Result(property = "product", column = "productid", javaType = Product.class,
   one = @One(select = "com.itcast.ssm.dao.IProductDao.findById")
  )
 })
 List<Orders> findAll();

 @Select("select * from orders where id = #{id}")
 @Results({
  @Result(id = true, property = "id", column = "id"),
  @Result(property = "orderNum", column = "orderNum"),
  @Result(property = "orderTime", column = "orderTime"),
  @Result(property = "orderStatus", column = "orderStatus"),
  @Result(property = "peopleCount", column = "peopleCount"),
  @Result(property = "payType", column = "payType"),
  @Result(property = "orderDesc", column = "orderDesc"),
  @Result(property = "product", column = "productid", javaType = Product.class,
   one = @One(select = "com.itcast.ssm.dao.IProductDao.findById")),
  @Result(property = "member", column = "memberid", javaType = Member.class,
   one = @One(select = "com.itcast.ssm.dao.MemberDao.findById")),
  @Result(property = "travellers", column = "id", javaType = java.util.List.class,
   many = @Many(select = "com.itcast.ssm.dao.TravellerDao.findById"))
 })
 Orders findById(String id);
}
