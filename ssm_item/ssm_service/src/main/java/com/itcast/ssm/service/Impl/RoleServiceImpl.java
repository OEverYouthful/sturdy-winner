package com.itcast.ssm.service.Impl;

import com.itcast.ssm.dao.RoleDao;
import com.itcast.ssm.domain.Role;
import com.itcast.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/16 0016 18:12
 * @Description:
 */
@Service
@Transactional
public class RoleServiceImpl implements RoleService {

 @Autowired
 private RoleDao roleDao;

 @Override
 public List<Role> findAll() {
  List<Role> all = roleDao.findAll();
  return all;
 }

 @Override
 public void save(Role role) {

  roleDao.save(role);
 }
}
