package com.tjpu.bs.netsc.service.impl;

import com.tjpu.bs.netsc.entity.ProductPhotos;
import com.tjpu.bs.netsc.mapper.ProductPhotosMapper;
import com.tjpu.bs.netsc.service.ProductPhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class ProductPhotosServiceimpl implements ProductPhotosService{
    @Autowired
    private ProductPhotosMapper productPhotosMapper;

    @Override
    public ProductPhotos getProductPhotoByPPId(int pPId){
        return productPhotosMapper.getProductPhotoByPPId(pPId);
    }
    @Override
    public List<HashMap<String,Object>> getProductPhotoList(){
        return productPhotosMapper.getProductPhotoList();
    }
    @Override
    public List<HashMap<String,Object>> getProductPhotoByPId(int pId){
        return productPhotosMapper.getProductPhotoByPId(pId);
    }
    @Override
    public int add(ProductPhotos productPhotos){
        return productPhotosMapper.add(productPhotos);
    }
    @Override
    public int update( int pPId,ProductPhotos productPhotos){
        return productPhotosMapper.update(pPId, productPhotos);
    }
    @Override
    public int delete(int pPId){
        return productPhotosMapper.delete(pPId);
    }
}
