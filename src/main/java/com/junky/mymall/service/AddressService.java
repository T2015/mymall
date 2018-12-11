package com.junky.mymall.service;

import com.junky.mymall.entity.Address;
import org.apache.catalina.Executor;

import java.util.List;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Class AddressService
 * Effect
 * Created by junky
 * on 2018/7/20
 */
public interface AddressService {

    int insertAddress(Address address);


    int deleteAddress(String addressId);


    int updateAddress(Address address);


    List<Address> selectAddressByUserId(String userId);

}
