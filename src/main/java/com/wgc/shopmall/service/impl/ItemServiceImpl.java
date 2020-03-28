package com.wgc.shopmall.service.impl;

import com.wgc.shopmall.dao.ItemDao;
import com.wgc.shopmall.model.Item;
import com.wgc.shopmall.service.IItemService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Set;

/**
 * @Author wgc
 * @Description
 * @Date 3/27/2020
 **/
@Service
public class ItemServiceImpl implements IItemService {
    @Resource
    private ItemDao itemDao;
    @Override
    public int insert(Item record) {
        return itemDao.insert(record);
    }

    @Override
    public List<Item> selectByItemCodes(Set<String> itemCodes) {
        return itemDao.selectByItemCodes(itemCodes);
    }
}
