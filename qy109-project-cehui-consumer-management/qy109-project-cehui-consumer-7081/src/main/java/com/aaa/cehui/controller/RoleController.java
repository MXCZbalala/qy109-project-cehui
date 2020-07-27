package com.aaa.cehui.controller;

import com.aaa.cehui.base.ResultData;
import com.aaa.cehui.model.Role;
import com.aaa.cehui.service.SystemApiService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

/**
 * @Author ltl
 * @Date 2020/7/27  11:21
 * @Description
 **/
@RestController
@Api(value = "角色管理", tags = "角色管理")
public class RoleController {
    @Autowired
    private SystemApiService systemApiService;


    /**
     * @Author LTL
     * @Description 分页查询所有角色信息
     * @Param [pageNo, pageSize]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/17  14:46
     * @Throws
     */
    @PostMapping("/selectAllRole")
    public ResultData selectAllRole(@RequestParam("pageNo")Integer pageNo,
                                    @RequestParam("pageSize")Integer pageSize){
        return systemApiService.selectAllRole(pageNo, pageSize);
    }

    /**
     * @Author LTL
     * @Description
     *      根据日期或角色名
     *      分页模糊查询角色信息
     * @Param [map, pageNo, pageSize]
     * @Return com.github.pagehelper.PageInfo
     * @DateTime 2020/7/17  16:48
     * @Throws
     */
    @PostMapping("/selectRoleByFiled")
    public ResultData selectRoleByFiled(@RequestBody Map map,
                                        @RequestParam("pageNo")Integer pageNo,
                                        @RequestParam("pageSize") Integer pageSize
    ){
        return systemApiService.selectRoleByFiled(map, pageNo, pageSize);
    }

    /**
     * @Author LTL
     * @Description 根据ID修改角色信息
     * @Param [role]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/17  16:56
     * @Throws
     */
    @PostMapping("/updateRoleById")
    public ResultData updateRoleById(@RequestBody Role role,
                                     @RequestParam("ids[]") List<Integer> ids){
        return systemApiService.updateRoleById(role, ids);
    }

    /**
     * @Author LTL
     * @Description 新增角色信息
     * @Param [role]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/17  17:02
     * @Throws
     */
    @PostMapping("/addRole")
    public ResultData addRole(@RequestBody Role role,
                              @RequestParam("ids[]")List<Integer> ids
    ){
        return systemApiService.addRole(role, ids);
    }

    /**
     * @Author LTL
     * @Description 批量删除角色信息
     * @Param [ids]
     * @Return com.aaa.cehui.base.ResultData
     * @DateTime 2020/7/20  19:23
     * @Throws
     */
    @PostMapping("/deleteRoleByIds")
    public ResultData deleteRoleByIds(@RequestParam("ids[]") List<Integer> ids){
        return systemApiService.deleteRoleByIds(ids);
    }

}
