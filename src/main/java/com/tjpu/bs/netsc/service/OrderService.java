package com.tjpu.bs.netsc.service;

import com.tjpu.bs.netsc.entity.Order;

import java.util.HashMap;
import java.util.List;

public interface OrderService {
    public Order getOrderByOId(int oId);

    public List<HashMap<String,Object>> getOrderBySId(int sId);

    public List<HashMap<String,Object>> getOrderByUId(String uId);

    public List<HashMap<String,Object>> getOrderList();

    public int add(Order order);

    public int update(int oId,Order order);

    public int delete(int oId);
}
