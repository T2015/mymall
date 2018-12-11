package com.junky.mymall.mapper;

import com.junky.mymall.entity.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Class ProductMapper
 * Effect
 * Created by junky
 * on 2018/7/13
 */
public interface ProductMapper {

    /**
     * 增
     *
     * @param product
     * @return
     */
    @Insert("insert Product(product_id,product_name,product_price,product_icon,product_desc,product_discount,seller_id,product_category_id)" +
            "value(#{productId},#{productName},#{productPrice},#{productIcon},#{productDesc},#{productDiscount},#{sellerId},#{productCategoryId})")
    int insertProduct(Product product);


    /**
     * 删
     *
     * @param productId
     * @return
     */
    @Delete("delete from product where product_id=#{productId}")
    int delegateProduct(String productId);


    /**
     * 改
     *
     * @param product
     * @return
     */
    @Update("update product set " +
            "product_name=#{productName},product_price=#{productPrice}," +
            "product_icon=#{productIcon},product_desc=#{productDesc}," +
            "product_discount=#{productDiscount},seller_id=#{sellerId}," +
            "product_category_id=#{productCategoryId} " +
            "where product_id=#{productId}")
    int updateProduct(Product product);


    /**
     * @param productId
     * @return
     */
    @Select("select * from product where product_id=#{productId}")
    Product selectByProductId(String productId);


    /**
     * 查询所有
     *
     * @param sellerId
     * @return
     */
    @Select("select * from product where seller_id=#{sellerId}")
    @Results({
            @Result(column = "product_id", property = "productId"),
            @Result(column = "product_name", property = "productName"),
            @Result(column = "product_price", property = "productPrice"),
            @Result(column = "product_icon", property = "productIcon"),
            @Result(column = "product_desc", property = "productDesc"),
            @Result(column = "product_discount", property = "productDiscount"),
            @Result(column = "seller_id", property = "sellerId"),
            @Result(column = "product_category_id", property = "productCategoryId")
    })
    List<Product> selectListAll(String sellerId);


    /**
     * 分页查询
     *
     * @param sellerId
     * @param pageNo
     * @param pageSize
     * @return
     */
    @Select("select * from product where seller_id=#{sellerId} limit #{pageNo},#{pageSize}")
    @Results({
            @Result(column = "product_id", property = "productId"),
            @Result(column = "product_name", property = "productName"),
            @Result(column = "product_price", property = "productPrice"),
            @Result(column = "product_icon", property = "productIcon"),
            @Result(column = "product_desc", property = "productDesc"),
            @Result(column = "product_discount", property = "productDiscount"),
            @Result(column = "seller_id", property = "sellerId"),
            @Result(column = "product_category_id", property = "productCategoryId")
    })
    List<Product> selectList(@Param("sellerId") String sellerId,
                             @Param("pageNo") Integer pageNo,
                             @Param("pageSize") Integer pageSize);

}
