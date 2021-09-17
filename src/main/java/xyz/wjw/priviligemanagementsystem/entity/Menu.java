package xyz.wjw.priviligemanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * @author ASUS
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_menu")
public class Menu implements Serializable {

    private static final long serialVersionUID=1L;

    @TableId(value = "id",type = IdType.AUTO)
    private String id;

    private String name;

    @ApiModelProperty(value = "程序路径")
    @TableField("appUrl")
    private String appUrl;

    @ApiModelProperty(value = "菜单路径")
    @TableField("imgUrl")
    private String imgUrl;

    private String type;

    @ApiModelProperty(value = "菜单路径")
    @TableField("sortCode")
    private String sortCode;

    @ApiModelProperty(value = "菜单路径")
    @TableField("parentId")
    private String parentId;

    @ApiModelProperty(value = "菜单路径")
    @TableField("isDeleted")
    private String isDeleted;
}
