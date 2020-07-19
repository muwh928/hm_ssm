package com.itheima.ssm.serviceimpl;/**
 * Created by Administrator on 2020/7/16 0016.
 */

import com.itheima.ssm.dao.ISysLogDao;
import com.itheima.ssm.domain.SysLog;
import com.itheima.ssm.service.ISysLogService;
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
 * @created 2020/7/16 0016 22:00
 */
@Service
@Transactional
public class SysLogServiceImpl implements ISysLogService {

    @Autowired
    private ISysLogDao sysLogDao;

    /**
     * 添加日志
     * @param sysLog
     * @throws Exception
     */
    @Override
    public void save(SysLog sysLog) throws Exception {
        sysLogDao.save(sysLog);
    }

    /**
     * 查询所有日志
     * @return
     * @throws Exception
     */
    @Override
    public List<SysLog> findAll() throws Exception {
        return sysLogDao.findAll();
    }
}
