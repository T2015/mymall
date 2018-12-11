package com.junky.mymall.service.impl;

import com.junky.mymall.entity.Seller;
import com.junky.mymall.mapper.SellerMapper;
import com.junky.mymall.service.SellerService;
import com.junky.mymall.utils.UniqueKeyUtil;
import com.junky.mymall.utils.exception.MallException;
import com.junky.mymall.utils.exception.MallExceptionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

/**
 * Class SellerServiceImpl
 * Effect
 * Created by junky
 * on 2018/7/14
 */

@Service
public class SellerServiceImpl implements SellerService {


    @Autowired
    private SellerMapper mapper;


    @Override
    public Seller register(Seller seller) {

        // 判断属性
        if (seller.getSellerId() == null || StringUtils.isEmpty(seller.getSellerId())) {
            seller.setSellerId(UniqueKeyUtil.getUniqueKey());
        }
        if (seller.getSellerName() == null || StringUtils.isEmpty(seller.getSellerName())) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_NAMEEMPTY);
        }
        if (seller.getSellerPhone() == null || StringUtils.isEmpty(seller.getSellerPhone())) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_PHONEEMPTY);
        }
        if (seller.getSellerPassword() == null || StringUtils.isEmpty(seller.getSellerPassword())) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_PASSWORD);
        }
        if (seller.getSellerIcon() == null || StringUtils.isEmpty(seller.getSellerIcon())) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_ICONEMPTY);
        }
        if (seller.getSellerDesc() == null || StringUtils.isEmpty(seller.getSellerDesc())) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_DESCEMPTY);
        }
        if (seller.getSellerAddress() == null || StringUtils.isEmpty(seller.getSellerAddress())) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_ADDRESSEMPTY);
        }

        // 插入数据库
        int result = mapper.insertSeller(seller);
        if (result < 1) {
            throw new MallException(MallExceptionEnum.SQL_ERROR_INSERT);
        }

        // 返回seller
        return seller;
    }

    @Override
    public Seller login(String phone, String password) {

        // 判断phone是否有
        if (phone == null || StringUtils.isEmpty(phone)) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_PHONEEMPTY);
        }
        if (password == null || StringUtils.isEmpty(password)) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_PASSWORDEMPTY);
        }

        // 查找用户
        Seller result = mapper.selectSellerByPhone(phone);
        if (result == null) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_NOEXITACCOUNT);
        }

        // 判断密码
        if (!password.equals(result.getSellerPassword())) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_PASSWORD);
        }
        // 返回账户信息
        return result;
    }

    @Override
    public Seller update(Seller seller) {

        // 判断必须的参数
        if (seller.getSellerId() == null || StringUtils.isEmpty(seller.getSellerId())) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_IDEMPTY);
        }
        if (seller.getSellerName() == null || StringUtils.isEmpty(seller.getSellerName())) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_IDEMPTY);
        }
        if (seller.getSellerPhone() == null || StringUtils.isEmpty(seller.getSellerPhone())) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_PHONEEMPTY);
        }
        if (seller.getSellerPassword() == null || StringUtils.isEmpty(seller.getSellerPassword())) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_PASSWORD);
        }
        if (seller.getSellerIcon() == null || StringUtils.isEmpty(seller.getSellerIcon())) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_ICONEMPTY);
        }
        if (seller.getSellerDesc() == null || StringUtils.isEmpty(seller.getSellerDesc())) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_DESCEMPTY);
        }
        if (seller.getSellerAddress() == null || StringUtils.isEmpty(seller.getSellerAddress())) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_ADDRESSEMPTY);
        }
        // 更新数据库
        int result = mapper.updateSeller(seller);
        if (result < 1) {
            throw new MallException(MallExceptionEnum.SQL_ERROR_UPDATE);
        }
        // 返回数据
        return seller;
    }

    @Override
    public int delete(String sellerId) {

        // 判断参数
        if (sellerId == null || StringUtils.isEmpty(sellerId)) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_IDEMPTY);
        }

        // 删除
        int result = mapper.deleteSellerById(sellerId);
        if (result < 1) {
            throw new MallException(MallExceptionEnum.SQL_ERROR_DELETE);
        }

        return result;
    }
}
