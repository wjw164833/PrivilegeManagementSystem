package xyz.wjw.priviligemanagementsystem.service;

import org.springframework.lang.NonNull;
import xyz.wjw.priviligemanagementsystem.bo.UserDeleteBo;
import xyz.wjw.priviligemanagementsystem.config.Result;
import xyz.wjw.priviligemanagementsystem.entity.User;

public interface UserService {

    @NonNull
    Result login(
            @NonNull String account,
            @NonNull String password

    );

    Result userSelect(User user, Object o);

    Result userAdd(User user);

    Result userUpdate(User user);

    Result userDelete(UserDeleteBo userDeleteBo);
}
