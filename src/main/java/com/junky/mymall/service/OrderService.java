package com.junky.mymall.service;

import com.junky.mymall.entity.Order;

import java.util.List;

/**
 * Class OrderService
 * Effect
 * Created by junky
 * on 2018/7/20
 */
public interface OrderService {


    Order insertOrder(Order order);


    Order deleteOrderByOrderId(String orderId);


    Order updataOrder(Order order);


    Order selectOrderByOrderId(String orderId);


    List<Order> selectOrderByUserId(String userId, Integer pageNo, Integer pageSize);


    List<Order> selectOrderBySellerId(String sellerId, Integer pageNo, Integer pageSize);


}
