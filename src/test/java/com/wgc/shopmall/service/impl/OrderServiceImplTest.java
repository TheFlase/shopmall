package com.wgc.shopmall.service.impl;

import com.wgc.shopmall.model.order.OrderDetail;
import com.wgc.shopmall.model.order.OrderParam;
import com.wgc.shopmall.service.IOrderService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 3/28/2020
 **/
@SpringBootTest
class OrderServiceImplTest {
    @Resource
    private IOrderService orderService;

    @Test
    void saveAndSubtractInventory() {
        OrderParam orderParam = new OrderParam();
        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setItemCode("IT000001");
        orderDetail.setItemQty(1);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        orderDetailList.add(orderDetail);
        orderParam.setOrderDetailList(orderDetailList);
        orderService.saveAndSubtractInventory(orderParam);
    }
}