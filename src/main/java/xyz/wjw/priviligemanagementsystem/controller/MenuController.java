package xyz.wjw.priviligemanagementsystem.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import xyz.wjw.priviligemanagementsystem.bo.MenuDeleteBo;
import xyz.wjw.priviligemanagementsystem.bo.MenuSelectBo;
import xyz.wjw.priviligemanagementsystem.entity.Menu;
import xyz.wjw.priviligemanagementsystem.entity.User;
import xyz.wjw.priviligemanagementsystem.service.MenuService;
import xyz.wjw.priviligemanagementsystem.vo.Node;
import xyz.wjw.priviligemanagementsystem.vo.NodeOther;
import xyz.wjw.priviligemanagementsystem.vo.Result;

import javax.servlet.http.HttpSession;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author ASUS
 */
@Api(tags="菜单与用户权限管理")
@CrossOrigin
@RestController
@RequestMapping(value="/menu")
public class MenuController {

    private final MenuService menuService;

    public MenuController(MenuService menuService){
        this.menuService = menuService;
    }


    @ApiOperation(value = "菜单查询", notes = "菜单查询接口")
    @ResponseBody
    @RequestMapping("/menuSelect")
    public List<Node> menuSelect(String name) {
        return menuService.menuSelect(name
        );
    }

    @ApiOperation(value = "菜单增加", notes = "菜单增加接口")

    @RequestMapping("/menuAdd")
    public Result menuAdd(@RequestBody MenuSelectBo menuSelectBo) {
        return menuService.menuAdd(menuSelectBo
        );
    }

    @ApiOperation(value = "菜单修改", notes = "菜单修改接口")
    @PostMapping("/menuUpdate")
    public Result menuUpdate(@RequestBody @Validated MenuSelectBo menuSelectBo) {
        return menuService.menuUpdate(menuSelectBo
        );
    }

    @ApiOperation(value = "菜单删除(单个，批量)", notes = "菜单删除接口（单个，批量）")
    @PostMapping("/menuDelete")
    public Result userDelete(@RequestBody MenuDeleteBo menuDeleteBo) {
        return menuService.menuDelete(menuDeleteBo.getIds()
        );
    }

    @RequestMapping(value = "/treeload")
    @ResponseBody
    public List<NodeOther> treeload(){
        return menuService.menuSelected();
    }

    @RequestMapping(value = "/treeloadIndex")
    @ResponseBody
    public List<NodeOther> treeloadIndex(HttpSession session){
        User user=(User)session.getAttribute("userSession");
        System.out.println(user.getId());
        return menuService.treeloadIndex(user.getId());
    }
}
