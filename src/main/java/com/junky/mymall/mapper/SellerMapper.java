package com.junky.mymall.mapper;

import com.junky.mymall.entity.Product;
import com.junky.mymall.entity.Seller;
import org.apache.ibatis.annotations.*;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Class SellerMapper
 * Effect
 * Created by junky
 * on 2018/7/13
 */
public interface SellerMapper {


    @Insert("insert into seller(seller_id,seller_name,seller_phone,seller_password," +
            "seller_icon,seller_desc,seller_address) " +
            "value(#{sellerId},#{sellerName},#{sellerPhone},#{sellerPassword}," +
            "#{sellerIcon},#{sellerDesc},#{sellerAddress})")
    int insertSeller(Seller seller);


    @Delete("delete seller where seller_id=#{sellerId}")
    int deleteSellerById(String sellerId);


    @Update("update seller set seller_name=#{sellerName},seller_phone=#{sellerPhone}," +
            "seller_password=#{sellerPassword},seller_icon=#{sellerIcon},seller_desc=#{sellerDesc}," +
            "seller_address=#{sellerAddress} where seller_id=#{sellerId}")
    int updateSeller(Seller seller);


    @Select("select * from seller where seller_id=#{sellerId}")
    @Results({
            @Result(column = "seller_id", property = "sellerId"),
            @Result(column = "seller_name", property = "sellerName"),
            @Result(column = "seller_phone", property = "sellerPhone"),
            @Result(column = "seller_password", property = "sellerPassword"),
            @Result(column = "seller_icon", property = "sellerIcon"),
            @Result(column = "seller_desc", property = "sellerDesc"),
            @Result(column = "seller_address", property = "sellerAddress")
    })
    Seller selectSellerById(String sellerId);


    @Select("select * from seller where seller_phone=#{sellerPhone}")
    @Results({
            @Result(column = "seller_id", property = "sellerId"),
            @Result(column = "seller_name", property = "sellerName"),
            @Result(column = "seller_phone", property = "sellerPhone"),
            @Result(column = "seller_password", property = "sellerPassword"),
            @Result(column = "seller_icon", property = "sellerIcon"),
            @Result(column = "seller_desc", property = "sellerDesc"),
            @Result(column = "seller_address", property = "sellerAddress")
    })
    Seller selectSellerByPhone(String sellerPhone);


}
