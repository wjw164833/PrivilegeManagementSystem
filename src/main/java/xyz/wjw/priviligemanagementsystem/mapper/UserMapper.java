package xyz.wjw.priviligemanagementsystem.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import xyz.wjw.priviligemanagementsystem.dto.UserSelectQuery;
import xyz.wjw.priviligemanagementsystem.entity.Role;
import xyz.wjw.priviligemanagementsystem.entity.User;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    User selectUser(String account, String password);

    List<Object> userSelect(UserSelectQuery userSelectQuery);

    int userDelete(List<String> ids);

    int on (User user);

    int off (User user);

    @Select("select * from sys_user where name=#{username}")
    User selectByUserName(String username);

    int insertUser(User user);

    List<Role> findUserRole(Long id);
}