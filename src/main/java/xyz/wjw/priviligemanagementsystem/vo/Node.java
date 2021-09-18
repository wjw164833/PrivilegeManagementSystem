package xyz.wjw.priviligemanagementsystem.vo;

import lombok.Data;

import java.util.List;

@Data
public class Node {
    private Long id;
    private String title;
    private String field;
    private Boolean checked;
    private Boolean spread;
    private List<Node> children;
    private String url;
    private String icon;
    private Integer type;
    private Integer pid;
    private Integer sort;

}
