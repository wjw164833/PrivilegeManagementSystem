package xyz.wjw.priviligemanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_role")
public class Role {

    private String id;

    private String name;

    private String remark;

    private String status;

    private String isdeleted;

}
