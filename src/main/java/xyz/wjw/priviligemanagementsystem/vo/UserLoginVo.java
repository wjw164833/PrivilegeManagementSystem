package xyz.wjw.priviligemanagementsystem.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class UserLoginVo {
    @ApiModelProperty(value = "登录凭证")
    private String loginToken;
}
