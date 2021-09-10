package xyz.wjw.priviligemanagementsystem.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SelectRoleVo {
    @ApiModelProperty(value = "角色id")
    private String id;

    private String name;

    private String remark;

    private Integer status;

    private Short isdeleted;
}
