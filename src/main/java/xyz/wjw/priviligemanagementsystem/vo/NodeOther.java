package xyz.wjw.priviligemanagementsystem.vo;

import lombok.Data;

import java.util.List;

@Data
public class NodeOther {
    private Long id;
    private String title;
    private String field;
    private Boolean spread;
    private List<NodeOther> children;
    private String url;
    private String icon;
    private Short type;
}
