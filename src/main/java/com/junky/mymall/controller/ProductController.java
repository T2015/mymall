package com.junky.mymall.controller;

import com.junky.mymall.entity.Product;
import com.junky.mymall.service.ProductService;
import com.junky.mymall.utils.ResultUtil;
import com.junky.mymall.vo.request.ProductListParam;
import com.junky.mymall.vo.response.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import sun.jvm.hotspot.debugger.Page;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

/**
 * Class ProductController
 * Effect
 * Created by junky
 * on 2018/7/13
 */

@RestController
@RequestMapping("/product")
public class ProductController {


    @Autowired
    private ProductService productService;

    @RequestMapping("/list.do")
    public ResultVO list(@Valid ProductListParam productListParam) {

        // service查询
        List<Product> products = productService.selectList(productListParam.getSellerId(), productListParam.getPageNo(), productListParam.getPageSize());

        // 返回值
        return ResultUtil.success(products);
    }

    @RequestMapping("/insert.do")
    public ResultVO insert(@Valid Product product) {

        // service操作
        Product result = productService.insertProduct(product);
        // 返回结果
        return ResultUtil.success(result);
    }


    @RequestMapping("/delete.do")
    public ResultVO delete(@Valid Product product) {

        // service操作
        int result = productService.deleteProduct(product.getProductId());
        // 返回结果
        return ResultUtil.success(result);
    }

    @RequestMapping("/update.do")
    public ResultVO update(@Valid Product product) {

        // service操作
        int result = productService.updateProduct(product);
        // 返回结果
        return ResultUtil.success(result);
    }


}
