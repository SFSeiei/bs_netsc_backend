package com.tjpu.bs.netsc.service;

import com.tjpu.bs.netsc.entity.Shop;

import java.util.HashMap;
import java.util.List;

public interface ShopService {
    //SELECT
    public List<HashMap<String,Object>> getShopByUId(String uId);

    public Shop getShopBySId(int sId);

    //INSERT
    public int add(Shop shop);

    //UPDATE
    public int update(int sId, Shop shop);

    //DELETE
    public int delete(int sId);
}
