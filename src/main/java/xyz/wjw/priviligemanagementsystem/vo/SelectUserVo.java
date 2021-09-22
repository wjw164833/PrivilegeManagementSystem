package xyz.wjw.priviligemanagementsystem.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import xyz.wjw.priviligemanagementsystem.entity.Dept;
import xyz.wjw.priviligemanagementsystem.entity.Role;
import xyz.wjw.priviligemanagementsystem.entity.UserRole;

import java.io.Serializable;

@Data
public class SelectUserVo implements Serializable {
    @ApiModelProperty(value = "用户id")
    private String id;

    private String name;

    private String depId;

    private String account;

    private String password;

    private String mobile;

    private String email;

    private String sex;

    private String  status;

    private String isdeleted;

    private Dept dept;

    private String dname;

    private String rname;

    private Role role;

    private UserRole userRole;

}
