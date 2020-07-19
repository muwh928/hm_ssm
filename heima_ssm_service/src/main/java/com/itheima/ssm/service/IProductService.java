package com.itheima.ssm.service;/**
 * Created by Administrator on 2020/7/9 0009.
 */

import com.itheima.ssm.domain.Product;

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
 * @created 2020/7/9 0009 16:03
 */
public interface IProductService {

    public List<Product> findAll() throws Exception;

    void save(Product product) throws Exception;
}
