package com.wgc.shopmall.service;

import com.wgc.shopmall.model.order.Order;
import com.wgc.shopmall.model.order.OrderParam;

/**
 * @Author wgc
 * @Description
 * @Date 3/27/2020
 **/

public interface IOrderService {
    int insert(Order record);

    /**
     * 生成订单并且扣减库存
     * @param orderParam
     */
    void saveAndSubtractInventory(OrderParam orderParam);
}
