package xyz.wjw.priviligemanagementsystem.service;

import org.springframework.lang.NonNull;
import xyz.wjw.priviligemanagementsystem.bo.UserDeleteBo;
import xyz.wjw.priviligemanagementsystem.bo.UserSelectBo;
import xyz.wjw.priviligemanagementsystem.entity.Role;
import xyz.wjw.priviligemanagementsystem.entity.User;
import xyz.wjw.priviligemanagementsystem.vo.Result;

import java.util.List;

public interface UserService {

    @NonNull
    Result login(
            UserSelectBo userSelectBo

    );

    Result userSelect(
            UserSelectBo userSelectBo,
            String id
    );

    Result userAdd(
            UserSelectBo userSelectBo
    );

    Result userUpdate(
            UserSelectBo userSelectBo
            ,String roleIds
    );

    Result userDelete(
            @NonNull List<String> ids
            );

    User findByUserName(String userName);

    Result getUserDate(String id);

    Result loginout(String id);

    int userStatus(User user);

    List<Role> findUserRole(Long id);
}
