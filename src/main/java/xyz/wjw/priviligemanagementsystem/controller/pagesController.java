package xyz.wjw.priviligemanagementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Author yr
 * @Date 2021-09-07
 * @Param
 * @Description 页面跳转接口
 */

@Controller
public class pagesController {
    @RequestMapping(value="/login")
    public String login(){
        return "user/login";
    }

    @RequestMapping(value="/adminIndex")
    public String index(){
        return "admin/adminIndex";
    }

    @RequestMapping(value="/register")
    public String register(){
        return "register";
    }

    @RequestMapping(value="/welcome")
    public String welcome(){
        return "user/welcome";
    }

    @RequestMapping(value="/userList")
    public String userList(){ return "user/userList"; }

    @RequestMapping(value="/roleList")
    public String roleList(){ return "user/roleList"; }

    @RequestMapping(value="/menuList")
    public String priviligeList(){
        return "menuList";
    }

    @RequestMapping(value="/updateUser")
    public String updateUser(){
        return "user/updateUser";
    }

    @RequestMapping(value="/userroleList")
    public String userroleList(){
        return "user/userroleList";
    }

}
