package xyz.wjw.priviligemanagementsystem.service;

import org.springframework.stereotype.Service;
import xyz.wjw.priviligemanagementsystem.bo.RoleDeleteBo;
import xyz.wjw.priviligemanagementsystem.config.Result;
import xyz.wjw.priviligemanagementsystem.entity.Role;

@Service
public interface RoleService {
    
    Result roleSelect(Role role, Object o);

    Result roleAdd(Role role);

    Result roleUpdate(Role role);

    Result roleDelete(RoleDeleteBo roleDeleteBo);
}
