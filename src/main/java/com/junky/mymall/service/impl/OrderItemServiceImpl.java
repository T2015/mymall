package com.junky.mymall.service.impl;

import com.junky.mymall.entity.Order;
import com.junky.mymall.entity.OrderItem;
import com.junky.mymall.mapper.OrderItemMapper;
import com.junky.mymall.mapper.OrderMapper;
import com.junky.mymall.service.OrderItemService;
import com.junky.mymall.utils.UniqueKeyUtil;
import com.junky.mymall.utils.exception.MallException;
import com.junky.mymall.utils.exception.MallExceptionEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * Class OrderItemServiceImpl
 * Effect
 * Created by junky
 * on 2018/7/20
 */
@Service
public class OrderItemServiceImpl implements OrderItemService {


    @Autowired
    OrderItemMapper mapper;


    @Override
    public int insertOrderItem(OrderItem item) {

        // 验证参数
        if (item.getItemId() == null || StringUtils.isEmpty(item.getItemId())) {
            item.setItemId(UniqueKeyUtil.getUniqueKey());
        }
        if (item.getProductId() == null || StringUtils.isEmpty(item.getProductId())) {
            throw new MallException(MallExceptionEnum.ORDERITEM_ERROR_PRODUCTID);
        }
        if (item.getProductQuility() <= 0) {
            throw new MallException(MallExceptionEnum.ORDERITEM_ERROR_PRODUCTQUILITY);
        }
        if (item.getItemSum() <= 0) {
            throw new MallException(MallExceptionEnum.ORDERITEM_ERROR_SUM);
        }
        if (item.getOrderId() == null || StringUtils.isEmpty(item.getOrderId())) {
            throw new MallException(MallExceptionEnum.ORDERITEM_ERROR_ORDERID);
        }

        // 验证是否重复插入
        OrderItem item1 = mapper.selectItemByID(item.getItemId());

        if (item1 != null) {
            throw new MallException(MallExceptionEnum.ORDERITEM_ERROR_EXIT);
        }

        // 插入
        int result = mapper.insertItem(item);
        if (result <= 0) {
            throw new MallException(MallExceptionEnum.SQL_ERROR_INSERT);
        }


        return result;
    }

    @Override
    public int deleteOrderItem(String itemId) {

        // 验证参数
        if (itemId == null || StringUtils.isEmpty(itemId)) {
            throw new MallException(MallExceptionEnum.ORDERITEM_ERROR_ID);
        }

        // 验证是否存在
        OrderItem item = mapper.selectItemByID(itemId);
        if (item == null) {
            throw new MallException(MallExceptionEnum.ORDERITEM_ERROR_NOEXIT);
        }

        // 删除
        int result = mapper.deleteItemByItemId(itemId);
        if (result <= 0) {
            throw new MallException(MallExceptionEnum.SQL_ERROR_DELETE);
        }
        return result;
    }

    @Override
    public int deleteOrderItemByOrderId(String orderId) {

        if (orderId == null || StringUtils.isEmpty(orderId)) {
            throw new MallException(MallExceptionEnum.ORDERITEM_ERROR_ORDERID);
        }

        int result = mapper.deleteItemByOrderId(orderId);

        if (result < 1) {
            throw new MallException(MallExceptionEnum.SQL_ERROR_DELETE);
        }
        return result;
    }

    @Override
    public int updateOrderItem(OrderItem item) {

        // 验证参数
        if (item.getItemId() == null || StringUtils.isEmpty(item.getItemId())) {
            throw new MallException(MallExceptionEnum.ORDERITEM_ERROR_ID);
        }
        if (item.getProductId() == null || StringUtils.isEmpty(item.getProductId())) {
            throw new MallException(MallExceptionEnum.ORDERITEM_ERROR_PRODUCTID);
        }
        if (item.getProductQuility() <= 0) {
            throw new MallException(MallExceptionEnum.ORDERITEM_ERROR_PRODUCTQUILITY);
        }
        if (item.getItemSum() <= 0) {
            throw new MallException(MallExceptionEnum.ORDERITEM_ERROR_SUM);
        }
        if (item.getOrderId() == null || StringUtils.isEmpty(item.getOrderId())) {
            throw new MallException(MallExceptionEnum.ORDERITEM_ERROR_ORDERID);
        }

        // 是否存在
        OrderItem item1 = mapper.selectItemByID(item.getItemId());
        if (item1 == null) {
            throw new MallException(MallExceptionEnum.ORDERITEM_ERROR_NOEXIT);
        }

        // 更新
        int result = mapper.updateItem(item);
        if (result <= 0) {
            throw new MallException(MallExceptionEnum.SQL_ERROR_UPDATE);
        }

        return result;
    }

    @Override
    public OrderItem selectItemById(String itemId) {

        // 验证参数
        if (itemId == null || StringUtils.isEmpty(itemId)) {
            throw new MallException(MallExceptionEnum.ORDERITEM_ERROR_ID);
        }

        // 查找
        OrderItem item = mapper.selectItemByID(itemId);
        return item;
    }

    @Override
    public List<OrderItem> selectItemByOrderId(String orderId) {

        // 验证参数
        if (orderId == null || StringUtils.isEmpty(orderId)) {
            throw new MallException(MallExceptionEnum.ORDERITEM_ERROR_ORDERID);
        }

        // 查找
        List<OrderItem> items = mapper.selectItemByOrderId(orderId);

        return items;
    }
}
