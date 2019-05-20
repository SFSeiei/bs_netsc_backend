package com.tjpu.bs.netsc.service.impl;

import com.tjpu.bs.netsc.entity.Shop;
import com.tjpu.bs.netsc.mapper.ShopMapper;
import com.tjpu.bs.netsc.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ShopServiceimpl implements ShopService {
    @Autowired
    private ShopMapper shopMapper;

    //SELECT
    public List<HashMap<String,Object>> getShopByUId(String uId){
        return shopMapper.getShopByUId(uId);
    }

    public Shop getShopBySId(int sId){
        return shopMapper.getShopBySId(sId);
    }

    //INSERT
    public int add(Shop shop){
        return shopMapper.add(shop);
    }

    //UPDATE
    public int update(int sId, Shop shop){
        return shopMapper.update(sId,shop);
    }

    //DELETE
    public int delete(int sId){
        return shopMapper.delete(sId);
    }
}
