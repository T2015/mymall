package com.junky.mymall.service.impl;

import com.junky.mymall.entity.Product;
import com.junky.mymall.entity.ProductCategory;
import com.junky.mymall.entity.Seller;
import com.junky.mymall.mapper.ProductCategoryMapper;
import com.junky.mymall.mapper.ProductMapper;
import com.junky.mymall.mapper.SellerMapper;
import com.junky.mymall.service.ProductService;
import com.junky.mymall.utils.UniqueKeyUtil;
import com.junky.mymall.utils.exception.MallException;
import com.junky.mymall.utils.exception.MallExceptionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Class ProductServiceImpl
 * Effect
 * Created by junky
 * on 2018/7/13
 */

@Service
public class ProductServiceImpl implements ProductService {


    @Autowired
    private ProductMapper productMapper;

    @Autowired
    SellerMapper sellerMapper;

    @Autowired
    ProductCategoryMapper productCategoryMapper;


    @Override
    public Product insertProduct(Product product) {

        if (product.getProductId() == null || StringUtils.isEmpty(product.getProductId())) {
            product.setProductId(UniqueKeyUtil.getUniqueKey());
        }
        if (product.getProductName() == null || StringUtils.isEmpty(product.getProductName())) {
            throw new MallException(MallExceptionEnum.PRODUCT_ERROR_NAMEEMPTY);
        }
        if (product.getProductPrice() <= 0) {
            throw new MallException(MallExceptionEnum.PRODUCT_ERROR_PRICEEMPTY);
        }
        if (product.getProductIcon() == null || StringUtils.isEmpty(product.getProductIcon())) {
            throw new MallException(MallExceptionEnum.PRODUCT_ERROR_ICONEMPTY);
        }
        if (product.getProductDesc() == null || StringUtils.isEmpty(product.getProductDesc())) {
            throw new MallException(MallExceptionEnum.PRODUCT_ERROR_DESCEMPTY);
        }
        if (product.getProductDiscount() <= 0) {
            throw new MallException(MallExceptionEnum.PRODUCT_ERROR_DISCOUNTEMPTY);
        }
        if (product.getSellerId() == null || StringUtils.isEmpty(product.getSellerId())) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_IDEMPTY);
        }
        if (product.getProductCategoryId() == null || StringUtils.isEmpty(product.getProductCategoryId())) {
            throw new MallException(MallExceptionEnum.CATEGORY_ERROR_ID);
        }

        Seller seller = sellerMapper.selectSellerById(product.getSellerId());
        if (seller == null) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_NOEXITACCOUNT);
        }

        ProductCategory category = productCategoryMapper.selectCategoryById(product.getProductCategoryId());
        if (category == null) {
            throw new MallException(MallExceptionEnum.CATEGORY_ERROR_ID);
        }

        int result = productMapper.insertProduct(product);
        if (result < 1) {
            throw new MallException(MallExceptionEnum.SQL_ERROR_INSERT);
        }
        return product;
    }

    @Override
    public int deleteProduct(String productId) {

        // 验证参数
        if (productId == null || StringUtils.isEmpty(productId)) {
            throw new MallException(MallExceptionEnum.PRODUCT_ERROR_IDEMPTY);
        }

        Product product = productMapper.selectByProductId(productId);
        if (product == null) {
            throw new MallException(MallExceptionEnum.PRODUCT_ERROR_NOEXIT);
        }
        // 删除数据
        int result = productMapper.delegateProduct(productId);
        if (result < 1) {
            throw new MallException(MallExceptionEnum.SQL_ERROR_DELETE);
        }

        // 返回结果
        return result;
    }


    public int updateProduct(Product product) {

        if (product.getProductId() == null || StringUtils.isEmpty(product.getProductId())) {
            throw new MallException(MallExceptionEnum.PRODUCT_ERROR_IDEMPTY);
        }
        if (product.getProductName() == null || StringUtils.isEmpty(product.getProductName())) {
            throw new MallException(MallExceptionEnum.PRODUCT_ERROR_NAMEEMPTY);
        }
        if (product.getProductPrice() <= 0) {
            throw new MallException(MallExceptionEnum.PRODUCT_ERROR_PRICEEMPTY);
        }
        if (product.getProductIcon() == null || StringUtils.isEmpty(product.getProductIcon())) {
            throw new MallException(MallExceptionEnum.PRODUCT_ERROR_ICONEMPTY);
        }
        if (product.getProductDesc() == null || StringUtils.isEmpty(product.getProductDesc())) {
            throw new MallException(MallExceptionEnum.PRODUCT_ERROR_DESCEMPTY);
        }
        if (product.getProductDiscount() <= 0) {
            throw new MallException(MallExceptionEnum.PRODUCT_ERROR_DISCOUNTEMPTY);
        }
        if (product.getSellerId() == null || StringUtils.isEmpty(product.getSellerId())) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_IDEMPTY);
        }
        if (product.getProductCategoryId() == null || StringUtils.isEmpty(product.getProductCategoryId())) {
            throw new MallException(MallExceptionEnum.CATEGORY_ERROR_ID);
        }

        Product product1 = productMapper.selectByProductId(product.getProductId());
        if (product == null) {
            throw new MallException(MallExceptionEnum.PRODUCT_ERROR_IDEMPTY);
        }

        int result = productMapper.updateProduct(product);
        if (result < 1) {
            throw new MallException(MallExceptionEnum.SQL_ERROR_UPDATE);
        }
        return result;
    }


    @Override
    public List<Product> selectList(String sellerId) {

        // 验证参数
        if (sellerId == null || StringUtils.isEmpty(sellerId)) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_ICONEMPTY);
        }

        Seller seller = sellerMapper.selectSellerById(sellerId);
        if (seller == null) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_NOEXITACCOUNT);
        }

        // 查询数据库
        List<Product> productList = productMapper.selectListAll(sellerId);

        // 返回数据
        return productList;
    }

    @Override
    public List<Product> selectList(String sellerId, Integer pageNo, Integer size) {

        if (sellerId == null || StringUtils.isEmpty(sellerId)) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_ICONEMPTY);
        }
        if (pageNo < 0) {
            throw new MallException(MallExceptionEnum.PRODUCT_ERROR_PAGENO);
        }
        if (size <= 0) {
            throw new MallException(MallExceptionEnum.PRODUCT_ERROR_PAGESIZE);
        }

        Seller seller = sellerMapper.selectSellerById(sellerId);
        if (seller == null) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_NOEXITACCOUNT);
        }

        List<Product> productList = productMapper.selectList(sellerId, pageNo, size);
        return productList;
    }
}
