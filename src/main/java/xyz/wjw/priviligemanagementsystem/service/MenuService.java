package xyz.wjw.priviligemanagementsystem.service;

import org.springframework.stereotype.Service;
import xyz.wjw.priviligemanagementsystem.bo.MenuSelectBo;
import xyz.wjw.priviligemanagementsystem.entity.Menu;
import xyz.wjw.priviligemanagementsystem.vo.Node;
import xyz.wjw.priviligemanagementsystem.vo.NodeOther;
import xyz.wjw.priviligemanagementsystem.vo.Result;

import java.util.List;

/**
 * @author ASUS
 */
@Service
public interface MenuService {
    List<Node> menuSelect(String name);

    Result menuAdd(MenuSelectBo menuSelectBo);

    Result menuUpdate(MenuSelectBo menuSelectBo);

    Result menuDelete(List<String> ids);


    List<NodeOther> menuSelected();

    List<NodeOther> treeloadIndex(String id);
}
