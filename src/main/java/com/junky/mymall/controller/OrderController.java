package com.junky.mymall.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.junky.mymall.entity.Order;
import com.junky.mymall.entity.OrderItem;
import com.junky.mymall.service.OrderItemService;
import com.junky.mymall.service.OrderService;
import com.junky.mymall.utils.ResultUtil;
import com.junky.mymall.utils.exception.MallException;
import com.junky.mymall.utils.exception.MallExceptionEnum;
import com.junky.mymall.vo.response.ResultVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

/**
 * Class OrderController
 * Effect
 * Created by junky
 * on 2018/7/24
 */
@RestController
@RequestMapping("/order")
public class OrderController {


    @Autowired
    OrderService orderService;

    @Autowired
    OrderItemService orderItemService;

    @Transactional
    @RequestMapping("/insert.do")
    public ResultVO insertOrder(@RequestParam("json") String json) {

        // 参数验证
        if (json == null || StringUtils.isEmpty(json)) {
            throw new MallException(MallExceptionEnum.PARAM_ERROR_PARAM);
        }

        // json转对象
        JSONObject object = JSONObject.parseObject(json);
        Order order = JSONObject.toJavaObject(object, Order.class);
        List<OrderItem> items = JSONObject.parseArray(object.getString("itemList"), OrderItem.class);


        // 插入订单
        Order result = orderService.insertOrder(order);

        // 插入订单项
        for (OrderItem it : items) {
            it.setOrderId(result.getOrderId());
            int result1 = orderItemService.insertOrderItem(it);
        }


        return ResultUtil.success(order);
    }


    @Transactional
    @RequestMapping("/delete.do")
    public ResultVO deleteOrder(@RequestParam("orderId") String orderId) {

        int result = orderItemService.deleteOrderItemByOrderId(orderId);

        Order result1 = orderService.deleteOrderByOrderId(orderId);

        return ResultUtil.success(result1);
    }


    @Transactional
    @RequestMapping("/update.do")
    public ResultVO updateOrder(@RequestParam("json") String json) {

        // 参数验证
        if (json == null || StringUtils.isEmpty(json)) {
            throw new MallException(MallExceptionEnum.PARAM_ERROR_PARAM);
        }

        // json转对象
        JSONObject object = JSONObject.parseObject(json);
        Order order = JSONObject.toJavaObject(object, Order.class);
        List<OrderItem> items = JSONObject.parseArray(object.getString("itemList"), OrderItem.class);


        Order result = orderService.updataOrder(order);

        int result1 = orderItemService.deleteOrderItemByOrderId(order.getOrderId());

        for (OrderItem it : items) {
            it.setOrderId(order.getOrderId());
            int result2 = orderItemService.insertOrderItem(it);
        }
        return ResultUtil.success(order);
    }


    @RequestMapping("/selectByUser.do")
    public ResultVO selectByUser(@RequestParam("userId") String userId,
                                 @RequestParam("pageNo") Integer pageNo,
                                 @RequestParam("pageSize") Integer pageSize) {

        if (userId == null || StringUtils.isEmpty(userId)) {
            throw new MallException(MallExceptionEnum.ORDER_ERROR_BUYERIDEMPTY);
        }

        List<Order> orderList = orderService.selectOrderByUserId(userId, pageNo, pageSize);
        return ResultUtil.success(orderList);
    }


    @RequestMapping("/selectBySeller.do")
    public ResultVO selectBySeller(@RequestParam("sellerId") String sellerId,
                                   @RequestParam("pageNo") Integer pageNo,
                                   @RequestParam("pageSize") Integer pageSize) {

        if (sellerId == null || StringUtils.isEmpty(sellerId)) {
            throw new MallException(MallExceptionEnum.ORDER_ERROR_BUYERIDEMPTY);
        }

        List<Order> orderList = orderService.selectOrderBySellerId(sellerId, pageNo, pageSize);
        return ResultUtil.success(orderList);
    }


    @RequestMapping("/select.do")
    public ResultVO selectByOrderId(@RequestParam("orderId") String orderId) {

        if (orderId == null || StringUtils.isEmpty(orderId)) {
            throw new MallException(MallExceptionEnum.ORDER_ERROR_IDEMPTY);
        }

        Order order = orderService.selectOrderByOrderId(orderId);
        return ResultUtil.success(order);
    }

}
