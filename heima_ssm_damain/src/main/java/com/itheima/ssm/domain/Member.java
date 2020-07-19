package com.itheima.ssm.domain;/**
 * Created by Administrator on 2020/7/12 0012.
 */

/**
 * <p>
 * Title:com.itheima.ssm.domain
 * </p>
 * <p/>
 * <p>
 * Description: 描述【会员（联系人）】
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
 * @created 2020/7/12 0012 12:05
 */
public class Member {
    private String id;
    private String name;//姓名
    private String nickname;//昵称
    private String phoneNum;//电话号码
    private String email;//邮箱

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
