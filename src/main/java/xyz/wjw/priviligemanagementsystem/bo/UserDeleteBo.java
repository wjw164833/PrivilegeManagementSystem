package xyz.wjw.priviligemanagementsystem.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ASUS
 */
@Data
@NoArgsConstructor
public class UserDeleteBo {

    @ApiModelProperty(value = "用户ID")
    private String[] id;

}
