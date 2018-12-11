package com.junky.mymall.utils;

import com.junky.mymall.vo.response.ResultVO;

/**
 * Class ResultUtil
 * Effect
 * Created by junky
 * on 2018/7/13
 */
public class ResultUtil {


    public static ResultVO success(Object object) {
        ResultVO resultVO = new ResultVO();
        resultVO.setData(object);
        resultVO.setCode(0);
        resultVO.setMessage("请求成功");
        return resultVO;
    }

    public static ResultVO success() {
        return success(null);
    }

    public static ResultVO error(Integer code, String msg) {
        ResultVO resultVO = new ResultVO();
        resultVO.setCode(code);
        resultVO.setMessage(msg);
        return resultVO;
    }
}
