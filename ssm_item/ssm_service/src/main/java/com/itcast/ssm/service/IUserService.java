package com.itcast.ssm.service;

import com.itcast.ssm.domain.Role;
import com.itcast.ssm.domain.UserInfo;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsChecker;
import org.springframework.security.core.userdetails.UserDetailsService;

import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/14 0014 21:10
 * @Description:
 */
public interface IUserService extends UserDetailsService{

 List<UserInfo> findAll();

 void save(UserInfo userInfo);



 UserInfo findById(String id);

 void addRoleToUser(String userid, String[] roleids);

 List<Role> findOtherRoles(String userId) throws Exception;
}
