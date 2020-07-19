package com.itheima.ssm.controller;/**
 * Created by Administrator on 2020/7/15 0015.
 */

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
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
 * @created 2020/7/15 0015 15:02
 */
@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private IUserService userService;

    /**
     * 查询用户以及用户可以添加的角色
     */
    @RequestMapping("/findUserByIdAndAllRole.do")
    public ModelAndView findUserByIdAndAllRole(@RequestParam(name = "id",required = true ) int userId) throws Exception {
        ModelAndView mv = new ModelAndView();
        //根据用户id查询用户
        UserInfo userInfo = userService.findById(userId);
        //根据用户id查询可以添加的角色
        List<Role> otherRoles = userService.findOtherRoles(userId);
        mv.addObject("user",userInfo);
        mv.addObject("roleList",otherRoles);
        mv.setViewName("user-role-add");
        return mv;
    }

    /**
     * 给用户添加角色
     * @param userId
     * @param roleIds
     */
    @RequestMapping("/addRoleToUser.do")
    public String addRoleToUser(@RequestParam(name = "userId",required = true) int userId,@RequestParam(name = "ids",required = true) int[] roleIds) throws Exception {
        userService.addRoleToUser(userId,roleIds);
        return "redirect:findAll.do";
    }

    /*
    查询所有用户
     */
    @RequestMapping("/findAll.do")
    public ModelAndView findAll() throws Exception {
        ModelAndView mv = new ModelAndView();
        List<UserInfo> userInfoList = userService.findAll();
        mv.addObject("userList",userInfoList);
        mv.setViewName("user-list");
        return mv;
    }
    /*
    查询指定id用户(用户详情)
    出现问题：user1的admin角色的下拉框里面的资源权限显示不了
    解决：将user-show.jsp页面的ata-tt-parent-id改为vs.index+1
     */
    @RequestMapping("/findById.do")
    public ModelAndView findById(int id) throws Exception {
        ModelAndView mv = new ModelAndView();
        UserInfo userInfo = userService.findById(id);
        mv.addObject("user",userInfo);
        mv.setViewName("user-show");
        return mv;
    }

    /*
    添加用户
     */
    @RequestMapping("/save.do")
    public String save(UserInfo userInfo) throws Exception{
        userService.save(userInfo);
        //添加完成后，应该再去查询一下用户信息
        return "redirect:findAll.do";
    }
}
