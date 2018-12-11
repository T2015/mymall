package com.junky.mymall.utils;

import java.util.Random;

/**
 * Class UniqueKeyUtil
 * Effect
 * Created by junky
 * on 2018/7/13
 */
public class UniqueKeyUtil {


    /**
     * 生成唯一主键
     * 格式：时间加上随机数
     *
     * @return
     */
    public static synchronized String getUniqueKey() {

        Random random = new Random();
        Integer number = random.nextInt(900000) + 100000;
        return System.currentTimeMillis() + String.valueOf(number);
    }


}
