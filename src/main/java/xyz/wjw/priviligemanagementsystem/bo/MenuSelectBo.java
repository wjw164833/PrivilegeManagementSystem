package xyz.wjw.priviligemanagementsystem.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MenuSelectBo {
    private String id;

    private String name;

    private String appUrl;

    private String imgUrl;

    private String type;

    private String sortCode;

    private String parentId;

    private String isDeleted;
//    @ApiModelProperty(value = "页码")
//    private int page;
//    @ApiModelProperty(value = "每页记录条数")
//    private int number;
}
