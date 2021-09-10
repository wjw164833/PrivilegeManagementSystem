package xyz.wjw.priviligemanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Role {

    private Long id;

    private String name;

    private String remark;

    private Integer status;

    private Short isdeleted;
}
