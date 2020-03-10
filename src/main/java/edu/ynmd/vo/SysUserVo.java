package edu.ynmd.vo;

import edu.ynmd.model.SysUser;

/**
 * @Author:lb
 * @date:2020/3/6 16:15
 * @description:
 */
public class SysUserVo extends SysUser {
    private String roleName;

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}
