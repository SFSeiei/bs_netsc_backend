package com.tjpu.bs.netsc.service.impl;

import com.tjpu.bs.netsc.entity.UserInfo;
import com.tjpu.bs.netsc.mapper.UserInfoMapper;
import com.tjpu.bs.netsc.service.UserInfoService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Service
public class UserInfoServiceimpl implements UserInfoService {
    @Autowired
    private UserInfoMapper userInfoMapper;

    @Override
    public UserInfo getUserInfoByUId(String uId) {
        return userInfoMapper.getUserInfoByUId(uId);
    }

    @Override
    public List<HashMap<String,Object>> getUserInfoByUstate(String ustate){
        System.out.println(userInfoMapper.getUserInfoByUstate(ustate));
        return userInfoMapper.getUserInfoByUstate(ustate);
    }

    @Override
    public int add(UserInfo userInfo){
        return userInfoMapper.add(userInfo);
    }

    @Override
    public int update(String uId, UserInfo userInfo) {
        return userInfoMapper.update(uId, userInfo);
    }

    @Override
    public int delete(String uId) {
        return userInfoMapper.delete(uId);
    }
}
