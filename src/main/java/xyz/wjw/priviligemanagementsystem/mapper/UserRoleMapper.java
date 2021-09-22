package xyz.wjw.priviligemanagementsystem.mapper;

import org.apache.ibatis.annotations.Mapper;
import xyz.wjw.priviligemanagementsystem.entity.User;
import xyz.wjw.priviligemanagementsystem.entity.UserRole;

import java.util.List;

@Mapper
public interface UserRoleMapper {
    int deleteByPrimaryKey(Long userid);

    int insert(UserRole record);

    int insertSelective(UserRole record);

    UserRole selectByPrimaryKey(Long userid);

    int updateByPrimaryKeySelective(UserRole record);

    int updateByPrimaryKey(UserRole record);

    Boolean roleDel(long id);

    Boolean delAllRole(List<String> delList);

    Boolean delUserRoleFirst(User user);

    boolean insertAttach(Long id,String i);

    Boolean userDelFirst(long id);

    Boolean delAllUserFirst(List<String> delList);
}