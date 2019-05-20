package com.tjpu.bs.netsc.service.impl;

import com.tjpu.bs.netsc.entity.Bigcategories;
import com.tjpu.bs.netsc.mapper.BigcategoriesMapper;
import com.tjpu.bs.netsc.service.BigcategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BigcategoriesServiceimpl implements BigcategoriesService {
    @Autowired
    private BigcategoriesMapper bigcategoriesMapper;

    @Override
    public Bigcategories getBigcategoriesByBId(int bCId){
        return bigcategoriesMapper.getBigcategoriesByBId(bCId);
    }

    @Override
    public List<Bigcategories> getBigcategoriesList(){
        return bigcategoriesMapper.getBigcategoriesList();
    }

    @Override
    public int add(Bigcategories bigcategories){
        return bigcategoriesMapper.add(bigcategories);
    }

    @Override
    public int update(int bCId,Bigcategories bigcategories){
        return bigcategoriesMapper.update(bCId,bigcategories);
    }

    @Override
    public int delete(int bCId){
        return delete(bCId);
    }
}
