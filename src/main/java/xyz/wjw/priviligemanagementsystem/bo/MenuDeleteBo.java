package xyz.wjw.priviligemanagementsystem.bo;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * @author ASUS
 */
@Data
@NoArgsConstructor
public class MenuDeleteBo {

    @ApiModelProperty(value = "菜单ID")
    private List<String> ids;

}
