package xyz.wjw.priviligemanagementsystem.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

/**
 * 分页基础信息
 * @author wjw
 */
@Getter
@AllArgsConstructor
public class PaginationDate {
    //每页记录条数
    public int number;
    //当前页
    public int currentPage;
    //总页数
    public int sumPage;
    //总记录
    public int sum;
}
