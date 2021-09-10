package xyz.wjw.priviligemanagementsystem.util;


import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import xyz.wjw.priviligemanagementsystem.enums.ErrorEnum;

public class DataCheckUtils {
    public static void isNotBlank(String date, String errorMsg){
        isValid(StringUtils.isNotBlank(date),errorMsg);
    }
    public static void isValid(Boolean state, String errorMsg){
        if(state){
           return;
        }
        throw new BizException(ErrorEnum.BODY_NOT_MATCH.getResultCode(),errorMsg);
    }
    public static void isNotValid(Boolean state, String errorMsg){
        if(!state){
            return;
        }
        throw new BizException(ErrorEnum.BODY_NOT_MATCH.getResultCode(),errorMsg);
    }
}
