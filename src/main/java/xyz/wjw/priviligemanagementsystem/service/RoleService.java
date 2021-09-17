package xyz.wjw.priviligemanagementsystem.service;

import lombok.NonNull;
import org.springframework.stereotype.Service;
import xyz.wjw.priviligemanagementsystem.bo.RoleDeleteBo;
import xyz.wjw.priviligemanagementsystem.bo.RoleSelectBo;
import xyz.wjw.priviligemanagementsystem.entity.Role;
import xyz.wjw.priviligemanagementsystem.vo.Result;

import java.util.List;

@Service
public interface RoleService {


    Result roleSelect(
            RoleSelectBo roleSelectBo,
            String id
    );

    Result roleAdd(
            RoleSelectBo roleSelectBo
    );

    Result roleUpdate(
            RoleSelectBo roleSelectBo
    );

    Result roleDelete(
            @NonNull List<String> ids
    );
    Result roleStatus(
            @NonNull Role role
    );

    Result roleIsdeleted(Role role);
}
