package com.junky.mymall.service.impl;

import com.junky.mymall.entity.ProductCategory;
import com.junky.mymall.entity.Seller;
import com.junky.mymall.mapper.ProductCategoryMapper;
import com.junky.mymall.mapper.SellerMapper;
import com.junky.mymall.service.ProductCategoryService;
import com.junky.mymall.utils.UniqueKeyUtil;
import com.junky.mymall.utils.exception.MallException;
import com.junky.mymall.utils.exception.MallExceptionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Class ProductCategoryServiceImpl
 * Effect
 * Created by junky
 * on 2018/7/20
 */
@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {


    @Autowired
    private ProductCategoryMapper mapper;

    @Autowired
    SellerMapper sellerMapper;

    @Override
    public int addCategory(ProductCategory category) {

        // 验证参数
        if (category.getCategoryId() == null || StringUtils.isEmpty(category.getCategoryId())) {
            category.setCategoryId(UniqueKeyUtil.getUniqueKey());
        }
        if (category.getCategoryName() == null || StringUtils.isEmpty(category.getCategoryName())) {
            throw new MallException(MallExceptionEnum.CATEGORY_ERROR_NAMEEMPTY);
        }
        if (category.getSellerId() == null || StringUtils.isEmpty(category.getSellerId())) {
            throw new MallException(MallExceptionEnum.CATEGORY_ERROR_SELLERID);
        }

        Seller seller = sellerMapper.selectSellerById(category.getSellerId());
        if (seller == null) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_NOEXITACCOUNT);
        }

        // 插入
        int result = mapper.insertProductCategory(category);
        if (result <= 0) {
            throw new MallException(MallExceptionEnum.SQL_ERROR_INSERT);
        }
        return result;
    }

    @Override
    public int deleteCategory(String categoryId) {

        // 验证参数
        if (categoryId == null || StringUtils.isEmpty(categoryId)) {
            throw new MallException(MallExceptionEnum.CATEGORY_ERROR_ID);
        }

        // 验证该category是否存在
        ProductCategory category = mapper.selectCategoryById(categoryId);
        if (category == null) {
            throw new MallException(MallExceptionEnum.CATEGORY_ERROR_ID);
        }

        // 删除
        int result = mapper.deleteProductCategoryById(categoryId);
        if (result <= 0) {
            throw new MallException(MallExceptionEnum.SQL_ERROR_DELETE);
        }

        return result;
    }

    @Override
    public int updateCategory(ProductCategory category) {

        // 验证参数
        if (category == null || StringUtils.isEmpty(category)) {
            throw new MallException(MallExceptionEnum.CATEGORY_ERROR_ID);
        }
        if (category.getCategoryName() == null || StringUtils.isEmpty(category.getCategoryName())) {
            throw new MallException(MallExceptionEnum.CATEGORY_ERROR_NAMEEMPTY);
        }
        if (category.getSellerId() == null || StringUtils.isEmpty(category.getSellerId())) {
            throw new MallException(MallExceptionEnum.CATEGORY_ERROR_SELLERID);
        }

        // 验证该category是否存在
        ProductCategory productCategory = mapper.selectCategoryById(category.getCategoryId());
        if (category == null) {
            throw new MallException(MallExceptionEnum.CATEGORY_ERROR_ID);
        }

        int result = mapper.updateProductCategory(category);
        if (result <= 0) {
            throw new MallException(MallExceptionEnum.SQL_ERROR_UPDATE);
        }

        return result;
    }

    @Override
    public List<ProductCategory> selectCategoryBySellerId(String sellerId) {

        // 验证参数
        if (sellerId == null || StringUtils.isEmpty(sellerId)) {
            throw new MallException(MallExceptionEnum.CATEGORY_ERROR_SELLERID);
        }

        List<ProductCategory> categories = mapper.selectCategoryBySellerId(sellerId);

        return categories;
    }
}
