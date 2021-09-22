package xyz.wjw.priviligemanagementsystem.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import xyz.wjw.priviligemanagementsystem.dto.MenuSelectQuery;
import xyz.wjw.priviligemanagementsystem.entity.Menu;
import xyz.wjw.priviligemanagementsystem.entity.MenuOther;
import xyz.wjw.priviligemanagementsystem.vo.SelectMenuVo;

import java.util.List;

/**
 * @author ASUS
 */
@Mapper
public interface MenuMapper extends BaseMapper<Menu> {


    List<SelectMenuVo> menuSelect(String name);

    int menuDelete(List<String> ids);

    List<MenuOther> selectAll();

    List<MenuOther> treeloadIndex(String id);
}
