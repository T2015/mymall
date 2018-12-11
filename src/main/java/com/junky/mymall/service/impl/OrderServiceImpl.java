package com.junky.mymall.service.impl;

import com.junky.mymall.entity.Order;
import com.junky.mymall.entity.Seller;
import com.junky.mymall.entity.User;
import com.junky.mymall.mapper.OrderMapper;
import com.junky.mymall.mapper.SellerMapper;
import com.junky.mymall.mapper.UserMapper;
import com.junky.mymall.service.OrderService;
import com.junky.mymall.utils.UniqueKeyUtil;
import com.junky.mymall.utils.exception.MallException;
import com.junky.mymall.utils.exception.MallExceptionEnum;
import com.sun.tools.corba.se.idl.constExpr.Or;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Class OrderServiceImpl
 * Effect
 * Created by junky
 * on 2018/7/23
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    SellerMapper sellerMapper;

    @Autowired
    UserMapper userMapper;


    @Override
    public Order insertOrder(Order order) {

        if (order.getOrderId() == null || StringUtils.isEmpty(order.getOrderId())) {
            order.setOrderId(UniqueKeyUtil.getUniqueKey());
        }
        if (order.getBuyerId() == null || StringUtils.isEmpty(order.getBuyerId())) {
            throw new MallException(MallExceptionEnum.ORDER_ERROR_BUYERIDEMPTY);
        }
        if (order.getSellerId() == null || StringUtils.isEmpty(order.getSellerId())) {
            throw new MallException(MallExceptionEnum.ORDER_ERROR_SELLERIDEMPTY);
        }
        if (order.getOrderStatus() != 0) {
            throw new MallException(MallExceptionEnum.ORDER_ERROR_STATUSEMPTY);
        }
        if (order.getOrderSum() <= 0) {
            throw new MallException(MallExceptionEnum.ORDER_ERROR_SUMEMPTY);
        }
        if (order.getOrderAddress() == null || StringUtils.isEmpty(order.getOrderAddress())) {
            throw new MallException(MallExceptionEnum.ORDER_ERROR_ADDRESSEMPTY);
        }

        Seller seller = sellerMapper.selectSellerById(order.getSellerId());
        if (seller == null) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_NOEXITACCOUNT);
        }

        User user = userMapper.selectByUserId(order.getBuyerId());
        if (user == null) {
            throw new MallException(MallExceptionEnum.USER_ERROR_NOEXITACCOUNT);
        }

        int result = orderMapper.insertOrder(order);
        if (result < 1) {
            throw new MallException(MallExceptionEnum.SQL_ERROR_INSERT);
        }

        return order;
    }

    @Override
    public Order deleteOrderByOrderId(String orderId) {

        if (orderId == null || StringUtils.isEmpty(orderId)) {
            throw new MallException(MallExceptionEnum.ORDER_ERROR_IDEMPTY);
        }

        Order order = orderMapper.selectOrderByOrderId(orderId);
        if (order == null) {
            throw new MallException(MallExceptionEnum.ORDER_ERROR_NOEXIT);
        }

        int result = orderMapper.deleteOrderByOrderId(orderId);
        if (result < 1) {
            throw new MallException(MallExceptionEnum.SQL_ERROR_DELETE);
        }

        return order;
    }

    @Override
    public Order updataOrder(Order order) {

        if (order.getOrderId() == null || StringUtils.isEmpty(order.getOrderId())) {
            throw new MallException(MallExceptionEnum.ORDER_ERROR_IDEMPTY);
        }
        if (order.getBuyerId() == null || StringUtils.isEmpty(order.getBuyerId())) {
            throw new MallException(MallExceptionEnum.ORDER_ERROR_BUYERIDEMPTY);
        }
        if (order.getSellerId() == null || StringUtils.isEmpty(order.getSellerId())) {
            throw new MallException(MallExceptionEnum.ORDER_ERROR_SELLERIDEMPTY);
        }
        if (order.getOrderStatus() != 0) {
            throw new MallException(MallExceptionEnum.ORDER_ERROR_STATUSEMPTY);
        }
        if (order.getOrderSum() <= 0) {
            throw new MallException(MallExceptionEnum.ORDER_ERROR_SUMEMPTY);
        }
        if (order.getOrderAddress() == null || StringUtils.isEmpty(order.getOrderAddress())) {
            throw new MallException(MallExceptionEnum.ORDER_ERROR_ADDRESSEMPTY);
        }

        Order order1 = orderMapper.selectOrderByOrderId(order.getOrderId());
        if (order1 == null) {
            throw new MallException(MallExceptionEnum.ORDERITEM_ERROR_NOEXIT);
        }

        int result = orderMapper.updateOrder(order);

        return order;
    }

    @Override
    public Order selectOrderByOrderId(String orderId) {

        if (orderId == null || StringUtils.isEmpty(orderId)) {
            throw new MallException(MallExceptionEnum.ORDER_ERROR_IDEMPTY);
        }

        Order result = orderMapper.selectOrderByOrderId(orderId);

        return result;
    }

    @Override
    public List<Order> selectOrderByUserId(String userId, Integer pageNo, Integer pageSize) {

        if (userId == null || StringUtils.isEmpty(userId)) {
            throw new MallException(MallExceptionEnum.USER_ERROR_USERIDEMPTY);
        }
        if (pageNo < 0) {
            throw new MallException(MallExceptionEnum.PARAM_ERROR_PAGENO);
        }
        if (pageSize < 1) {
            throw new MallException(MallExceptionEnum.PARAM_ERROR_PAGESIZE);
        }

        List<Order> orders = orderMapper.orderListByBuyerId(userId, pageNo, pageSize);

        return orders;
    }

    @Override
    public List<Order> selectOrderBySellerId(String sellerId, Integer pageNo, Integer pageSize) {

        if (sellerId == null || StringUtils.isEmpty(sellerId)) {
            throw new MallException(MallExceptionEnum.SELLER_ERROR_IDEMPTY);
        }
        if (pageNo < 0) {
            throw new MallException(MallExceptionEnum.PARAM_ERROR_PAGENO);
        }
        if (pageSize < 1) {
            throw new MallException(MallExceptionEnum.PARAM_ERROR_PAGESIZE);
        }

        List<Order> orders = orderMapper.orderListBySellerId(sellerId, pageNo, pageSize);

        return orders;
    }


}
