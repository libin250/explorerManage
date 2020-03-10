package edu.ynmd.service.interfaces;

import edu.ynmd.model.Role;

/**
 * @Author:lb
 * @date:2020/3/9 14:28
 * @description:角色管理服务层接口
 */
public interface RoleService {
    /**
     * 添加、修改
     * @param role
     * @return
     */
    String saveRole(Role role);



    Role getRoleById(String id);
}
