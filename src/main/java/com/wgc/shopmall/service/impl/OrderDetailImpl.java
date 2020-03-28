package com.wgc.shopmall.service.impl;

import com.wgc.shopmall.dao.OrderDetailDao;
import com.wgc.shopmall.model.order.OrderDetail;
import com.wgc.shopmall.service.IOrderDetailService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @Author wgc
 * @Description
 * @Date 3/28/2020
 **/
@Service
public class OrderDetailImpl implements IOrderDetailService {
    @Resource
    private OrderDetailDao orderDetailDao;

    @Override
    public int deleteByPrimaryKey(Long id) {
        return orderDetailDao.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(OrderDetail record) {
        return orderDetailDao.insert(record);
    }

    @Override
    public int insertSelective(OrderDetail record) {
        return orderDetailDao.insertSelective(record);
    }

    @Override
    public OrderDetail selectByPrimaryKey(Long id) {
        return orderDetailDao.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(OrderDetail record) {
        return orderDetailDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(OrderDetail record) {
        return orderDetailDao.updateByPrimaryKey(record);
    }

    @Override
    public int batchInsert(List<OrderDetail> orderDetailList) {
        return orderDetailDao.batchInsert(orderDetailList);
    }
}
