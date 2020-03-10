package edu.ynmd.controller;

import edu.ynmd.model.SysUser;
import edu.ynmd.service.Impl.UserServiceImpl;
import edu.ynmd.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

/**
 * @Author:lb
 * @date:2020/3/2 16:21
 * @description:用户管理控制层接口
 *
 */
@RestController
@RequestMapping("user")
@CrossOrigin
public class UserController {
    @Autowired
    private UserServiceImpl userServiceImpl;

    /**
     * 添加
     * @param user
     * @return
     */
    @PostMapping("saveUser")
    public Result saveUser(@RequestBody SysUser user){
        return Result.success(userServiceImpl.saveUser(user));
    }


    /**
     * 获取列表
     * @param user
     * @return
     */
    @GetMapping("findUserList")
    public Result findUserList(@RequestParam(defaultValue = "1",name="pageNo") int pageNo,
                               @RequestParam(defaultValue = "10",name="pageSize") int pageSize,
                              SysUser user) {
        return Result.success(userServiceImpl.findUserList(pageNo, pageSize, user));
    }

    /**
     * 查询单条
     * @param id
     * @return
     */
    @GetMapping("findUserById")
    public Result findUserById(String id){
        return Result.success(userServiceImpl.findUserById(id));
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("login")
    public Result login(HttpServletRequest request,@RequestBody SysUser user){
        return Result.success(userServiceImpl.login(request,user.getUserName(),user.getPassWord()));
    }


}
