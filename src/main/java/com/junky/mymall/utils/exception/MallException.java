package com.junky.mymall.utils.exception;

/**
 * Class MallException
 * Effect
 * Created by junky
 * on 2018/7/13
 */
public class MallException extends RuntimeException {

    private Integer code;


    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public MallException(MallExceptionEnum exceptionEnum) {
        super(exceptionEnum.getMessage());
        this.code = exceptionEnum.getCode();
    }
}
