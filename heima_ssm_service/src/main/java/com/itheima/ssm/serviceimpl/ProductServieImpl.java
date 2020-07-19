package com.itheima.ssm.serviceimpl;/**
 * Created by Administrator on 2020/7/9 0009.
 */

import com.itheima.ssm.dao.IProductDao;
import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
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
 * @created 2020/7/9 0009 16:05
 */
@Service
@Transactional
public class ProductServieImpl implements IProductService{

    @Autowired
    private IProductDao productDao;

    @Override
    public void save(Product product) throws Exception {
        productDao.save(product);
    }

    @Override
    public List<Product> findAll() throws Exception {
        return productDao.findAll();
    }
}
