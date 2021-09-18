package xyz.wjw.priviligemanagementsystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.NonNull;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.wjw.priviligemanagementsystem.bo.RoleDeleteBo;
import xyz.wjw.priviligemanagementsystem.bo.RoleSelectBo;
import xyz.wjw.priviligemanagementsystem.entity.Role;
import xyz.wjw.priviligemanagementsystem.service.RoleService;
import xyz.wjw.priviligemanagementsystem.vo.Result;

import java.util.List;

/**
 * @author ASUS
 */
@Api(tags="角色管理")
@CrossOrigin
@RestController
@RequestMapping(value="/user")
public class RoleController {

    private final RoleService roleService;

    public RoleController(RoleService roleService){
        this.roleService = roleService;
    }


    @ApiOperation(value = "角色权限查询", notes = "角色权限查询接口")
    @PostMapping("/roleSelect")
    public Result roleSelect(@RequestBody RoleSelectBo roleSelectBo) {
        return roleService.roleSelect(roleSelectBo,null
        );
    }

    @ApiOperation(value = "角色增加", notes = "角色增加接口")
    @PutMapping("/roleAdd")
    public Result roleAdd(@RequestBody @Validated RoleSelectBo roleSelectBo) {
        return roleService.roleAdd(roleSelectBo
        );
    }

    @ApiOperation(value = "角色修改", notes = "角色修改接口")
    @PostMapping("/roleUpdate")
    public Result roleUpdate(@RequestBody @Validated RoleSelectBo roleSelectBo) {
        return roleService.roleUpdate(roleSelectBo
        );
    }

    @ApiOperation(value = "角色删除(单个，批量)", notes = "角色删除接口（单个，批量）")
    @PostMapping("/roleDelete")
    public Result roleDelete(RoleDeleteBo roleDeleteBo) {
        return roleService.roleDelete(roleDeleteBo.getIds()
        );
    }
    @ApiOperation(value = "角色状态", notes = "角色状态")
    @PostMapping("/roleStatus")
    public Result roleStatus(Role roleDeleteBo) {
        return roleService.roleStatus(roleDeleteBo
        );
    }
    @ApiOperation(value = "角色状态", notes = "角色状态")
    @PostMapping("/roleIsdeleted")
    public Result roleIsdeleted(Role roleDeleteBo) {
        return roleService.roleIsdeleted(roleDeleteBo
        );
    }
}
