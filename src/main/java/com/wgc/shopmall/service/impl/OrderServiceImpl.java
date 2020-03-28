package com.wgc.shopmall.service.impl;

import com.wgc.shopmall.common.utils.IdUtil;
import com.wgc.shopmall.dao.OrderDao;
import com.wgc.shopmall.model.Inventory;
import com.wgc.shopmall.model.Item;
import com.wgc.shopmall.model.order.Order;
import com.wgc.shopmall.model.order.OrderDetail;
import com.wgc.shopmall.model.order.OrderParam;
import com.wgc.shopmall.service.IInventoryService;
import com.wgc.shopmall.service.IItemService;
import com.wgc.shopmall.service.IOrderDetailService;
import com.wgc.shopmall.service.IOrderService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;
import java.util.*;

/**
 * @Author wgc
 * @Description
 * @Date 3/27/2020
 **/
@Service
public class OrderServiceImpl implements IOrderService {
    @Resource
    private OrderDao orderDao;
    @Resource
    private IOrderDetailService orderDetailService;
    @Resource
    private IItemService itemService;
    @Resource
    private IInventoryService inventoryService;

    @Override
    public int insert(Order record) {
        record.setOrderCode("MD"+ IdUtil.nextId());
        return orderDao.insert(record);
    }

    @Override
    @Transactional(transactionManager ="myTestTransactionManager")
    public void saveAndSubtractInventory(OrderParam orderParam) {
        /**
         * 1.生成订单;2.扣减库存。
         * todo 扣费并生成账单;生成库存扣减流水;记录操作日志等等
         */
        BigDecimal totalPrice = new BigDecimal(0);
        Map<String,Integer> orderItemInfoMap = new HashMap<>();
        Map<String,Item> itemMap = new HashMap<>();

        //生成订单
        List<OrderDetail> orderDetailList = orderParam.getOrderDetailList();
        HashSet<String> itemCodeSet = new HashSet<>();
        for(OrderDetail item:orderDetailList){
            itemCodeSet.add(item.getItemCode());
            orderItemInfoMap.put(item.getItemCode(),item.getItemQty());
        }
        List<Item> itemList = itemService.selectByItemCodes(itemCodeSet);
        for(Item item:itemList){
            itemMap.put(item.getItemCode(),item);
        }
        for(OrderDetail item:orderDetailList){
            Item itemTemp = itemMap.get(item.getItemCode());
            if(item.getItemQty() != 0 && itemTemp.getItemPrice() != null){
                totalPrice =totalPrice.add(new BigDecimal(item.getItemQty()).multiply(itemTemp.getItemPrice()));
            }
        }
        Order order = new Order();
        order.setTotalPrice(totalPrice);
        this.insert(order);

        for(OrderDetail item:orderDetailList){
            item.setOrderCode(order.getOrderCode());
        }
        orderDetailService.batchInsert(orderDetailList);


        //扣减库存
        for(OrderDetail item:orderDetailList){
            Inventory inventory = new Inventory();
            inventory.setItemCode(item.getItemCode());
            inventory.setStockQty(-item.getItemQty());
            inventoryService.updateByItemCode(inventory);
        }

    }

}
