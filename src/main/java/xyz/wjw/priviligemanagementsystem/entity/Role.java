package xyz.wjw.priviligemanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@TableName("sys_role")
public class Role implements Serializable {

    private static final long serialVersionUID=1L;

    private String id;

    private String name;

    private String remark;

    private String status;

    private String isdeleted;

}
