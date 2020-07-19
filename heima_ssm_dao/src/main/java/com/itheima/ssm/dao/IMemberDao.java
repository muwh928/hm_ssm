package com.itheima.ssm.dao;/**
 * Created by Administrator on 2020/7/14 0014.
 */

import com.itheima.ssm.domain.Member;
import org.apache.ibatis.annotations.Select;

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
 * @created 2020/7/14 0014 11:42
 */
public interface IMemberDao {

    @Select("select * from member where id = #{id}")
    public Member findById(int id);
}
