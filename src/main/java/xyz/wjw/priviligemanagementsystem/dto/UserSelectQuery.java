package xyz.wjw.priviligemanagementsystem.dto;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class UserSelectQuery{
    //limit偏移量
    private int pageIndex;
    //limit取记录条数
    private int pageSize;
    @ApiModelProperty(value = "用户ID")
    private String id;

    private String name;

    private String depid;

    private String account;

    private String password;

    private String mobile;

    private String email;

    private String sex;

    private String status;

    private String isdeleted;
}
