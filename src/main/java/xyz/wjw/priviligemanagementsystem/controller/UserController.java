package xyz.wjw.priviligemanagementsystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.wjw.priviligemanagementsystem.bo.UserDeleteBo;
import xyz.wjw.priviligemanagementsystem.bo.UserSelectBo;
import xyz.wjw.priviligemanagementsystem.entity.User;
import xyz.wjw.priviligemanagementsystem.service.Impl.UserImpl;
import xyz.wjw.priviligemanagementsystem.service.UserService;
import xyz.wjw.priviligemanagementsystem.util.JwtUtil;
import xyz.wjw.priviligemanagementsystem.util.RedisUtil;
import xyz.wjw.priviligemanagementsystem.util.ResponseResult;
import xyz.wjw.priviligemanagementsystem.util.TokenUtils;
import xyz.wjw.priviligemanagementsystem.vo.Result;

import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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

    @Autowired
    private RedisUtil redisUtil;

    @ApiOperation(value = "登录", notes = "登录接口")
    @RequestMapping("/login")
    @ResponseBody
    public Result login( UserSelectBo userSelectBo) {
//        ResponseResult result = new ResponseResult();
//        // 1 从Shiro框架中，获取一个Subject对象，代表当前会话的用户
//        Subject subject = SecurityUtils.getSubject();
//        AuthenticationToken token = new UsernamePasswordToken(user.getAccount(), user.getPassword());
//        // 2.2 认证：认证失败，抛异常
//        try {
//            subject.login(token);
//            String resToken = JwtUtil.sign(user.getAccount());
//            result.setData(result.new Token(resToken));
//            this.redisUtil.set(resToken, user.getAccount(),30*60);
//        }catch(Exception e){
//            e.printStackTrace();
//            result.setData("用户名或密码错误");
//        }
//        return result;
        Result result =new Result();
        System.out.println(result.getCode());
        return userService.login(userSelectBo);
    }

    @ApiOperation(value = "用户信息", notes = "用户信息接口")
    @GetMapping("/info")
    public Result getUserDate(HttpServletRequest request) {
        User user = TokenUtils.getUser(request);
        return userService.getUserDate(user.getId());
    }

    @ApiOperation(value = "用户查询", notes = "用户查询接口")
    @PostMapping("/userSelect")
    public Result userSelect(@RequestBody UserSelectBo userSelectBo) {
        return userService.userSelect(userSelectBo,null);
    }

    @ApiOperation(value = "用户增加", notes = "用户增加接口")
    @PutMapping("/userAdd")
    public Result userAdd(@RequestBody UserSelectBo userSelectBo) {
        return userService.userAdd(userSelectBo);
    }

    @ApiOperation(value = "用户修改", notes = "用户修改接口")
    @PostMapping("/userUpdate")
    public Result userUpdate(@RequestBody UserSelectBo userSelectBo) {
        return userService.userUpdate(userSelectBo
        );
    }

    @ApiOperation(value = "用户删除(单个，批量)", notes = "用户删除接口（单个，批量）")
    @GetMapping("/userDelete")
    @ResponseBody
    public Result userDelete(UserDeleteBo userDeleteBo) {
        return userService.userDelete(userDeleteBo.getIds()
        );
    }

    @ApiOperation(value = "修改用户状态", notes = "修改用户状态接口")
    @PostMapping("/userStatus")
    public int userStatus(User user){
        return userService.userStatus(user);
    }


    @ApiOperation(value = "登出", notes = "登出")
    @PutMapping("/loginout")
    public Result loginout(HttpServletRequest request) {
        User user = TokenUtils.getUser(request);
        return userService.loginout(user.getId());
    }

}
