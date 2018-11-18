package com.itcast.ssm.dao;

import com.itcast.ssm.domain.Traveller;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/14 0014 11:37
 * @Description:
 */
public interface TravellerDao {

 @Select("select * from order_traveller ot left join traveller t on t.id = ot.travellerId where " +
  "ORDERID =#{id}")
 List<Traveller> findById(String id);
}
