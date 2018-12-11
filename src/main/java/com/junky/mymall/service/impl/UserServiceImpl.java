package com.junky.mymall.service.impl;


import com.junky.mymall.entity.User;
import com.junky.mymall.mapper.UserMapper;
import com.junky.mymall.service.UserService;
import com.junky.mymall.utils.UniqueKeyUtil;
import com.junky.mymall.utils.exception.MallException;
import com.junky.mymall.utils.exception.MallExceptionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Class UserServiceImpl
 * Effect
 * Created by junky
 * on 2018/7/13
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper mapper;

    @Override
    public User registerUser(User user) {

        // 检查数据
        if (user.getPhone() == null || StringUtils.isEmpty(user.getPhone())) {
            throw new MallException(MallExceptionEnum.USER_ERROR_PHONEEMPTY);
        }
        if (user.getPassword() == null || StringUtils.isEmpty(user.getPassword())) {
            throw new MallException(MallExceptionEnum.USER_ERROR_PASSWORDEMPTY);
        }
        if (user.getUserId() == null || StringUtils.isEmpty(user.getUserId())) {
            user.setUserId(UniqueKeyUtil.getUniqueKey());
        }
        if (user.getAccount() == null || StringUtils.isEmpty(user.getAccount())) {
            user.setAccount(user.getPhone());
        }
        if (user.getUserName() == null || StringUtils.isEmpty(user.getUserId())) {
            user.setUserName(user.getPhone());
        }

        // 查询数据库中是否有该用户  判断是否已注册？
        User selectResult = mapper.selectOneByAccount(user.getAccount());
        if (selectResult != null) {
            throw new MallException(MallExceptionEnum.USER_ERROR_EXITACCOUNT);
        }


        // 插入数据库
        int result = mapper.inserUser(user);
        if (result <= 0) {
            throw new MallException(MallExceptionEnum.SQL_ERROR_INSERT);
        }
        return user;
    }

    @Override
    public User loginUser(String account, String password) {


        // 检查数据
        if (password == null || StringUtils.isEmpty(password)) {
            throw new MallException(MallExceptionEnum.USER_ERROR_PASSWORDEMPTY);
        }
        if (account == null || StringUtils.isEmpty(account)) {
            throw new MallException(MallExceptionEnum.USER_ERROR_ACCOUNTEMPTY);
        }


        // 查询数据库中是否有该用户   判断是否已注册
        User selectResult = mapper.selectOneByAccount(account);
        if (selectResult == null) {
            throw new MallException(MallExceptionEnum.USER_ERROR_NOEXITACCOUNT);
        }

        // 验证密码
        if (!password.equals(selectResult.getPassword())) {
            throw new MallException(MallExceptionEnum.USER_ERROR_PASSWORD);
        }

        // 返回数据
        return selectResult;
    }


    @Override
    public User updateUser(User user) {

        // 检查数据
        if (user.getPhone() == null || StringUtils.isEmpty(user.getPhone())) {
            throw new MallException(MallExceptionEnum.USER_ERROR_PHONEEMPTY);
        }
        if (user.getPassword() == null || StringUtils.isEmpty(user.getPassword())) {
            throw new MallException(MallExceptionEnum.USER_ERROR_PASSWORDEMPTY);
        }
        if (user.getUserId() == null || StringUtils.isEmpty(user.getUserId())) {
            user.setUserId(UniqueKeyUtil.getUniqueKey());
        }
        if (user.getAccount() == null || StringUtils.isEmpty(user.getAccount())) {
            user.setAccount(user.getPhone());
        }
        if (user.getUserName() == null || StringUtils.isEmpty(user.getUserId())) {
            user.setUserName(user.getPhone());
        }

        // 查询数据库中是否有该用户   判断是否已注册
        User selectResult = mapper.selectByUserId(user.getUserId());
        if (selectResult == null) {
            throw new MallException(MallExceptionEnum.USER_ERROR_NOEXITACCOUNT);
        }

        // 更新数据
        int result = mapper.updateUser(user);
        if (result <= 0) {
            throw new MallException(MallExceptionEnum.SQL_ERROR_UPDATE);
        }

        // 返回数据
        return user;
    }
}
