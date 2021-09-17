package xyz.wjw.priviligemanagementsystem.service.Impl;

import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wjw.priviligemanagementsystem.bo.MenuSelectBo;
import xyz.wjw.priviligemanagementsystem.dto.MenuSelectQuery;
import xyz.wjw.priviligemanagementsystem.entity.Menu;
import xyz.wjw.priviligemanagementsystem.mapper.MenuMapper;
import xyz.wjw.priviligemanagementsystem.service.MenuService;
import xyz.wjw.priviligemanagementsystem.util.DataCheckUtils;
import xyz.wjw.priviligemanagementsystem.util.PaginationUtils;
import xyz.wjw.priviligemanagementsystem.vo.*;

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
        menu.setId(menuSelectBo.getId());
        menu.setName(menuSelectBo.getName());
        menu.setAppurl(menuSelectBo.getAppurl());
        menu.setImgurl(menuSelectBo.getImgurl());
        menu.setType(menuSelectBo.getType());
        menu.setSortcode(menuSelectBo.getSortcode());
        menu.setParentid(menuSelectBo.getParentid());
        menu.setIsdeleted(menuSelectBo.getIsdeleted());
        int row =menuMapper.insert(menu);
        //判断插入结果
        if (row == 0) {
            return Result.error("添加用户失败");
        }
        return Result.success();
    }

    @Override
    public Result menuUpdate(MenuSelectBo menuSelectBo) {
        Menu menu = new Menu();
        menu.setId(menuSelectBo.getId());
        menu.setId(menuSelectBo.getId());
        menu.setName(menuSelectBo.getName());
        menu.setAppurl(menuSelectBo.getAppurl());
        menu.setImgurl(menuSelectBo.getImgurl());
        menu.setType(menuSelectBo.getType());
        menu.setSortcode(menuSelectBo.getSortcode());
        menu.setParentid(menuSelectBo.getParentid());
        menu.setIsdeleted(menuSelectBo.getIsdeleted());
        UpdateWrapper<Menu> updateWrapper = new UpdateWrapper<>();
        updateWrapper.lambda().eq(Menu::getId, menuSelectBo.getId());
        int row =menuMapper.update(menu, updateWrapper);
        //判断插入结果
        if (row == 0) {
            return Result.error("修改用户失败");
        }
        return Result.success();
    }

    @Override
    public Result menuDelete(@NonNull List<String> ids) {
        int row =menuMapper.menuDelete(ids);
        //判断删除结果
        if (row == 0) {
            return Result.error("删除用户失败");
        }
        return Result.success(row);
    }


}
