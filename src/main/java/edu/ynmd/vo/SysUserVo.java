package edu.ynmd.vo;

import edu.ynmd.model.SysUser;

/**
 * @Author:lb
 * @date:2020/3/6 16:15
 * @description:
 */
public class SysUserVo extends SysUser {
    private String role_name;

    public String getRole_name() {
        return role_name;
    }

    public void setRole_name(String role_name) {
        this.role_name = role_name;
    }
}
