package com.tjpu.bs.netsc.service;

import com.tjpu.bs.netsc.entity.Product;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

public interface ProductService {
    //SELECT
    public List<HashMap<String,Object>> getProductBySId(int sId);
    public Product getProductByPId(int pId);
    public List<HashMap<String,Object>> getProductByPName(String pName);
    public List<HashMap<String,Object>> getProducts();
    public List<HashMap<String,Object>> getProductByBCName(@Param("bCName") String bCName);

    //INSERT
    public int add(Product product);

    //UPDATE
    public int update(int pId,Product product);

    //DELETE
    public int delete(int pId);
}
