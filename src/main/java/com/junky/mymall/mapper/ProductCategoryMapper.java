package com.junky.mymall.mapper;

import com.junky.mymall.entity.ProductCategory;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Class ProductCategoryMapper
 * Effect
 * Created by junky
 * on 2018/7/13
 */
public interface ProductCategoryMapper {


    @Insert("insert into product_category(category_id,category_name,seller_id) " +
            "value(#{categoryId},#{categoryName},#{sellerId})")
    int insertProductCategory(ProductCategory category);


    @Delete("delete from product_category where category_id=#{categoryId}")
    int deleteProductCategoryById(String categoryId);


    @Update("update product_category set category_name=#{categoryName},seller_id=#{sellerId} " +
            "where category_id=#{categoryId}")
    int updateProductCategory(ProductCategory category);


    @Select("select * from product_category where seller_id=#{sellerId}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "seller_id", property = "sellerId")
    })
    List<ProductCategory> selectCategoryBySellerId(String sellerId);

    @Select("select * from product_category where category_id=#{categoryId}")
    @Results({
            @Result(column = "category_id", property = "categoryId"),
            @Result(column = "category_name", property = "categoryName"),
            @Result(column = "seller_id", property = "sellerId")
    })
    ProductCategory selectCategoryById(String categoryId);


}
