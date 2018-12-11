package com.junky.mymall.utils.exception;

import com.junky.mymall.utils.ResultUtil;
import com.junky.mymall.vo.response.ResultVO;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Class MallExcaptionHandler
 * Effect
 * Created by junky
 * on 2018/7/13
 */

@ControllerAdvice
public class MallExcaptionHandler {


    @ExceptionHandler(value = MallException.class)
    @ResponseBody
    public ResultVO handlerMallException(MallException e) {
        return ResultUtil.error(e.getCode(), e.getMessage());
    }


}
