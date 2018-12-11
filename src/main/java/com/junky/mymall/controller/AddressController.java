package com.junky.mymall.controller;

import com.junky.mymall.entity.Address;
import com.junky.mymall.service.AddressService;
import com.junky.mymall.utils.ResultUtil;
import com.junky.mymall.vo.response.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Class AddressController
 * Effect
 * Created by junky
 * on 2018/7/24
 */

@RestController
@RequestMapping("/address")
public class AddressController {

    @Autowired
    AddressService addressService;


    @RequestMapping("/insert.do")
    public ResultVO insertAddress(@Valid Address address) {

        int result = addressService.insertAddress(address);
        return ResultUtil.success(address);
    }


    @RequestMapping("/delete")
    public ResultVO deleteAddress(@RequestParam("addressId") String addressId) {

        int result = addressService.deleteAddress(addressId);
        return ResultUtil.success();
    }


    @RequestMapping("/update")
    public ResultVO updateAddress(@Valid Address address) {

        int result = addressService.updateAddress(address);
        return ResultUtil.success(address);
    }


    public ResultVO selectAddressByUser(@RequestParam("userId") String userId) {

        List<Address> addresses = addressService.selectAddressByUserId(userId);
        return ResultUtil.success(addresses);
    }

}
