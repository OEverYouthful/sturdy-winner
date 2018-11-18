package com.itcast.ssm.controller;

import com.itcast.ssm.domain.Role;
import com.itcast.ssm.domain.UserInfo;
import com.itcast.ssm.service.IUserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import javax.naming.Name;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/15 0015 17:22
 * @Description:
 */
@Controller
@RequestMapping("/user")
public class UsersController {

 @Autowired
 private IUserService iUserService;


 @RolesAllowed({"UUU","superman"})
 @PreAuthorize("hasRole('ROLE_UUU')")
 @RequestMapping("/findAll.do")
 ModelAndView findAll() {
  ModelAndView mv = new ModelAndView();
  List<UserInfo> users = iUserService.findAll();
  mv.addObject("userList", users);
  mv.setViewName("user-list");
  return mv;

 }

 @Secured("ROLE_UUU")
 @PreAuthorize("authentication.principal.username == 'tom'")
 @RequestMapping("/save")
 String save(UserInfo userInfo) {
  ModelAndView mv = new ModelAndView();
  iUserService.save(userInfo);
  return "redirect:findAll.do";
 }


 //查询用户以及用户可以添加的角色
 @RequestMapping("/findUserByIdAndAllRole.do")
 public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id", required = true) String userid) throws Exception {
  ModelAndView mv = new ModelAndView();
  //1.根据用户id查询用户
  UserInfo userInfo = iUserService.findById(userid);
  //2.根据用户id查询可以添加的角色
  List<Role> otherRoles = iUserService.findOtherRoles(userid);
  mv.addObject("user", userInfo);
  mv.addObject("roleList", otherRoles);
  mv.setViewName("user-role-add");
  return mv;
 }

 @RequestMapping("/findById.do")
 public ModelAndView findById(String id) throws Exception {
  ModelAndView mv = new ModelAndView();
  UserInfo userInfo = iUserService.findById(id);
  mv.addObject("user", userInfo);
  mv.setViewName("user-show");
  return mv;
 }


 //给用户添加角色
 @RequestMapping("/addRoleToUser.do")
 public String addRoleToUser(@RequestParam(name = "userId", required = true) String userId, @RequestParam(name = "ids", required = true) String[] roleIds) {
  iUserService.addRoleToUser(userId, roleIds);
  return "redirect:findAll.do";
 }

}
