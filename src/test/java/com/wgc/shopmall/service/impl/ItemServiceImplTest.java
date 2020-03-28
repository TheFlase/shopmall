package com.wgc.shopmall.service.impl;

import com.wgc.shopmall.model.Item;
import com.wgc.shopmall.service.IItemService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;

import java.math.BigDecimal;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @Author wgc
 * @Description
 * @Date 3/27/2020
 **/
@SpringBootTest
class ItemServiceImplTest {
    @Resource
    private IItemService itemservice;

    @Test
    void insert() {
        Item item = new Item();
        item.setItemCode("IT000001");
        item.setItemName("苹果手机6S");
        item.setItemPrice(new BigDecimal(2400));
        int i = itemservice.insert(item);
        System.out.println("i==="+i);
    }

    @Test
    void selectByItemCodes() {
        Set<String> itemSets = new HashSet<>();
        itemSets.add("IT000001");
        List<Item> itemList = itemservice.selectByItemCodes(itemSets);
        System.out.println(itemList.toString());
    }
}