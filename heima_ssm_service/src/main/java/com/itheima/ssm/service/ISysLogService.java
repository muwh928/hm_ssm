package com.itheima.ssm.service;/**
 * Created by Administrator on 2020/7/16 0016.
 */

import com.itheima.ssm.domain.SysLog;

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
 * @created 2020/7/16 0016 21:59
 */
public interface ISysLogService {

    public void save(SysLog sysLog)throws Exception;

    List<SysLog> findAll() throws Exception;
}
