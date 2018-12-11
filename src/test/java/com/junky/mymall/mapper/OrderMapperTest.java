package com.junky.mymall.mapper;

import com.junky.mymall.entity.Order;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Class OrderMapperTest
 * Effect
 * Created by junky
 * on 2018/7/25
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class OrderMapperTest {

    @Autowired
    OrderMapper mapper;

    @Test
    public void insertOrder() {
        Order order = new Order();
        order.setOrderId("123456");
        order.setBuyerId("234567");
        order.setSellerId("345678");
        order.setOrderAddress("银星科技");
        order.setOrderStatus(1);
        order.setOrderSum(100.20);

        int result = mapper.insertOrder(order);
        System.out.println(result);
    }
}