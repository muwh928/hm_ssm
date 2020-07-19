package com.itheima.ssm.dao;/**
 * Created by Administrator on 2020/7/14 0014.
 */

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
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
 * @created 2020/7/14 0014 22:55
 */
public interface IRoleDao {

    //根据用户id查询出所有对应的角色,资源的类型是List，它根据id去查询permissions
    @Select("select * from role where id in (select roleId from users_role where userId=#{userId})")
    @Results({
            @Result(id = true,property = "id",column = "id"),
            @Result(property = "roleName",column = "roleName"),
            @Result(property = "roleDesc",column = "roleDesc"),
            @Result(property = "permissions",column = "id",javaType = java.util.List.class,many = @Many(select = "com.itheima.ssm.dao.IPermission.findPermissionByRoleId")),

    })
    public List<Role> findByUserId(int userId) throws Exception;

    //查询所有角色
    @Select("select * from role")
    List<Role> findAll() throws Exception;

    //添加角色
    @Insert("insert into role(roleName,roleDesc) values(#{roleName},#{roleDesc})")
    void save(Role role) throws Exception;

    //根据roleId查询role
    @Select("select * from role where id=#{roleId}")
    Role findById(int roleId)throws Exception;

    //查询这个角色没有关联的权限
    @Select("select * from permission where id not in (select permissionId from role_permission where roleId=#{roleId})")
    List<Permission> findOtherPermission(int roleId) throws Exception;

    //给角色添加权限
    @Insert("insert into role_permission(roleId,permissionId) values(#{roleId},#{permissionId})")
    void addPermissionRole(@Param("roleId") int roleId,@Param("permissionId") int permissionId);
}
