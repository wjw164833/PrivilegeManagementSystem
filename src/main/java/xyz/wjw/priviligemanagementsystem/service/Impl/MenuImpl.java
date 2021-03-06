package xyz.wjw.priviligemanagementsystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wjw.priviligemanagementsystem.bo.MenuSelectBo;
import xyz.wjw.priviligemanagementsystem.entity.Menu;
import xyz.wjw.priviligemanagementsystem.entity.MenuOther;
import xyz.wjw.priviligemanagementsystem.mapper.MenuMapper;
import xyz.wjw.priviligemanagementsystem.service.MenuService;
import xyz.wjw.priviligemanagementsystem.vo.Node;
import xyz.wjw.priviligemanagementsystem.vo.NodeOther;
import xyz.wjw.priviligemanagementsystem.vo.Result;
import xyz.wjw.priviligemanagementsystem.vo.SelectMenuVo;


import java.util.ArrayList;
import java.util.List;

/**
 * @author ASUS
 */
@Service
public class MenuImpl implements MenuService {

    @Autowired
    private MenuMapper menuMapper;


    private List<Node> recursion(List<SelectMenuVo> list, Long pid){
        List<Node> ret = new ArrayList<>();
        list.forEach(item->{
            if(item.getParentid().equals(pid.toString())){
                Node node = new Node();
                node.setId(Long.parseLong(item.getId()));
                node.setChecked(item.getRoleId()==null?false:true);
                node.setIcon(item.getImgurl());
                node.setSpread(true);
                node.setTitle(item.getName());
                node.setUrl(item.getAppurl());
                node.setType(Integer.parseInt(item.getType()));
                node.setPid(Integer.parseInt(item.getParentid()));
                node.setSort(Integer.parseInt(item.getSortcode()));
                node.setChildren(recursion(list, node.getId()));
                ret.add(node);
            }
        });
        return ret;
    }

    @Override
    public List<Node> menuSelect(String name) {
        List<SelectMenuVo> list = menuMapper.menuSelect(name);
        List<Node> ret = new ArrayList<>();
        if(list != null){
            list.forEach(item -> {
                if(item.getParentid().equals("0")){
                    Node node = new Node();
                    node.setId(Long.parseLong(item.getId()));
                    node.setChecked(item.getRoleId()==null?false:true);
                    node.setIcon(item.getImgurl());
                    node.setSpread(true);
                    node.setTitle(item.getName());
                    node.setUrl(item.getAppurl());
                    node.setType(Integer.parseInt(item.getType()));
                    node.setPid(Integer.parseInt(item.getParentid()));
                    node.setSort(Integer.parseInt(item.getSortcode()));
                    node.setChildren(recursion(list, node.getId()));
                    ret.add(node);
                }
            });
        }
        return ret;
    }


    @Override
    public Result menuAdd(MenuSelectBo menuSelectBo) {
        Menu menu = new Menu();
        menu.setName(menuSelectBo.getName());
        menu.setAppurl(menuSelectBo.getAppUrl());
        menu.setImgurl(menuSelectBo.getImgUrl());
        menu.setType(menuSelectBo.getType());
        menu.setSortcode(menuSelectBo.getSortCode());
        menu.setParentid(menuSelectBo.getParentId());
        menu.setIsdeleted(menuSelectBo.getIsDeleted());
        int row =menuMapper.insert(menu);
        //??????????????????
        if (row == 0) {
            return Result.error("????????????????????????");
        }
        return Result.success();
    }

    @Override
    public Result menuUpdate(MenuSelectBo menuSelectBo) {
        Menu menu = new Menu();
        menu.setName(menuSelectBo.getName());
        menu.setAppurl(menuSelectBo.getAppUrl());
        menu.setImgurl(menuSelectBo.getImgUrl());
        menu.setType(menuSelectBo.getType());
        menu.setSortcode(menuSelectBo.getSortCode());
        menu.setParentid(menuSelectBo.getParentId());
        menu.setIsdeleted(menuSelectBo.getIsDeleted());
        UpdateWrapper<Menu> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(Menu::getId, menuSelectBo.getId());
        int row =menuMapper.update(menu, updateWrapper);
        //??????????????????
        if (row == 0) {
            return Result.error("??????????????????????????????");
        }
        return Result.success();
    }

    @Override
    public Result menuDelete(@NonNull List<String> ids) {
        int row =menuMapper.menuDelete(ids);
        //??????????????????
        if (row == 0) {
            return Result.error("????????????????????????");
        }
        return Result.success(row);
    }

    @Override
    public List<NodeOther> menuSelected() {
        List<MenuOther> list = menuMapper.selectAll();
        List<NodeOther> ret = new ArrayList<>();
        if(list != null){
            list.forEach(item -> {
                if(item.getParentid().equals(new Long(0))){
                    NodeOther node = new NodeOther();
                    node.setId(item.getId());
                    //node.setChecked(item.getRoleId()==null?false:true);
                    node.setIcon("");
                    node.setSpread(true);
                    node.setTitle(item.getTitle());
                    node.setUrl(item.getAppurl());
                    node.setType(item.getType());
                    node.setChildren(recursioned(list,node.getId()));
                    ret.add(node);
                }
            });
        }
        return ret;
    }

    private List<NodeOther> recursioned(List<MenuOther> list, Long pid){
        List<NodeOther> ret = new ArrayList<>();
        list.forEach(item->{
            if(item.getParentid().equals(pid)){
                NodeOther node = new NodeOther();
                node.setId(item.getId());
                //node.setChecked(item.getRoleId()==null?false:true);
                node.setIcon("");
                node.setSpread(true);
                node.setTitle(item.getTitle());
                node.setUrl(item.getAppurl());
                node.setType(item.getType());
                node.setChildren(recursioned(list, node.getId()));
                ret.add(node);
            }
        });
        return ret;
    }

    @Override
    public List<NodeOther> treeloadIndex(String id) {
        List<MenuOther> list = menuMapper.treeloadIndex(id);
        List<NodeOther> ret = new ArrayList<>();
        if(list != null){
            list.forEach(item -> {
                //System.out.println(item.getTitle());
                if(item.getParentid().equals(new Long(0))){
                    NodeOther node = new NodeOther();
                    node.setId(item.getId());
                    //node.setChecked(item.getRoleId()==null?false:true);
                    node.setIcon("");
                    node.setSpread(true);
                    node.setTitle(item.getTitle());
                    node.setUrl(item.getAppurl());
                    System.out.println(node.getUrl());
                    node.setType(item.getType());
                    node.setChildren(recursioned(list, node.getId()));
                    ret.add(node);
                }
            });
        }
        return ret;
    }
}
