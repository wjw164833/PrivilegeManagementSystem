package xyz.wjw.priviligemanagementsystem.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SelectUserVo {
    @ApiModelProperty(value = "用户id")
    private String id;

    private String name;

    private Long depid;

    private String account;

    private String password;

    private String mobile;

    private String email;

    private String sex;

    private Integer status;

    private Short isdeleted;


}
