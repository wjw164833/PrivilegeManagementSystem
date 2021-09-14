package xyz.wjw.priviligemanagementsystem.util;


import lombok.Getter;
import xyz.wjw.priviligemanagementsystem.vo.PaginationDate;

/**
 * 分页数据
 * @author zwj
 */
@Getter
public class PaginationUtils {
    private PaginationUtils() {

    }
    //封装为分页参数
    public static PaginationDate getPaginationDate(int number, int page, int sum){
        return new PaginationDate(number,page,sum%number == 0?sum/number:sum/number+1,sum);
    }
    //分页参数是否无效
    public static boolean isPagingParameters(int number, int page){
        return number < 1 || page < 1?false:true;
    }
    //结果是否无效
    public static boolean isValid(PaginationDate paginationDate){
        return paginationDate.sumPage<paginationDate.currentPage?true:false;
    }
    public static int getPageIndex(int page,int number){
        return page==1?0:(page-1)*number;
    }
}
