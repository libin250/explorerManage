package edu.ynmd.model;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author:lb
 * @date:2020/3/6 11:34
 * @description:
 */
@Entity
@Table(name = "sys_user", schema = "test", catalog = "")
public class SysUser {
    private String id;
    private String roleId;
    private String userName;
    private String passWord;
    private String userTrueName;
    private Byte userSex;
    private Byte userAge;
    private String userIdnumber;
    private String userPhone;
    private Byte state;

    @Id
    @Column(name = "id")
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Basic
    @Column(name = "role_id")
    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Basic
    @Column(name = "user_name")
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Basic
    @Column(name = "pass_word")
    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    @Basic
    @Column(name = "user_true_name")
    public String getUserTrueName() {
        return userTrueName;
    }

    public void setUserTrueName(String userTrueName) {
        this.userTrueName = userTrueName;
    }

    @Basic
    @Column(name = "user_sex")
    public Byte getUserSex() {
        return userSex;
    }

    public void setUserSex(Byte userSex) {
        this.userSex = userSex;
    }

    @Basic
    @Column(name = "user_age")
    public Byte getUserAge() {
        return userAge;
    }

    public void setUserAge(Byte userAge) {
        this.userAge = userAge;
    }

    @Basic
    @Column(name = "user_idnumber")
    public String getUserIdnumber() {
        return userIdnumber;
    }

    public void setUserIdnumber(String userIdnumber) {
        this.userIdnumber = userIdnumber;
    }

    @Basic
    @Column(name = "user_phone")
    public String getUserPhone() {
        return userPhone;
    }

    public void setUserPhone(String userPhone) {
        this.userPhone = userPhone;
    }

    @Basic
    @Column(name = "state")
    public Byte getState() {
        return state;
    }

    public void setState(Byte state) {
        this.state = state;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SysUser sysUser = (SysUser) o;
        return Objects.equals(id, sysUser.id) &&
                Objects.equals(roleId, sysUser.roleId) &&
                Objects.equals(userName, sysUser.userName) &&
                Objects.equals(passWord, sysUser.passWord) &&
                Objects.equals(userTrueName, sysUser.userTrueName) &&
                Objects.equals(userSex, sysUser.userSex) &&
                Objects.equals(userAge, sysUser.userAge) &&
                Objects.equals(userIdnumber, sysUser.userIdnumber) &&
                Objects.equals(userPhone, sysUser.userPhone) &&
                Objects.equals(state, sysUser.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleId, userName, passWord, userTrueName, userSex, userAge, userIdnumber, userPhone, state);
    }
}
