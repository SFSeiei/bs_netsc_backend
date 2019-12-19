package com.tjpu.bs.netsc.service.impl;

import com.tjpu.bs.netsc.entity.Trolley;
import com.tjpu.bs.netsc.mapper.TrolleyMapper;
import com.tjpu.bs.netsc.service.TrolleyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class TrolleyServiceimpl implements TrolleyService {
    @Autowired
    private TrolleyMapper trolleyMapper;

    @Override
    public Trolley getTrolleyByTId(int tId){
        return trolleyMapper.getTrolleyByTId(tId);
    }

    @Override
    public Trolley getTrolleyByPNameAndUId(String pName,String uId){
        return trolleyMapper.getTrolleyByPNameAndUId(pName,uId);
    }
    @Override
    public Trolley getTrolleyByPIdAndUId(int pId,String uId){
        return trolleyMapper.getTrolleyByPIdAndUId(pId,uId);
    }
    @Override
    public List<HashMap<String,Object>> getTrolleyByUId(String uId){
        return trolleyMapper.getTrolleyByUId(uId);
    }

    @Override
    public List<HashMap<String,Object>> getTrolleyList(){
        return trolleyMapper.getTrolleyList();
    }

    @Override
    public int add(Trolley trolley){
        return trolleyMapper.add(trolley);
    }

    @Override
    public int update(int tId, Trolley trolley){
        return trolleyMapper.update(tId,trolley);
    }

    @Override
    public int delete(int tId){
        return trolleyMapper.delete(tId);
    }

    @Override
    public int deleteByPId(int pId){
        return trolleyMapper.deleteByPId(pId);
    }
}
