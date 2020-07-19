package com.itheima.ssm.serviceimpl;/**
 * Created by Administrator on 2020/7/14 0014.
 */

import com.itheima.ssm.dao.IUserDao;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import com.itheima.ssm.service.IUserService;
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
 * <p>
 * Title:com.itheima.ssm.serviceimpl
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
 * @created 2020/7/14 0014 19:11
 */
@Service("userService")
@Transactional
public class UserServiceImpl implements IUserService {


    @Autowired
    private IUserDao userDao;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    /*
    查询用户
     */
    @Override
    public List<UserInfo> findAll() throws Exception {
        return userDao.findAll();
    }

    /**
     * 根据id查询用户
     * @param id
     * @return
     * @throws Exception
     */
    @Override
    public UserInfo findById(int id) throws Exception {
        return userDao.findById(id);
    }

    /**
     * 查询用户可以添加的角色
     * @param userId
     * @return
     */
    @Override
    public List<Role> findOtherRoles(int userId) throws Exception{
        return userDao.findOtherRoles(userId);
    }

    /**
     * 给用户添加角色
     * @param userId
     * @param roleIds
     */
    @Override
    public void addRoleToUser(int userId, int[] roleIds) throws Exception{
        for(int roleId:roleIds){
            userDao.addRoleIdUser(userId,roleId);
        }
    }

    /**
     * 添加用户
     * @param userInfo
     * @throws Exception
     */
    @Override
    public void save(UserInfo userInfo) throws Exception {
        //对密码进行加密
        userInfo.setPassword(bCryptPasswordEncoder.encode(userInfo.getPassword()));
        userDao.save(userInfo);
    }

    /*
        设置权限
         */
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserInfo userInfo = null;
        try {
            userInfo  = userDao.findByUsername(username);
        } catch (Exception e) {
            e.printStackTrace();
        }
        //由于方法的返回值是UserDetails，所以在这里需要把我们自己的用户对象封装成UserDetails
        //User类是security自带的
        //User user = new User(userInfo.getUsername(),"{noop}"+userInfo.getPassword(),getAuthority(userInfo.getRoles()));
        User user = new User(userInfo.getUsername(),userInfo.getPassword(),userInfo.getStatus() == 0 ? false : true,true,true,true,getAuthority(userInfo.getRoles()));
        return user;
    }

    /*
    为上面提供一个方法
     */
    public List<SimpleGrantedAuthority> getAuthority(List<Role> roles){
        List<SimpleGrantedAuthority> list = new ArrayList<>();
        for(Role role:roles) {
            list.add(new SimpleGrantedAuthority("ROLE_"+role.getRoleName()));
        }
        return list;
    }

}
