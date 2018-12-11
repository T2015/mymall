package com.junky.mymall.mapper;


import com.junky.mymall.entity.User;
import org.apache.ibatis.annotations.*;

/**
 * Class UserMapper
 * Effect
 * Created by junky
 * on 2018/7/13
 */
public interface UserMapper {

    /**
     * 查询用户
     *
     * @param userId
     * @return
     */
    @Select("select * from user where user_id=#{userId}")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "account", property = "account"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "password", property = "password"),
            @Result(column = "user_name", property = "userName")
    })
    User selectByUserId(String userId);


    /**
     * 通过账号查询
     *
     * @param account
     * @return
     */
    @Select("select * from user where account=#{account}")
    @Results({
            @Result(column = "user_id", property = "userId"),
            @Result(column = "account", property = "account"),
            @Result(column = "sex", property = "sex"),
            @Result(column = "phone", property = "phone"),
            @Result(column = "password", property = "password"),
            @Result(column = "user_name", property = "userName")
    })
    User selectOneByAccount(String account);


    /**
     * 增加用户
     *
     * @param user
     * @return
     */
    @Insert("insert into user(user_id,account,sex,phone,password,user_name) value(#{userId},#{account},#{sex},#{phone},#{password},#{userName})")
    int inserUser(User user);


    /**
     * 更新用户
     *
     * @param user
     * @return
     */
    @Update("update user set account=#{account},sex=#{sex},phone=#{phone},password=#{password},user_name=#{userName} where user_id=#{userId}")
    int updateUser(User user);


}
