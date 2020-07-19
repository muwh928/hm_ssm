package com.itheima.ssm.serviceimpl;/**
 * Created by Administrator on 2020/7/15 0015.
 */

import com.itheima.ssm.dao.IPermission;
import com.itheima.ssm.domain.Permission;
import com.itheima.ssm.service.IPermissionService;
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
 * @created 2020/7/15 0015 22:51
 */
@Service
@Transactional
public class PermissionServiceImpl implements IPermissionService {

    @Autowired
    private IPermission permissionDao;

    /**
     * 查询所有资源
     * @return
     * @throws Exception
     */
    @Override
    public List<Permission> findAll() throws Exception {
        return permissionDao.findAll();
    }

    /**
     * 添加资源
     * @param permission
     * @throws Exception
     */
    @Override
    public void save(Permission permission) throws Exception {
        permissionDao.save(permission);
    }
}
