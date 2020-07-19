package com.itheima.ssm.dao;/**
 * Created by Administrator on 2020/7/8 0008.
 */

import com.itheima.ssm.domain.Product;
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
 * @created 2020/7/8 0008 17:09
 */
public interface IProductDao {

    //根据id查询产品
    @Select("select * from product where id = #{id}")
    public Product findById(int id) throws Exception;
    //查询所有产品的信息
    @Select("select * from product")
    public List<Product> findAll() throws Exception;
    //添加商品
    @Insert("insert into product(productNum,productName,cityName,departureTime,productPrice,productDesc,productStatus) values(#{productNum},#{productName},#{cityName},#{departureTime},#{productPrice},#{productDesc},#{productStatus})")
    void save(Product product);
}
