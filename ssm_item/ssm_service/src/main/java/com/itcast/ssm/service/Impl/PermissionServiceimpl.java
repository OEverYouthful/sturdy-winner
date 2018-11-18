package com.itcast.ssm.service.Impl;

import com.itcast.ssm.dao.PermissionDao;
import com.itcast.ssm.domain.Permission;
import com.itcast.ssm.service.PermissionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/16 0016 18:32
 * @Description:
 */
@Service
public class PermissionServiceimpl implements PermissionService {

 @Autowired
 private PermissionDao permissionDao;

 @Override
 public List<Permission> findAll() {
  List<Permission> all = permissionDao.findAll();
  return all;
 }

 @Override
 public void save(Permission permission) throws Exception{
  permissionDao.save(permission);
 }
}
