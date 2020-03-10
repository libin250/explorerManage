package edu.ynmd.service.Impl;

import edu.ynmd.dao.UserDao;
import edu.ynmd.model.SysUser;
import edu.ynmd.service.interfaces.UserService;
import edu.ynmd.tools.DataHelper;
import edu.ynmd.tools.PageData;
import edu.ynmd.tools.UserHelper;
import edu.ynmd.vo.SysUserVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import javax.servlet.http.HttpServletRequest;
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
        String querySql = "select id,role_id, (select role_name from role where id=sys_user.role_id) as role_name , " +
                "user_name,user_true_name,pass_word,user_sex,user_age,user_idnumber,user_phone,state from sys_user";
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
        return DataHelper.pageQuery(jdbcTemplate, querySql + " order by user_name,state ", pageNo, pageSize, SysUserVo.class);
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
    public SysUser getSession(HttpServletRequest request) {
        return UserHelper.getSession(request);
    }

    @Override
    public boolean removeSession(HttpServletRequest request) {
        UserHelper.removeSession(request);
        return true;
    }

    @Override
    public String login(HttpServletRequest request,String userName, String passWord) {
        SysUser user=userDao.findByUserNameAndPassWord(userName, passWord);
        if(user!=null){
            UserHelper.setSession(request,user);
            return  "登陆成功";
        }
        return  "登录失败";
    }


}
