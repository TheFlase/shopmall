package com.wgc.shopmall.service;

import com.wgc.shopmall.model.Inventory;

/**
 * @Author wgc
 * @Description //TODO
 * @Date 3/27/2020
 **/
public interface IInventoryService {
    int deleteByPrimaryKey(Long id);

    int insert(Inventory record);

    int insertSelective(Inventory record);

    Inventory selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Inventory record);

    int updateByPrimaryKey(Inventory record);

    int updateByItemCode(Inventory inventory);
}
