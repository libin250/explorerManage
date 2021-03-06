package edu.ynmd.service.interfaces;

import edu.ynmd.model.SysUser;
import edu.ynmd.tools.PageData;
import javax.servlet.http.HttpServletRequest;


/**
 * @Author:lb
 * @date:2020/3/6 16:11
 * @description:用户管理服务层接口
 */
public interface UserService {

    /**
     * 分页查找
     * @param pageNo
     * @param pageSize
     * @param user
     * @return
     */
    PageData findUserList(int pageNo, int pageSize , SysUser user);

    /**
     * 添加  修改
     * @param user
     * @return
     */
    SysUser saveUser(SysUser user);

    /**
     * 用户登录
     * @param userName
     * @param passWord
     * @return
     */
    String login(HttpServletRequest request,String userName, String passWord);


    /**
     * 根据id查询
     * @param id
     * @return
     */
    SysUser findUserById(String id);


    /**
     * 获取session
     * @param request
     * @return
     */
    SysUser getSession(HttpServletRequest request);

    /**
     * 删除session
     * @param request
     */
    boolean removeSession(HttpServletRequest request);

}
