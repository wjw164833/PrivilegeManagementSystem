package xyz.wjw.priviligemanagementsystem.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;

    private String name;

    private Long depid;

    private String account;

    private String password;

    private String mobile;

    private String email;

    private String sex;

    private Integer status;

    private Short isdeleted;

}