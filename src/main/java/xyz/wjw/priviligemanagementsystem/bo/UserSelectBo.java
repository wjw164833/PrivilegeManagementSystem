package xyz.wjw.priviligemanagementsystem.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;
import xyz.wjw.priviligemanagementsystem.entity.Dept;
import xyz.wjw.priviligemanagementsystem.entity.Role;
import xyz.wjw.priviligemanagementsystem.entity.UserRole;

import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserSelectBo implements Serializable {
    @ApiModelProperty(value = "用户ID")
    private String id;

    private String name;

    private String depId;

    private String account;

    private String password;

    private String mobile;

    private String email;

    private String sex;

    private String status;

    private String isdeleted;
    @ApiModelProperty(value = "页码")
    private int page;
    @ApiModelProperty(value = "每页记录条数")
    private int number;
    private Dept dept;

    private String dname;

    private String rname;

    private Role role;

    private UserRole userRole;
}
