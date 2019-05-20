package com.tjpu.bs.netsc.service;

import com.tjpu.bs.netsc.entity.Bigcategories;

import java.util.List;

public interface BigcategoriesService {

    Bigcategories getBigcategoriesByBId(int bCId);
    public List<Bigcategories> getBigcategoriesList();


    public int add(Bigcategories bigcategories);

    public int update(int bCId,Bigcategories bigcategories);

    public int delete(int bCId);
}
