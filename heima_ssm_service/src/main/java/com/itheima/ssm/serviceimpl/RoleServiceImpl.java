package com.itheima.ssm.serviceimpl;/**
 * Created by Administrator on 2020/7/15 0015.
 */

import com.itheima.ssm.dao.IRoleDao;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.domain.Role;
import com.itheima.ssm.service.IRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

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
 * @created 2020/7/15 0015 22:05
 */
@Service
@Transactional
public class RoleServiceImpl implements IRoleService{

    @Autowired
    private IRoleDao roleDao;

    /**
     * 添加角色
     * @param role
     * @throws Exception
     */
    @Override
    public void save(Role role) throws Exception {
        roleDao.save(role);
    }

    /**
     * 根据roleId查询role
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public Role findById(int roleId) throws Exception {
        return roleDao.findById(roleId);
    }

    /**
     * 根据roleId查询可以添加的权限
     * @param roleId
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> findOtherPermission(int roleId) throws Exception {
        return roleDao.findOtherPermission(roleId);
    }

    /**
     给角色添加权限
     * @param roleId
     * @param permissionIds
     * @throws Exception
     */
    @Override
    public void addPermissionRole(int roleId, int[] permissionIds) throws Exception {
        for (int permissionId:permissionIds){
            roleDao.addPermissionRole(roleId,permissionId);
        }
    }

    /**
     * 查询所有角色
     * @return
     * @throws Exception
     */
    @Override
    public List<Role> findAll() throws Exception {
        return roleDao.findAll();
    }
}
