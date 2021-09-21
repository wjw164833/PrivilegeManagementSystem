package xyz.wjw.priviligemanagementsystem.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import xyz.wjw.priviligemanagementsystem.service.RoleService;

import java.util.List;

/**
 * @Author yr
 * @Date 2021-09-07
 * @Param
 * @Description 页面跳转接口
 */

@Controller
public class pagesController {

    @Autowired
    private RoleService roleService;

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
        return "user/register";
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
        return "user/menuList";
    }

    @RequestMapping(value="/updateUser")
    public String updateUser(){
        return "user/updateUser";
    }

    @RequestMapping(value="/userroleList")
    public String userroleList(){
        return "user/userroleList";
    }

    @RequestMapping(value="/addMenu")
    public String addMenu(){
        return "menu/addMenu";
    }

    @RequestMapping(value="/updateMenu")
    public String updateMenu(){
        return "menu/updateMenu";
    }

    @RequestMapping(value="/addRole")
    public String addRole(){
        return "user/addRole";
    }

    @RequestMapping(value="/register1")
    public String register1(){ return "user/register1"; }

    @RequestMapping(value="/assignment")
    public String assignment(Model model, Long id){
        List<Integer> list=roleService.selectRoleMenu(id);
        String str = list.toString();
        String s1 = str.replace("[","");
        String s2 = s1.replace("]","");
        String s3 = s2.replace("\"","");
        model.addAttribute("menuRole",s3);
        return "menu/assignment";
    }
}
