package xyz.wjw.priviligemanagementsystem.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

/**
 * 带有分页查询返回数据
 * @author wjw
 */
@Getter
@AllArgsConstructor
public class QueryReturnDate<T> {
    PaginationDate paginationData;
    List<T> returnDate;
}
