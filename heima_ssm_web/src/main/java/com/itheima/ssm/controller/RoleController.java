package com.itheima.ssm.controller;/**
 * Created by Administrator on 2020/7/15 0015.
 */

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;

/**
 * <p>
 * Title:com.itheima.ssm.controller
 * </p>
 * <p/>
 * <p>
 * Description: 描述【】
 * </p>
 * <p/>
 * <p>
 * Copyright: Copyright (c) 2018
 * </p>
 * <p/>
 * <p>
 * Company: 英才汇硕信息技术有限公司
 * </p>
 *
 * @author mwh
 * @version 1.0
 * @created 2020/7/15 0015 22:02
 */
@Controller
@RequestMapping("/role")
public class RoleController {

    @Autowired
    private IRoleService roleService;

    /**
     * 给角色添加权限
     * @param roleId
     * @param permissionIds
     */
    @RequestMapping("/addPermissionToRole.do")
    public String addPermissionToRole(@RequestParam(name = "roleId",required = true) int roleId,@RequestParam(name = "ids",required = true) int[] permissionIds) throws Exception {
        roleService.addPermissionRole(roleId,permissionIds);
        return "redirect:findAll.do";
    }


    /**
     * 根据roleId查询role，并查询出可以添加的权限
     * @param roleId
     */
    @RequestMapping("/findRoleByIdAndAllPermission.do")       //来指定传过来的名字叫什么
    public ModelAndView findRoleByIdAndAllPermission(@RequestParam(name = "id",required = true) int roleId) throws Exception{
        ModelAndView mv = new ModelAndView();
        //根据roleId查询role
        Role role = roleService.findById(roleId);
        //根据roleId查询可以添加的权限
        List<Permission> otherPermissions =  roleService.findOtherPermission(roleId);
        mv.addObject("role",role);
        mv.addObject("permissionList",otherPermissions);
        mv.setViewName("role-permission-add");//在这个页面上完成我们角色和权限的关联，要带着一些数据
        return mv;
    }

    /**
     * 添加角色
     * @param role
     * @return
     * @throws Exception
     */
    @RequestMapping("/save.do")
    public String save(Role role) throws Exception {
        roleService.save(role);
        return "redirect:findAll.do";
    }

    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<Role> roleList = roleService.findAll();
        mv.addObject("roleList",roleList);
        mv.setViewName("role-list");
        return mv;
    }
}
