package xyz.wjw.priviligemanagementsystem.service.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import xyz.wjw.priviligemanagementsystem.mapper.UserRoleMapper;
import xyz.wjw.priviligemanagementsystem.service.UserRoleService;

@Service
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private UserRoleMapper userRoleMapper;

    @Override
    public boolean insertAttach(Long id,String i) {
        return userRoleMapper.insertAttach(id,i);
    }
}
