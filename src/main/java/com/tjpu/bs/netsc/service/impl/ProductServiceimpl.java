package com.tjpu.bs.netsc.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.tjpu.bs.netsc.entity.Product;
import com.tjpu.bs.netsc.mapper.ProductMapper;
import com.tjpu.bs.netsc.pojo.PageResult;
import com.tjpu.bs.netsc.service.ProductService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
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
    @Override
    public PageResult getProductsPage(int pageNum, int pageSize){
        PageHelper.startPage(pageNum, pageSize);
        List<HashMap<String,Object>> list = productMapper.getProducts();
        Page page = (Page) list;
//        HashMap<String,Object> test = new HashMap<>();
//        test.put("Result:",page.getResult());
//        test.put("Total:",page.getTotal());
//        test.put("CountColumn:",page.getCountColumn());
//        test.put("EndRow:",page.getEndRow());
//        test.put("OrderBy:",page.getOrderBy());
//        test.put("Pages:",page.getPages());
//        test.put("PageSize:",page.getPageSize());
//        test.put("PageSizeZero:",page.getPageSizeZero());
//        test.put("Reasonable:",page.getReasonable());
//        test.put("StartRow:",page.getStartRow());
//        List<HashMap<String,Object>> test1 = new ArrayList<HashMap<String,Object>>();
//        test1.add(test);
        return new PageResult(page.getTotal(), page.getPageSize(),page.getPages(),pageNum,page.getResult());
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
