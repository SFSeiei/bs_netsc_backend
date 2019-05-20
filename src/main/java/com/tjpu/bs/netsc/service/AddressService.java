package com.tjpu.bs.netsc.service;

import com.tjpu.bs.netsc.entity.Address;

import java.util.List;

public interface AddressService {
    public List<Address> getAddressByUId(String uId);

    public int add(Address address);

    public int update(int addId, Address address);

    public int delete(int addId);
}
