package com.tjpu.bs.netsc.service.impl;

import com.tjpu.bs.netsc.entity.OrderInfo;
import com.tjpu.bs.netsc.mapper.OrderInfoMapper;
import com.tjpu.bs.netsc.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class OrderInfoServiceimpl implements OrderInfoService{
    @Autowired
    private OrderInfoMapper orderInfoMapper;

    @Override
    public OrderInfo getOrderInfoByOIId(int oIId){
        return orderInfoMapper.getOrderInfoByOIId(oIId);
    }

    @Override
    public List<HashMap<String,Object>> getOrderInfoByOId(int oId){
        return orderInfoMapper.getOrderInfoByOId(oId);
    }

    @Override
    public List<HashMap<String,Object>> getOrderInfoList(){
        return orderInfoMapper.getOrderInfoList();
    }

    @Override
    public int add(OrderInfo orderInfo){
        return orderInfoMapper.add(orderInfo);
    }

    @Override
    public int update(int oIId,OrderInfo orderInfo){
        return orderInfoMapper.update(oIId,orderInfo);
    }

    @Override
    public int delete(int oIId){
        return orderInfoMapper.delete(oIId);
    }

    @Override
    public int deleteByOrderId(int orderId){
        return orderInfoMapper.deleteByOrderId(orderId);
    }
}
