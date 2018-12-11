package com.junky.mymall.service;

import com.junky.mymall.entity.Order;
import com.junky.mymall.entity.OrderItem;

import java.util.List;

/**
 * Class OrderItemService
 * Effect
 * Created by junky
 * on 2018/7/20
 */
public interface OrderItemService {

    int insertOrderItem(OrderItem item);


    int deleteOrderItem(String itemId);


    int deleteOrderItemByOrderId(String orderId);


    int updateOrderItem(OrderItem item);


    OrderItem selectItemById(String itemId);


    List<OrderItem> selectItemByOrderId(String orderId);
}
