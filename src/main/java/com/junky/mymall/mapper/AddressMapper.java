package com.junky.mymall.mapper;

import com.junky.mymall.entity.Address;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Class AddressMapper
 * Effect
 * Created by junky
 * on 2018/7/13
 */
public interface AddressMapper {


    @Insert("insert into address (address_id,address_name,address_phone,detail,user_id) " +
            "value (#{addressId},#{addressName},#{addressPhone},#{detail},#{userId})")
    int insertAddress(Address address);


    @Delete("delete from address where address_id=#{addressId}")
    int deleteAddress(String addressId);


    @Update("update address set address_name=#{addressName},address_phone=#{addressPhone}," +
            "detail=#{detail},user_id=#{userId} where address_id=#{addressId}")
    int updateAddress(Address address);


    @Select("select * from address where address_id=#{addressId}")
    @Results({
            @Result(column = "address_id", property = "addressId"),
            @Result(column = "address_name", property = "addressName"),
            @Result(column = "address_phone", property = "addressPhone"),
            @Result(column = "detail", property = "detail"),
            @Result(column = "user_id", property = "userId")
    })
    Address selectAddressById(String addressId);


    @Select("select * from address where user_id=#{userId}")
    @Results({
            @Result(column = "address_id", property = "addressId"),
            @Result(column = "address_name", property = "addressName"),
            @Result(column = "address_phone", property = "addressPhone"),
            @Result(column = "detail", property = "detail"),
            @Result(column = "user_id", property = "userId")
    })
    List<Address> seletAddressByUserId(String userId);

}
