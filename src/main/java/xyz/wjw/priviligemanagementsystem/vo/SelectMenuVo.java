package xyz.wjw.priviligemanagementsystem.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
public class SelectMenuVo {
    @ApiModelProperty(value = "菜单id")
    private String id;

    private String name;

    private String appurl;

    private String imgurl;

    private String type;

    private String sortcode;

    private String parentid;

    private String isdeleted;

    private Long roleId;
}
