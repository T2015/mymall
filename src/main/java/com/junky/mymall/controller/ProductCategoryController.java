package com.junky.mymall.controller;

import com.junky.mymall.entity.ProductCategory;
import com.junky.mymall.service.ProductCategoryService;
import com.junky.mymall.utils.ResultUtil;
import com.junky.mymall.vo.response.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * Class ProductCategoryController
 * Effect
 * Created by junky
 * on 2018/7/24
 */
@RestController
@RequestMapping("/productCategory")
public class ProductCategoryController {

    @Autowired
    ProductCategoryService productCategoryService;


    @RequestMapping("/insert.do")
    public ResultVO insertCategory(@Valid ProductCategory category) {

        int result = productCategoryService.addCategory(category);
        return ResultUtil.success();
    }


    @RequestMapping("/delete.do")
    public ResultVO deleteCategory(@RequestParam("categoryId") String categoryId) {

        int result = productCategoryService.deleteCategory(categoryId);
        return ResultUtil.success();
    }


    @RequestMapping("/update.do")
    public ResultVO updateCategory(@Valid ProductCategory category) {

        int result = productCategoryService.updateCategory(category);
        return ResultUtil.success();
    }


    @RequestMapping("/selectBySeller.do")
    public ResultVO selectCategoryBySeller(@Valid String sellerId) {

        List<ProductCategory> result = productCategoryService.selectCategoryBySellerId(sellerId);
        return ResultUtil.success(result);
    }


}
