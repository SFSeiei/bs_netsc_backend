package com.tjpu.bs.netsc.service;

import com.tjpu.bs.netsc.entity.Wallet;
import org.apache.ibatis.annotations.*;

import java.util.HashMap;
import java.util.List;

public interface WalletService {
    public Wallet getWalletByWId(int wId);

    public Wallet getWalletByUId(String uId);

    public List<HashMap<String,Object>> getWalletList();

    public int add(Wallet wallet);

    public int update(String uId,Wallet wallet);

    public int delete(int wId);
}
