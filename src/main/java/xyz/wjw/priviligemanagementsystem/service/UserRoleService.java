package xyz.wjw.priviligemanagementsystem.service;

import org.springframework.stereotype.Service;

@Service
public interface UserRoleService {
    boolean insertAttach(Long id, String i);
}
