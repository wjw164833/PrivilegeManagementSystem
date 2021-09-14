package xyz.wjw.priviligemanagementsystem.vo;


import com.alibaba.fastjson.JSONObject;

import io.swagger.annotations.ApiModelProperty;
import xyz.wjw.priviligemanagementsystem.dto.BaseErrorInfoInterface;
import xyz.wjw.priviligemanagementsystem.enums.ErrorEnum;

public class Result<T> {
    /**
     * 响应代码
     */
    private String code;

    /**
     * 响应消息
     */
    private String message;

    /**
     * 响应结果
     */
    private Object date;

    @ApiModelProperty(value = "返回数据")
    private T data ;

    public Result() {
    }

    public Result(BaseErrorInfoInterface errorInfo) {
        this.code = errorInfo.getResultCode();
        this.message = errorInfo.getResultMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getDate() {
        return date;
    }

    public void setDate(Object date) {
        this.date = date;
    }

    /**
     * 成功
     *
     * @return
     */
    public static Result success() {
        return success(null);
    }

    /**
     * 成功
     * @param data
     * @return
     */
    public static <T> Result success(T data) {
        Result rb = new Result();
        rb.setCode(ErrorEnum.SUCCESS.getResultCode());
        rb.setMessage(ErrorEnum.SUCCESS.getResultMsg());
        rb.setDate(data);
        return rb;
    }
    public static <T> Result success(T data,String message) {
        Result rb = new Result();
        rb.setCode(ErrorEnum.SUCCESS.getResultCode());
        rb.setMessage(message);
        rb.setDate(data);
        return rb;
    }
    /**
     * 失败
     */
    public static Result error(BaseErrorInfoInterface errorInfo) {
        Result rb = new Result();
        rb.setCode(errorInfo.getResultCode());
        rb.setMessage(errorInfo.getResultMsg());
        rb.setDate(null);
        return rb;
    }

    /**
     * 失败
     */
    public static Result error(String code, String message) {
        Result rb = new Result();
        rb.setCode(code);
        rb.setMessage(message);
        rb.setDate(null);
        return rb;
    }

    /**
     * 失败
     */
    public static Result error( String message) {
        Result rb = new Result();
        rb.setCode("20001");
        rb.setMessage(message);
        rb.setDate(null);
        return rb;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }


    public Result data(T value){
        this.data = value;
        return this;
    }
}
