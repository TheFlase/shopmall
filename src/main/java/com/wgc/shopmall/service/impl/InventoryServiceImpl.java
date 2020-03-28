package com.wgc.shopmall.service.impl;

import com.wgc.shopmall.dao.InventoryDao;
import com.wgc.shopmall.model.Inventory;
import com.wgc.shopmall.service.IInventoryService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @Author wgc
 * @Description
 * @Date 3/28/2020
 **/
@Service
public class InventoryServiceImpl implements IInventoryService {

    @Resource
    private InventoryDao inventoryDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return inventoryDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(Inventory record) {
        return inventoryDao.insert(record);
    }

    @Override
    public int insertSelective(Inventory record) {
        return inventoryDao.insertSelective(record);
    }

    @Override
    public Inventory selectByPrimaryKey(Long id) {
        return inventoryDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(Inventory record) {
        return inventoryDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(Inventory record) {
        return inventoryDao.updateByPrimaryKey(record);
    }

    @Override
    public int updateByItemCode(Inventory inventory) {
        return inventoryDao.updateByItemCode(inventory);
    }
}
