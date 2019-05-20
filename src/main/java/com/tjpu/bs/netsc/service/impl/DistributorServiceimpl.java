package com.tjpu.bs.netsc.service.impl;

import com.tjpu.bs.netsc.entity.Distributor;
import com.tjpu.bs.netsc.mapper.DistributorMapper;
import com.tjpu.bs.netsc.service.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class DistributorServiceimpl implements DistributorService {
    @Autowired
    private DistributorMapper distributorMapper;
    @Override
    public Distributor getDistributorByDId(int dId){
        return distributorMapper.getDistributorByDId(dId);
    }

    @Override
    public List<HashMap<String,Object>> getDistributorList(){
        return distributorMapper.getDistributorList();
    }

    @Override
    public List<HashMap<String,Object>> getDistributorBySIdAndDState(int sId,String dState){
        return distributorMapper.getDistributorBySIdAndDState(sId,dState);
    }

    @Override
    public List<HashMap<String,Object>> getDistributorBySId(int sId){
        return distributorMapper.getDistributorBySId(sId);
    }

    @Override
    public int add(Distributor distributor){
        return distributorMapper.add(distributor);
    }

    @Override
    public int update(int dId,Distributor distributor){
        return distributorMapper.update(dId,distributor);
    }

    @Override
    public int delete(int dId){
        return distributorMapper.delete(dId);
    }
}
