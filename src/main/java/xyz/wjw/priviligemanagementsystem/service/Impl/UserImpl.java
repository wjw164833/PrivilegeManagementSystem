package xyz.wjw.priviligemanagementsystem.service.Impl;

import lombok.NonNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wjw.priviligemanagementsystem.bo.UserDeleteBo;
import xyz.wjw.priviligemanagementsystem.config.Result;
import xyz.wjw.priviligemanagementsystem.entity.User;
import xyz.wjw.priviligemanagementsystem.mapper.UserMapper;
import xyz.wjw.priviligemanagementsystem.service.UserService;

@Service
public class UserImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public Result login(
            @NonNull String account,
            @NonNull String password) {
        boolean user = userMapper.selectUser(account,password);
        if(user == true){
            return Result.ok();
        }
        return Result.error();
    }

    @Override
    public Result userSelect(User user, Object o) {

        return null;
    }

    @Override
    public Result userAdd(User user) {
        return null;
    }

    @Override
    public Result userUpdate(User user) {
        return null;
    }

    @Override
    public Result userDelete(UserDeleteBo userDeleteBo) {
        return null;
    }
}
