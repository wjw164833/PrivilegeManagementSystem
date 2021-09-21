package xyz.wjw.priviligemanagementsystem.mapper;


import org.apache.ibatis.annotations.Mapper;
import xyz.wjw.priviligemanagementsystem.entity.roleMenu;

@Mapper
public interface roleMenuMapper {
    int insert(roleMenu record);

    int insertSelective(roleMenu record);

    boolean delRoleMenuFirst(Long roleId);

    boolean updateTree(Long roleId, String i);
}