package com.tjpu.bs.netsc.service.impl;


import com.tjpu.bs.netsc.entity.Address;
import com.tjpu.bs.netsc.mapper.AddressMapper;
import com.tjpu.bs.netsc.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddressServiceimpl implements AddressService {
    @Autowired
    private AddressMapper addressMapper;

    @Override
    public List<Address> getAddressByUId(String uId) {
        return addressMapper.getAddressByUId(uId);
    }

    @Override
    public int add(Address address){
        return addressMapper.add(address);
    }

    @Override
    public int update(int addId, Address address) {
        return addressMapper.update(addId, address);
    }

    @Override
    public int delete(int addId) {
        return addressMapper.delete(addId);
    }
}
