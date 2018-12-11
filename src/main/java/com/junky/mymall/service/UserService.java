package com.junky.mymall.service;


import com.junky.mymall.entity.User;

/**
 * Class UserService
 * Effect
 * Created by junky
 * on 2018/7/13
 */
public interface UserService {

    /**
     * 注册用户
     *
     * @param user
     * @return
     */
    User registerUser(User user);

    /**
     * 登录用户
     *
     * @param account
     * @param password
     * @return
     */
    public User loginUser(String account, String password);

    /**
     * 更新用户信息
     *
     * @param user
     * @return
     */
    User updateUser(User user);

}
