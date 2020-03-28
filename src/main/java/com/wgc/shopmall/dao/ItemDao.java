package com.wgc.shopmall.dao;

import com.wgc.shopmall.model.Item;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Set;

public interface ItemDao {

    int deleteByPrimaryKey(Long id);

    int insert(Item record);

    int insertSelective(Item record);

    Item selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Item record);

    int updateByPrimaryKey(Item record);

    List<Item> selectByItemCodes(@Param("itemCodes") Set<String> itemCodes);
}