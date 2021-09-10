package xyz.wjw.priviligemanagementsystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.wjw.priviligemanagementsystem.bo.UserDeleteBo;
import xyz.wjw.priviligemanagementsystem.config.Result;
import xyz.wjw.priviligemanagementsystem.entity.User;
import xyz.wjw.priviligemanagementsystem.service.Impl.UserImpl;
import xyz.wjw.priviligemanagementsystem.service.UserService;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

/**
 * @author ASUS
 */
@Api(tags="用户管理")
@CrossOrigin
@RestController
@RequestMapping(value="/user")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService){
        this.userService = userService;
    }

    @ApiOperation(value = "登录", notes = "登录接口")
    @PutMapping("/login")
    public Result login(@RequestBody @Validated User user) {
        return userService.login(user.getAccount(), user.getPassword()
        );
    }

    @ApiOperation(value = "用户查询", notes = "用户查询接口")
    @GetMapping("/userSelect")
    public Result userSelect(@RequestBody @Validated User user) {
        return userService.userSelect(user,null
        );
    }

    @ApiOperation(value = "用户增加", notes = "用户增加接口")
    @PutMapping("/userAdd")
    public Result userAdd(@RequestBody @Validated User user) {
        return userService.userAdd(user
        );
    }

    @ApiOperation(value = "用户修改", notes = "用户修改接口")
    @PutMapping("/userUpdate")
    public Result userUpdate(@RequestBody @Validated User user) {
        return userService.userUpdate(user
        );
    }

    @ApiOperation(value = "用户删除(单个，批量)", notes = "用户删除接口（单个，批量）")
    @PutMapping("/userDelete")
    public Result userDelete(@RequestBody UserDeleteBo userDeleteBo) {
        return userService.userDelete(userDeleteBo
        );
    }


}
