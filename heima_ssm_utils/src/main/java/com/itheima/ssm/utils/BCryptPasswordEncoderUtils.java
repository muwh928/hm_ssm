package com.itheima.ssm.utils;/**
 * Created by Administrator on 2020/7/15 0015.
 */

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

/**
 * <p>
 * Title:com.itheima.ssm.utils
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
 * @created 2020/7/15 0015 17:15
 */
public class BCryptPasswordEncoderUtils {
    private static BCryptPasswordEncoder bCryptPasswordEncoder=new BCryptPasswordEncoder();
    public static String encodePassword(String password){
        return bCryptPasswordEncoder.encode(password);
    }

    public static void main(String[] args) {
        String password="123";
        String pwd = encodePassword(password);
        //$2a$10$tJHudmJh6MRPdiL7mv0yfe0nZJbDHuhl7sSTnqNC4DauMik9ppi4K
        //$2a$10$Ce8LB3jdYDZ2f6HB281zA.4eC7v6ziJdK8MMWg0Yu8ETMg5ToMpIe
        //$2a$10$cTBkeQlDbbIUACgKhFuYwOTxtgZiIlhglfC7QPBQcr3OsEvBsSmQa
        System.out.println(pwd);
        System.out.print(pwd.length());
    }
}
