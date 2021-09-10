package xyz.wjw.priviligemanagementsystem.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wjw.priviligemanagementsystem.bo.RoleDeleteBo;
import xyz.wjw.priviligemanagementsystem.config.Result;
import xyz.wjw.priviligemanagementsystem.entity.Role;
import xyz.wjw.priviligemanagementsystem.mapper.RoleMapper;
import xyz.wjw.priviligemanagementsystem.service.RoleService;


@Service
public class RoleImpl implements RoleService {

    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Result roleSelect(Role role, Object o) {
        return null;
    }

    @Override
    public Result roleAdd(Role role) {
        return null;
    }

    @Override
    public Result roleUpdate(Role role) {
        return null;
    }

    @Override
    public Result roleDelete(RoleDeleteBo roleDeleteBo) {
        return null;
    }
}
