package edu.ynmd.service.Impl;

import edu.ynmd.dao.RoleDao;
import edu.ynmd.model.Role;
import edu.ynmd.service.interfaces.RoleService;
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
 * @date:2020/3/10 11:43
 * @description:角色管理服务层
 */
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleDao roleDao;
    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Override
    public String saveRole(Role role) {
        return roleDao.save(role) != null ? "添加成功" : "添加失败";
    }

    @Override
    public Role findRoleById(String id) {
        return roleDao.findById(id).orElse(null);
    }

    @Override
    public PageData findRoleList(int pageNo, int pageSize, Role role) {
        String querySql = " select id,role_name,state from role ";
        List<String> condSql = new ArrayList<>();
        if (null != role.getState()) {
            condSql.add("  state =" + role.getState());
        }
        if (StringUtils.hasText(role.getRoleName())) {
            condSql.add("  role_name like '%" + role.getRoleName() + "%'");
        }
        if (condSql.size() > 0) {
            querySql += " WHERE " + String.join(" AND ", condSql);
        }
        return DataHelper.pageQuery(jdbcTemplate, querySql + " order by rile_name,state ", pageNo, pageSize, Role.class);
    }

    @Override
    public List<Role> findRoleByState(byte state) {
        return roleDao.findByState(state);
    }
}
