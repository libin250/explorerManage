package edu.ynmd.service.interfaces;

import edu.ynmd.model.Role;
import edu.ynmd.tools.PageData;

import java.util.List;


/**
 * @Author:lb
 * @date:2020/3/9 14:28
 * @description:角色管理服务层接口
 */
public interface RoleService {
    /**
     * 添加、修改
     *
     * @param role
     * @return
     */
    String saveRole(Role role);


    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    Role findRoleById(String id);


    /**
     * 查询角色 分页查询
     *
     * @param pageNo
     * @param pageSize
     * @param role
     * @return
     */
    PageData findRoleList(int pageNo, int pageSize, Role role);


    /**
     * 根据角色状态查询
     * @param state
     * @return
     */
    List<Role> findRoleByState(byte state);

}
