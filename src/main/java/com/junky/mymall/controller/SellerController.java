package com.junky.mymall.controller;

import com.junky.mymall.entity.Seller;
import com.junky.mymall.service.SellerService;
import com.junky.mymall.utils.ResultUtil;
import com.junky.mymall.vo.response.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Class SellerController
 * Effect
 * Created by junky
 * on 2018/7/14
 */

@RestController
@RequestMapping("/seller")
public class SellerController {


    @Autowired
    private SellerService sellerService;

    @RequestMapping("/login.do")
    public ResultVO login(@Valid Seller seller) {

        // service操作
        Seller result = sellerService.login(seller.getSellerPhone(), seller.getSellerPassword());
        // 返回数据
        return ResultUtil.success(result);
    }


    @RequestMapping("/regoster.do")
    public ResultVO register(@Valid Seller seller) {

        // service操作
        Seller result = sellerService.register(seller);
        //返回数据
        return ResultUtil.success(result);
    }

    @RequestMapping("/update.do")
    public ResultVO update(@Valid Seller seller) {

        // service操作
        Seller result = sellerService.update(seller);
        // 返回数据
        return ResultUtil.success(result);
    }


}
