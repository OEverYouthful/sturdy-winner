package com.itcast.ssm.controller;

import com.itcast.ssm.domain.Role;
import com.itcast.ssm.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @Auther: Administrator
 * @Date: 2018/11/16 0016 18:08
 * @Description:
 */
@Controller
@RequestMapping("/role")
public class RoleController {

 @Autowired
 private RoleService roleService;

 @RequestMapping("/findAll.do")
 public ModelAndView findAll() throws Exception {
  ModelAndView mv = new ModelAndView();
  List<Role> roleList = roleService.findAll();
  mv.addObject("roleList", roleList);
  mv.setViewName("role-list");
  return mv;
 }


 @RequestMapping("/save.do")
 public String save(Role role) throws Exception {
roleService.save(role);
  return "redirect:findAll.do";
 }
}
