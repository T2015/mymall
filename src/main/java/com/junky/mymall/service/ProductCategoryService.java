package com.junky.mymall.service;

import com.junky.mymall.entity.ProductCategory;

import java.util.List;

/**
 * Class ProductCategoryService
 * Effect
 * Created by junky
 * on 2018/7/20
 */
public interface ProductCategoryService {


    int addCategory(ProductCategory category);


    int deleteCategory(String categoryId);


    int updateCategory(ProductCategory category);


    List<ProductCategory> selectCategoryBySellerId(String sellerId);


}
