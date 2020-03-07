package edu.ynmd.model;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Objects;

/**
 * @Author:lb
 * @date:2020/3/2 15:09
 * @description:菜单模型类
 */
@Entity
public class Functions {
    private String id;
    private String name;
    private String pid;
    private String url;
    private Byte state;

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
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
                Objects.equals(name, functions.name) &&
                Objects.equals(pid, functions.pid) &&
                Objects.equals(url, functions.url) &&
                Objects.equals(state, functions.state);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, pid, url, state);
    }
}
