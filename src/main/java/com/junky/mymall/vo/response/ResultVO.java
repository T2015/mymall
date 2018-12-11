package com.junky.mymall.vo.response;

/**
 * Class ResultVO
 * Effect
 * Created by junky
 * on 2018/7/13
 */
public class ResultVO<T> {

    /**
     * 返回code
     */
    private Integer code;

    /**
     * 返回的信息
     */
    private String message;

    /**
     * 返回的内容
     */
    private T data;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }


}
