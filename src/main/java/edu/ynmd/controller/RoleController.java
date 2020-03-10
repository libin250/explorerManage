package edu.ynmd.controller;

import edu.ynmd.model.Role;
import edu.ynmd.service.interfaces.RoleService;
import edu.ynmd.tools.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @Author:lb
 * @date:2020/3/10 13:38
 * @description:角色管理控制层接口
 */
@RestController
@RequestMapping("role")
@CrossOrigin
public class RoleController {
    @Autowired
    private RoleService roleService;

    /**
     * 添加  修改
     * @param role
     * @return
     */
    @PostMapping("savrRole")
    public Result saveRole(@RequestBody Role role){
        return Result.success(roleService.saveRole(role));
    }


    /**
     * 查询角色列表，分页查找
     * @param pageNo
     * @param pageSize
     * @param role
     * @return
     */
    @GetMapping("findRoleList")
    public Result findRoleList(@RequestParam(defaultValue = "1",name="pageNo") int pageNo,
                               @RequestParam(defaultValue = "10",name="pageSize") int pageSize,
                               Role role
                               ){
        return Result.success(roleService.findRoleList(pageNo,pageSize,role));
    }

    /**
     * 根据id查询
     * @param id
     * @return
     */
    @GetMapping("findRoleById")
    public Result findRoleById(String id){
        return Result.success(roleService.findRoleById(id));
    }

    /**
     * 查询状态为1的角色列表
     * @return
     */
    @GetMapping("findRoleByState")
    public Result findRoleByState(){
        return Result.success(roleService.findRoleByState((byte)1));
    }
}
