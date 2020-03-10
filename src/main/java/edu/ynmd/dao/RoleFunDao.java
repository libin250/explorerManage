package edu.ynmd.dao;

import edu.ynmd.model.RoleFun;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author:lb
 * @date:2020/3/9 14:26
 * @description:权限管理jpa接口
 */
public interface RoleFunDao extends JpaRepository<RoleFun ,String> {
}
