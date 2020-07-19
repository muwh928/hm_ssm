package com.itheima.ssm.service;/**
 * Created by Administrator on 2020/7/15 0015.
 */

import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;

import java.util.List;

/**
 * <p>
 * Title:com.itheima.ssm.service
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
 * @created 2020/7/15 0015 22:05
 */
public interface IRoleService {

    public List<Role> findAll() throws Exception;

    void save(Role role) throws Exception;

    Role findById(int roleId) throws Exception;

    List<Permission> findOtherPermission(int roleId) throws Exception;

    void addPermissionRole(int roleId, int[] permissionIds) throws Exception;
}
