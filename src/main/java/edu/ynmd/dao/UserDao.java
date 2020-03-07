package edu.ynmd.dao;

import edu.ynmd.model.SysUser;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @Author:lb
 * @date:2020/3/2 15:10
 * @description:用户jpa接口
 */
public interface UserDao extends JpaRepository<SysUser,String> {
    SysUser findByUserNameAndPassWord(String userName,String passWord);

}
