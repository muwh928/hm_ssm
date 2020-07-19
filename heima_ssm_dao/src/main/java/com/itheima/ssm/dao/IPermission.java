package com.itheima.ssm.dao;/**
 * Created by Administrator on 2020/7/15 0015.
 */

import com.itheima.ssm.domain.Permission;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;

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
 * @created 2020/7/15 0015 20:54
 */
public interface IPermission {

    //先根据roleId在中间表查询出该用户所具有的资源id，在用这个资源id在资源表里面查询出资源信息
    @Select("select * from permission where id in (select permissionId from role_permission where roleId=#{id})")
    public List<Permission> findPermissionByRoleId(int id) throws Exception;

    //查询所有资源
    @Select("select * from permission")
    public List<Permission> findAll() throws Exception;

    //添加资源权限
    @Insert("insert into permission(permissionName,url) values(#{permissionName},#{url})")
    void save(Permission permission) throws Exception;
}
