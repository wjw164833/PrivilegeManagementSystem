package xyz.wjw.priviligemanagementsystem.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class MenuSelectQuery {
//    //limit偏移量
//    private int pageIndex;
//    //limit取记录条数
//    private int pageSize;
    @ApiModelProperty(value = "用户ID")
    private String id;

    private String name;

    private String appurl;

    private String imgurl;

    private String type;

    private String sortcode;

    private String parentid;

    private String isdeleted;
}
