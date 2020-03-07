package edu.ynmd.service.Impl;

import edu.ynmd.dao.UserDao;
import edu.ynmd.model.SysUser;
import edu.ynmd.service.interfaces.UserService;
import edu.ynmd.tools.DataHelper;
import edu.ynmd.tools.PageData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;


/**
 * @Author:lb
 * @date:2020/3/2 16:17
 * @description:用户管理服务层实现
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserDao userDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public PageData findUserList(int pageNo, int pageSize, SysUser user) {
        String querySql = " select id,user_name,pass_word,user_true_name,user_sex,user_age,user_idnumber,user_phone,role_id,state from sys_user ";
        List<String> condSql = new ArrayList<>();
        if (null != user.getState()) {
            condSql.add("  state =" + user.getState());
        }
        if (null != user.getState()) {
            condSql.add("  user_sex =" + user.getUserSex());
        }
        if (StringUtils.hasText(user.getUserName())) {
            condSql.add("  user_name like '%" + user.getUserName() + "%'");
        }
        if (StringUtils.hasText(user.getUserPhone())) {
            condSql.add(" user_phone like '%" + user.getUserPhone() + "%'");
        }
        if (condSql.size() > 0) {
            querySql += " WHERE " + String.join(" AND ", condSql);
        }
        return DataHelper.pageQuery(jdbcTemplate, querySql + " order by user_name ", pageNo, pageSize, SysUser.class);
    }


    @Override
    public SysUser saveUser(SysUser user) {
        return userDao.save(user);
    }

    @Override
    public SysUser findUserById(String id) {
        return userDao.findById(id).orElse(null);
    }

    @Override
    public String login(String userName, String passWord) {
        return userDao.findByUserNameAndPassWord(userName, passWord) != null ? "登陆成功" : "登录失败";
    }
}
