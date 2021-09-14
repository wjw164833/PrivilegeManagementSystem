package xyz.wjw.priviligemanagementsystem.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SelectUserVo implements Serializable {
    @ApiModelProperty(value = "用户id")
    private String id;

    private String name;

    private String depid;

    private String account;

    private String password;

    private String mobile;

    private String email;

    private String sex;

    private String  status;

    private String isdeleted;


}
