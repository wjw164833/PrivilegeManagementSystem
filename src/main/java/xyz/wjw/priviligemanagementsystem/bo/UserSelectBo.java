package xyz.wjw.priviligemanagementsystem.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

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
}
