package edu.ynmd.model;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * @Author:lb
 * @date:2020/3/10 13:33
 * @description:
 */
@Entity
public class Functions {
    private String id;
    private String funName;
    private String pid;
    private String url;
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
    @Column(name = "fun_name")
    public String getFunName() {
        return funName;
    }

    public void setFunName(String funName) {
        this.funName = funName;
    }

    @Basic
    @Column(name = "pid")
    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    @Basic
    @Column(name = "url")
    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
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
        Functions functions = (Functions) o;
        return Objects.equals(id, functions.id) &&
                Objects.equals(funName, functions.funName) &&
                Objects.equals(pid, functions.pid) &&
                Objects.equals(url, functions.url) &&
                Objects.equals(state, functions.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, funName, pid, url, state);
    }
}
