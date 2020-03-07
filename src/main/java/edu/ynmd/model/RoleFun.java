package edu.ynmd.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author:lb
 * @date:2020/3/2 15:09
 * @description:权限模型类
 */
@Entity
@Table(name = "role_fun", schema = "test", catalog = "")
public class RoleFun {
    private String id;
    private String roleId;
    private String funId;

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
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
    @Column(name = "fun_id")
    public String getFunId() {
        return funId;
    }

    public void setFunId(String funId) {
        this.funId = funId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RoleFun roleFun = (RoleFun) o;
        return Objects.equals(id, roleFun.id) &&
                Objects.equals(roleId, roleFun.roleId) &&
                Objects.equals(funId, roleFun.funId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, roleId, funId);
    }
}
