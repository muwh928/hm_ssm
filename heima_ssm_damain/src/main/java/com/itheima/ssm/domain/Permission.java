package com.itheima.ssm.domain;/**
 * Created by Administrator on 2020/7/14 0014.
 */

import java.util.List;

/**
 * <p>
 * Title:com.itheima.ssm.domain
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
 * @created 2020/7/14 0014 19:21
 */
public class Permission {
    private String id;
    private String permissionName;
    private String url;
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getPermissionName() {
        return permissionName;
    }

    public void setPermissionName(String permissionName) {
        this.permissionName = permissionName;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    private List<Role> roles;
}
