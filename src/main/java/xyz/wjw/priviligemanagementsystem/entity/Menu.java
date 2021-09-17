package xyz.wjw.priviligemanagementsystem.entity;

import com.baomidou.mybatisplus.annotation.TableName;
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

    private String id;

    private String name;

    private String appurl;

    private String imgurl;

    private String type;

    private String sortcode;

    private String parentid;

    private String isdeleted;
}
