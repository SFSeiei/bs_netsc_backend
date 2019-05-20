package com.tjpu.bs.netsc.service.impl;

import com.tjpu.bs.netsc.entity.Order;
import com.tjpu.bs.netsc.mapper.OrderMapper;
import com.tjpu.bs.netsc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class OrderServiceimpl implements OrderService {
    @Autowired
    private OrderMapper orderMapper;

    public Order getOrderByOId(int oId){
        return orderMapper.getOrderByOId(oId);
    }

    public List<HashMap<String,Object>> getOrderBySId(int sId){
        return orderMapper.getOrderBySId(sId);
    }

    public List<HashMap<String,Object>> getOrderByUId(String uId){
        return orderMapper.getOrderByUId(uId);
    }

    public List<HashMap<String,Object>> getOrderList(){
        return orderMapper.getOrderList();
    }

    public int add(Order order){
        return orderMapper.add(order);
    }

    public int update(int oId,Order order){
        return orderMapper.update(oId,order);
    }

    public int delete(int oId){
        return orderMapper.delete(oId);
    }
}
