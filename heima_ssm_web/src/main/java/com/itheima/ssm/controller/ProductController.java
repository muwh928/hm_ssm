package com.itheima.ssm.controller;/**
 * Created by Administrator on 2020/7/9 0009.
 */

import com.itheima.ssm.domain.Product;
import com.itheima.ssm.service.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.security.RolesAllowed;
import java.util.List;

/**
 * <p>
 * Title:com.itheima.ssm.controller
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
 * @created 2020/7/9 0009 16:36
 */
@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService productService;

    //添加商品
    @RequestMapping("/save.do")
    public String save(Product product) throws Exception{
        productService.save(product);
        return "redirect:findAll.do";
    }

    //查询全部产品
    @RequestMapping("/findAll.do")
    @RolesAllowed("admin")
    public ModelAndView findAll() throws Exception{
        ModelAndView mv = new ModelAndView();
        List<Product> ps = productService.findAll();
        System.out.println(ps);
        mv.addObject("productList",ps);
        //对应jsp页面的名字
        mv.setViewName("product-list1");
        return mv;
    }

}
