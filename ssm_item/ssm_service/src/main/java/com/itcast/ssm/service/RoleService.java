package com.itcast.ssm.service;

import com.itcast.ssm.domain.Role;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/16 0016 18:11
 * @Description:
 */
public interface RoleService {

 List<Role> findAll();

 void save(Role role);
}
