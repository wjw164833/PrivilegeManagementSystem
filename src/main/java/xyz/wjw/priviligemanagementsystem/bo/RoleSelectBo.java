package xyz.wjw.priviligemanagementsystem.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class RoleSelectBo {
    @ApiModelProperty(value = "角色ID")
    private String id;

    private String name;

    private String remark;

    private String status;

    private String isdeleted;
    @ApiModelProperty(value = "页码")
    private int page;
    @ApiModelProperty(value = "每页记录条数")
    private int number;
}
