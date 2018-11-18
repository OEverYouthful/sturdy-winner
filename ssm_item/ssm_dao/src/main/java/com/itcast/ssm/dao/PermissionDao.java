package com.itcast.ssm.dao;

import com.itcast.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/15 0015 18:44
 * @Description:
 */
public interface PermissionDao {

 @Select("select * from Permission where id =#{id}")
List<Permission> findById(String id);

 @Select("select * from permission")
 List<Permission> findAll();

 @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
 void save(Permission permission) throws Exception;

 @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id} )")
 public List<Permission> findPermissionByRoleId(String id) throws Exception;

}
