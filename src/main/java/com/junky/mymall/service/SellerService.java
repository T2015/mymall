package com.junky.mymall.service;

import com.junky.mymall.entity.Seller;

/**
 * Class SellerService
 * Effect
 * Created by junky
 * on 2018/7/14
 */
public interface SellerService {


    Seller register(Seller seller);


    Seller login(String phone, String password);


    Seller update(Seller seller);


    int delete(String sellerId);

}
