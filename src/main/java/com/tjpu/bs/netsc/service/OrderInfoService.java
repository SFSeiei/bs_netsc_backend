package com.tjpu.bs.netsc.service;

import com.tjpu.bs.netsc.entity.OrderInfo;

import java.util.HashMap;
import java.util.List;

public interface OrderInfoService {
    public OrderInfo getOrderInfoByOIId(int oIId);

    public List<HashMap<String,Object>> getOrderInfoByOId(int oId);

    public List<HashMap<String,Object>> getOrderInfoList();

    public int add(OrderInfo orderInfo);

    public int update(int oIId,OrderInfo orderInfo);

    public int delete(int oIId);
}
