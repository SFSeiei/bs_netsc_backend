package com.tjpu.bs.netsc.service;

import com.tjpu.bs.netsc.entity.Distributor;

import java.util.HashMap;
import java.util.List;

public interface DistributorService {
    Distributor getDistributorByDId(int dId);

    public List<HashMap<String,Object>> getDistributorList();

    public List<HashMap<String,Object>> getDistributorBySId(int sId);

    public List<HashMap<String,Object>> getDistributorBySIdAndDState(int sId,String dState);

    public int add(Distributor distributor);

    public int update(int dId,Distributor distributor);

    public int delete(int dId);
}
