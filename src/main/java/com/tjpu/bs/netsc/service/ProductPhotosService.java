package com.tjpu.bs.netsc.service;

import com.tjpu.bs.netsc.entity.ProductPhotos;

import java.util.HashMap;
import java.util.List;

public interface ProductPhotosService {
    ProductPhotos getProductPhotoByPPId(int pPId);

    public List<HashMap<String,Object>> getProductPhotoList();

    public List<HashMap<String,Object>> getProductPhotoByPId(int pId);

    public int add(ProductPhotos productPhotos);

    public int update( int pPId,ProductPhotos productPhotos);

    public int delete(int pPId);
}
