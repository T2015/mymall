package com.junky.mymall.service;

import com.junky.mymall.entity.Product;
import com.junky.mymall.entity.Seller;

import java.util.List;

/**
 * Class ProductService
 * Effect
 * Created by junky
 * on 2018/7/13
 */
public interface ProductService {

    Product insertProduct(Product product);

    int deleteProduct(String productId);


    int updateProduct(Product product);


    List<Product> selectList(String sellerId);


    List<Product> selectList(String sellerId, Integer pageNo, Integer size);


}
