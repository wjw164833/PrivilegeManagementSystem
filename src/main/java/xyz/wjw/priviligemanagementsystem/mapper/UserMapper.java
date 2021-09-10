package xyz.wjw.priviligemanagementsystem.mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface UserMapper {

    boolean selectUser(String account, String password);
}