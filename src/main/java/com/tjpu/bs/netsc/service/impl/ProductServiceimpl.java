package com.tjpu.bs.netsc.service.impl;

import com.tjpu.bs.netsc.entity.Product;
import com.tjpu.bs.netsc.mapper.ProductMapper;
import com.tjpu.bs.netsc.service.ProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProductServiceimpl implements ProductService {
    @Autowired
    private ProductMapper productMapper;

    //SELECT
    @Override
    public List<HashMap<String,Object>> getProductBySId(int sId){
        return productMapper.getProductBySId(sId);
    }

    @Override
    public Product getProductByPId(int pId){
        return productMapper.getProductByPId(pId);
    }

    @Override
    public List<HashMap<String,Object>> getProductByPName(String pName){
        return productMapper.getProductByPName(pName);
    }
    @Override
    public List<HashMap<String,Object>> getProductByBCName(String bCName){
        return productMapper.getProductByBCName(bCName);
    }
    @Override
    public List<HashMap<String,Object>> getProducts(){
        return productMapper.getProducts();
    }

    //INSERT
    @Override
    public int add(Product product){
        return productMapper.add(product);
    }

    //UPDATE
    @Override
    public int update(int pId,Product product){
        return productMapper.update(pId,product);
    }

    //DELETE
    public int delete(int pId){
        return productMapper.delete(pId);
    }
}
