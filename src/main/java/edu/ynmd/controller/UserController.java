package edu.ynmd.controller;

import edu.ynmd.model.SysUser;
import edu.ynmd.service.interfaces.UserService;
import edu.ynmd.tools.Result;
import edu.ynmd.tools.UserHelper;
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
    private UserService userService;

    /**
     * 添加
     * @param user
     * @return
     */
    @PostMapping("saveUser")
    public Result saveUser(@RequestBody SysUser user){
        return Result.success(userService.saveUser(user));
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
        return Result.success(userService.findUserList(pageNo, pageSize, user));
    }

    /**
     * 查询单条
     * @param id
     * @return
     */
    @GetMapping("findUserById")
    public Result findUserById(String id){
        return Result.success(userService.findUserById(id));
    }

    /**
     * 登录
     * @param user
     * @return
     */
    @PostMapping("login")
    public Result login(HttpServletRequest request,@RequestBody SysUser user){
        return Result.success(userService.login(request,user.getUserName(),user.getPassWord()));
    }


    /**
     * 获取session
     * @param request
     * @return
     */
    @GetMapping("getSession")
    public Result getSession(HttpServletRequest request){
        return Result.success(userService.getSession(request));
    }


}
