package com.junky.mymall.controller;


import com.junky.mymall.entity.User;
import com.junky.mymall.service.UserService;
import com.junky.mymall.utils.ResultUtil;
import com.junky.mymall.vo.response.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Class UserController
 * Effect
 * Created by junky
 * on 2018/7/13
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;


    @RequestMapping("/login.do")
    public ResultVO login(@Valid User user) {

        // 登录操作
        User result = userService.loginUser(user.getAccount(), user.getPassword());
        // 返回
        return ResultUtil.success(result);
    }

    @RequestMapping("/register.do")
    public ResultVO register(@Valid User user) {

        // 注册操作
        User result = userService.registerUser(user);

        // 返回
        return ResultUtil.success(result);
    }


    @RequestMapping("/update.do")
    public ResultVO update(@Valid User user) {

        // 更新操作
        User result = userService.updateUser(user);

        // 返回
        return ResultUtil.success(result);
    }


}
