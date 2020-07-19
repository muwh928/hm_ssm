package com.itheima.ssm.dao;/**
 * Created by Administrator on 2020/7/14 0014.
 */

import com.itheima.ssm.domain.Role;
import com.itheima.ssm.domain.UserInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * <p>
 * Title:com.itheima.ssm.dao
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
 * @created 2020/7/14 0014 19:17
 */
public interface IUserDao {

    //根据用户名查询用户信息，第二个是查询出来的结果集，封装一下
    @Select("select * from users where username=#{username}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.ssm.dao.IRoleDao.findByUserId")),

    })
    public UserInfo findByUsername(String username) throws Exception;

    //查询所有用户信息
    @Select("select * from users")
    List<UserInfo> findAll() throws Exception;

    //添加用户
    @Insert("insert into users(email,username,password,phoneNum,status) values(#{email},#{username},#{password},#{phoneNum},#{status})")
    void save(UserInfo userInfo) throws Exception;

    //用户详情
    @Select("select * from users where id =#{id}")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "username",column = "username"),
            @Result(property = "email",column = "email"),
            @Result(property = "password",column = "password"),
            @Result(property = "phoneNum",column = "phoneNum"),
            @Result(property = "status",column = "status"),
            @Result(property = "roles",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.ssm.dao.IRoleDao.findByUserId")),
    })
    UserInfo findById(int id) throws Exception;

    //查询用户可以添加的角色
    @Select("select * from role where id not in (select roleId from users_role where userId=#{userId})")
    List<Role> findOtherRoles(int userId) throws Exception;

    //给用户添加角色
    @Insert("insert into users_role(userId,roleId) values(#{userId},#{roleId})")
    void addRoleIdUser(@Param("userId") int userId, @Param("roleId") int roleId) throws Exception;
}
