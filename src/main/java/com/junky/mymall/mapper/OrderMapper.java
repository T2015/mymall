package com.junky.mymall.mapper;

import com.junky.mymall.entity.Order;
import com.junky.mymall.entity.Seller;
import com.junky.mymall.entity.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * Class OrderMapper
 * Effect
 * Created by junky
 * on 2018/7/13
 */
public interface OrderMapper {


    @Insert("insert into tb_order(order_id,order_status,buyer_id,seller_id,order_sum,order_address) value(#{orderId},#{orderStatus},#{buyerId},#{sellerId},#{orderSum},#{orderAddress})")
    int insertOrder(Order order);


    @Delete("delete from tb_order where order_id=#{orderId}")
    int deleteOrderByOrderId(String orderId);


    @Delete("delete from tb_order where seller_id=#{sellerId}")
    int deleteOrderBySellerId(String sellerId);


    @Delete("delete from tb_order where buyer_id=#{UserId}")
    int deleteOrderByUserId(String UserId);


    @Update("update tb_order set order_status=#{orderStatus},buyer_id=#{buyerId}," +
            "seller_id=#{sellerId},order_sum=#{orderSum},order_address=#{orderAddress} " +
            "where order_id=#{orderId}")
    int updateOrder(Order order);


    @Select("select * from tb_order where order_id=#{orderId}")
    @Results({
            @Result(column = "order_id", property = "orderId"),
            @Result(column = "order_status", property = "orderStatus"),
            @Result(column = "buyer_id", property = "buyerId"),
            @Result(column = "seller_id", property = "sellerId"),
            @Result(column = "order_sum", property = "orderSum"),
            @Result(column = "order_address", property = "orderAddress")
    })
    Order selectOrderByOrderId(String orderId);


    @Select("select * from tb_order where buyer_id=#{userId} limit #{pageNo},#{pageSize}")
    @Results({
            @Result(column = "order_id", property = "orderId"),
            @Result(column = "order_status", property = "orderStatus"),
            @Result(column = "buyer_id", property = "buyerId"),
            @Result(column = "seller_id", property = "sellerId"),
            @Result(column = "order_sum", property = "orderSum"),
            @Result(column = "order_address", property = "orderAddress")
    })
    List<Order> orderListByBuyerId(@Param("userId") String userId,
                                   @Param("pageNo") int pageNo,
                                   @Param("pageSize") int pageSize);


    @Select("select * from tb_order where seller_id=#{sellerId} limit #{pageNo},#{pageSize}")
    @Results({
            @Result(column = "order_id", property = "orderId"),
            @Result(column = "order_status", property = "orderStatus"),
            @Result(column = "buyer_id", property = "buyerId"),
            @Result(column = "seller_id", property = "sellerId"),
            @Result(column = "order_sum", property = "orderSum"),
            @Result(column = "order_address", property = "orderAddress")
    })
    List<Order> orderListBySellerId(@Param("sellerId") String sellerId,
                                    @Param("pageNo") int pageNo,
                                    @Param("pageSize") int pageSize);

}
