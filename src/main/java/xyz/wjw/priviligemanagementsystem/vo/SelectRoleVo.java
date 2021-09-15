package xyz.wjw.priviligemanagementsystem.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class SelectRoleVo implements Serializable {
    @ApiModelProperty(value = "角色id")
    private String id;

    private String name;

    private String remark;

    private Integer status;

    private Short isdeleted;
}
