package com.tjpu.bs.netsc.service.impl;

import com.tjpu.bs.netsc.entity.Wallet;
import com.tjpu.bs.netsc.mapper.WalletMapper;
import com.tjpu.bs.netsc.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class WalletServiceimpl implements WalletService {
    @Autowired
    private WalletMapper walletMapper;

    @Override
    public Wallet getWalletByWId(int wId){
        return walletMapper.getWalletByWId(wId);
    }

    public Wallet getWalletByUId(String uId){
        return walletMapper.getWalletByUId(uId);
    }

    public List<HashMap<String,Object>> getWalletList(){
        return walletMapper.getWalletList();
    }

    public int add(Wallet wallet){
        return walletMapper.add(wallet);
    }

    public int update(String uId,Wallet wallet){
        return walletMapper.update(uId,wallet);
    }

    public int delete(int wId){
        return walletMapper.delete(wId);
    }
}
