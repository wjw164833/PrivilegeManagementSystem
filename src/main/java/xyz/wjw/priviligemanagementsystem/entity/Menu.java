package xyz.wjw.priviligemanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@TableName("sys_menu")
public class Menu {
    private String id;

    private String name;

    private String appurl;

    private String imgurl;

    private String type;

    private String sortcode;

    private String parentid;

    private String isdeleted;
}
