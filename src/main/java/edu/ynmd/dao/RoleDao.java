package edu.ynmd.dao;

import edu.ynmd.model.Role;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author:lb
 * @date:2020/3/9 14:25
 * @description:角色管理jpa
 */
public interface RoleDao extends JpaRepository<Role ,String> {
}
