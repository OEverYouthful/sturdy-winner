package com.itcast.ssm.service.Impl;

import com.itcast.ssm.dao.IUserDao;
import com.itcast.ssm.domain.Role;
import com.itcast.ssm.domain.UserInfo;
import com.itcast.ssm.service.IUserService;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/14 0014 21:11
 * @Description:
 */
@Service("userService")
@Transactional
public class IUserServiceImpl implements IUserService {

 @Autowired
 private BCryptPasswordEncoder bCryptPasswordEncoder;

 @Autowired
 private IUserDao userDao;

 //根据用户名查找到一个用户，存入封装的user（UserDetails），根据前端接收的密码进行验证
 @Override
 public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {

  UserInfo userInfo = null;
  try {
   userInfo = userDao.findByUsername(s);
   System.out.println(userInfo);
   List<Role> roles = userInfo.getRoles();
   System.out.println(roles);
  } catch (Exception e) {
   e.printStackTrace();
  }
  //处理自己的用户对象封装成UserDetails。为了使用状态码，所以不使用3参数的构造方法
  //  User user=new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
  //未密码加密时，须加前缀
  User user = new User(userInfo.getUsername(), userInfo.getPassword(), userInfo.getStatus() == 0 ? false : true,
   true, true, true, getAuthority(userInfo.getRoles()));
  return user;
 }

 //作用就是返回一个List集合，集合中装入的是角色描述
 //user实现的GrantedAuthority接口的子实现类SimpleGrantedAuthority
 //为使用数据库中的角色，所以传入查找到的Role角色（类似管理员身份？）
 public List<SimpleGrantedAuthority> getAuthority(List<Role> roles) {

  List<SimpleGrantedAuthority> list = new ArrayList<>();
  for (Role role : roles) {
//   list.add(new SimpleGrantedAuthority("ROLE_USER")
   list.add(new SimpleGrantedAuthority("ROLE_" + role.getRoleName()));
  }
  return list;
 }

 @Override
 public List<UserInfo> findAll() {
  List<UserInfo> all = userDao.findAll();
  return all;
 }

 @Override
 public void save(UserInfo userInfo) {

  userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
  userDao.save(userInfo);
//  String encode = bCryptPasswordEncoder.encode("123");
//  System.out.println(">>>>>"+encode);
 }


 @Override
 public UserInfo findById(String id) {

  return userDao.findById(id);
 }


 @Override
 public void addRoleToUser(String userId, String[] roleIds) {

  for(String roleId:roleIds){
   userDao.addRoleToUser(userId,roleId);
  }
 }

 @Override
 public List<Role> findOtherRoles(String userId) {
  return userDao.findOtherRoles(userId);
 }

}
