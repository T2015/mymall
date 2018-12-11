package com.junky.mymall.service.impl;

import com.junky.mymall.entity.Address;
import com.junky.mymall.entity.User;
import com.junky.mymall.mapper.AddressMapper;
import com.junky.mymall.mapper.UserMapper;
import com.junky.mymall.service.AddressService;
import com.junky.mymall.utils.UniqueKeyUtil;
import com.junky.mymall.utils.exception.MallException;
import com.junky.mymall.utils.exception.MallExceptionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Class AddressServiceImpl
 * Effect
 * Created by junky
 * on 2018/7/23
 */
@Service
public class AddressServiceImpl implements AddressService {


    @Autowired
    private AddressMapper addressMapper;

    @Autowired
    private UserMapper userMapper;

    @Override
    public int insertAddress(Address address) {

        if (address.getAddressId() == null || StringUtils.isEmpty(address.getAddressId())) {
            address.setAddressId(UniqueKeyUtil.getUniqueKey());
        }
        if (address.getAddressName() == null || StringUtils.isEmpty(address.getAddressName())) {
            throw new MallException(MallExceptionEnum.ADDRESS_ERROR_NAMEEMPTY);
        }
        if (address.getAddressPhone() == null || StringUtils.isEmpty(address.getAddressPhone())) {
            throw new MallException(MallExceptionEnum.ADDRESS_ERROR_PHONEEMPTY);
        }
        if (address.getDetail() == null || StringUtils.isEmpty(address.getDetail())) {
            throw new MallException(MallExceptionEnum.ADDRESS_ERROR_DETAILEMPTY);
        }
        if (address.getUserId() == null || StringUtils.isEmpty(address.getUserId())) {
            throw new MallException(MallExceptionEnum.ADDRESS_ERROR_USERIDEMPTY);
        }

        User user = userMapper.selectByUserId(address.getUserId());
        if (user == null) {
            throw new MallException(MallExceptionEnum.USER_ERROR_NOEXITACCOUNT);
        }

        int result = addressMapper.insertAddress(address);
        if (result < 1) {
            throw new MallException(MallExceptionEnum.SQL_ERROR_INSERT);
        }

        return result;
    }

    @Override
    public int deleteAddress(String addressId) {

        if (addressId == null || StringUtils.isEmpty(addressId)) {
            throw new MallException(MallExceptionEnum.ADDRESS_ERROR_IDEMPTY);
        }

        Address address = addressMapper.selectAddressById(addressId);
        if (address == null) {
            throw new MallException(MallExceptionEnum.ADDRESS_ERROR_NOEXIT);
        }

        int result = addressMapper.deleteAddress(addressId);
        if (result < 1) {
            throw new MallException(MallExceptionEnum.SQL_ERROR_DELETE);
        }

        return result;
    }

    @Override
    public int updateAddress(Address address) {

        if (address.getAddressId() == null || StringUtils.isEmpty(address.getAddressId())) {
            throw new MallException(MallExceptionEnum.ADDRESS_ERROR_IDEMPTY);
        }
        if (address.getAddressName() == null || StringUtils.isEmpty(address.getAddressName())) {
            throw new MallException(MallExceptionEnum.ADDRESS_ERROR_NAMEEMPTY);
        }
        if (address.getAddressPhone() == null || StringUtils.isEmpty(address.getAddressPhone())) {
            throw new MallException(MallExceptionEnum.ADDRESS_ERROR_PHONEEMPTY);
        }
        if (address.getDetail() == null || StringUtils.isEmpty(address.getDetail())) {
            throw new MallException(MallExceptionEnum.ADDRESS_ERROR_DETAILEMPTY);
        }
        if (address.getUserId() == null || StringUtils.isEmpty(address.getUserId())) {
            throw new MallException(MallExceptionEnum.ADDRESS_ERROR_USERIDEMPTY);
        }

        Address add = addressMapper.selectAddressById(address.getAddressId());
        if (add == null) {
            throw new MallException(MallExceptionEnum.ADDRESS_ERROR_NOEXIT);
        }

        int result = addressMapper.updateAddress(address);

        return result;
    }

    @Override
    public List<Address> selectAddressByUserId(String userId) {

        if (userId == null || StringUtils.isEmpty(userId)) {
            throw new MallException(MallExceptionEnum.ADDRESS_ERROR_USERIDEMPTY);
        }

        List<Address> addresses = addressMapper.seletAddressByUserId(userId);

        return addresses;
    }
}
