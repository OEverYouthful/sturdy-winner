package com.itcast.ssm.dao;

import com.itcast.ssm.domain.Role;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/16 0016 18:13
 * @Description:
 */
public interface RoleDao {


@Select("select * from role")
 List<Role> findAll();


@Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
 void  save(Role role);
}
