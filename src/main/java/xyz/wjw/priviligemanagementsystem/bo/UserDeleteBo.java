package xyz.wjw.priviligemanagementsystem.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ASUS
 */
@Data
@NoArgsConstructor
public class UserDeleteBo {

    @ApiModelProperty(value = "用户ID")
    private List<String> ids;

}
