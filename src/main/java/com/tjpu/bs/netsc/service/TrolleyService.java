package com.tjpu.bs.netsc.service;

import com.tjpu.bs.netsc.entity.Trolley;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

public interface TrolleyService {
    Trolley getTrolleyByTId(int tId);

    Trolley getTrolleyByPNameAndUId(String pName,String uId);

    public List<HashMap<String,Object>> getTrolleyByUId(String uId);

    public List<HashMap<String,Object>> getTrolleyList();

    public int add(Trolley trolley);

    public int update(int tId, Trolley trolley);

    public int delete(int tId);
}
