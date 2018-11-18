package com.itcast.ssm.service;

import com.itcast.ssm.domain.Permission;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/16 0016 18:32
 * @Description:
 */
public interface PermissionService {

 List<Permission> findAll();

 void save(Permission permission) throws Exception;
}
