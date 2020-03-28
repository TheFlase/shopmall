package com.wgc.shopmall.dao;

import com.wgc.shopmall.model.Inventory;

public interface InventoryDao {
    int deleteByPrimaryKey(Long id);

    int insert(Inventory record);

    int insertSelective(Inventory record);

    Inventory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Inventory record);

    int updateByPrimaryKey(Inventory record);

    int updateByItemCode(Inventory inventory);
}