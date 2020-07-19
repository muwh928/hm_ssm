package com.itheima.ssm.dao;/**
 * Created by Administrator on 2020/7/14 0014.
 */

import com.itheima.ssm.domain.Traveller;
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
 * @created 2020/7/14 0014 12:02
 */
public interface ITravellerDao {

    //先从中间表根据订单id查询出游客id，在用这个游客id去游客表里面查询出游客的所有信息
    @Select("select * from traveller where id in (select travellerId from order_traveller where orderId=#{ordersId})")
    public List<Traveller> findByOrdersId(int ordersId) throws Exception;
}
