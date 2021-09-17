package xyz.wjw.priviligemanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonIgnore;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_user")
public class User implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id",type = IdType.AUTO)
    private String id;

    private String name;

    @ApiModelProperty(value = "部门Id")
    private String depid;

    private String account;

    private String password;

    private String mobile;

    private String email;

    private String sex;

    private String status;

    private String isdeleted;
    @JsonIgnore
    @ApiModelProperty(value = "登录凭证")
    @TableField("login_token")
    private String loginToken;

}