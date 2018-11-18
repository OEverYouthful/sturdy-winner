package com.itcast.ssm.dao;

import com.itcast.ssm.domain.Permission;
import com.itcast.ssm.domain.Role;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/14 0014 21:27
 * @Description:
 */
public interface IRoleDao {

// @Select("select * from users_role ur left join Role r on r.id=ur.roleid where ur.userid = " +
//  "#{userid}")
@Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
@Results({
 @Result(id = true,property = "id",column = "id"),
 @Result(property = "roleName",column = "roleName"),
 @Result(property = "roleDesc",column = "roleDesc"),
 @Result(property = "permissions",column = "id",javaType = java.util.List.class,
 many = @Many(select = "com.itcast.ssm.dao.PermissionDao.findPermissionByRoleId")
 )
})
 List<Role> findRoleByUserId(String userid);

@Select("select * from role")
 List<Role> findAll();
}
