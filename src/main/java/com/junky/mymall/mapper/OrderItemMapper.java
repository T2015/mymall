package com.junky.mymall.mapper;

import com.junky.mymall.entity.Order;
import com.junky.mymall.entity.OrderItem;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Class OrderItemMapper
 * Effect
 * Created by junky
 * on 2018/7/13
 */
public interface OrderItemMapper {


    @Insert("insert into order_item(item_id,product_id,product_quility,item_sum,order_id) " +
            "value(#{itemId},#{productId},#{productQuility},#{itemSum},#{orderId})")
    int insertItem(OrderItem item);


    @Delete("delete from order_item where item_id=#{itemId}")
    int deleteItemByItemId(String itemId);

    @Delete("delete from order_item where order_id=#{orderId}")
    int deleteItemByOrderId(String orderId);


    @Update("update order_item set product_id=#{productId},product_quility=#{productQuility}," +
            "item_sum=#{itemSum},order_id=#{orderId} where item_id=#{itemId}")
    int updateItem(OrderItem item);


    @Select("select * from order_item where order_id=#{orderId}")
    @Results({
            @Result(column = "item_id", property = "itemId"),
            @Result(column = "product_id", property = "productId"),
            @Result(column = "product_quility", property = "productQuility"),
            @Result(column = "item_sum", property = "itemSum"),
            @Result(column = "order_id", property = "orderId")
    })
    List<OrderItem> selectItemByOrderId(String orderId);


    @Select("select * from order_item where item_id=#{itemId}")
    @Results({
            @Result(column = "item_id", property = "itemId"),
            @Result(column = "product_id", property = "productId"),
            @Result(column = "product_quility", property = "productQuility"),
            @Result(column = "item_sum", property = "itemSum"),
            @Result(column = "order_id", property = "orderId")
    })
    OrderItem selectItemByID(String itemId);


}
