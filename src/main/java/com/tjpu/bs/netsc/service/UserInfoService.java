package com.tjpu.bs.netsc.service;

import com.tjpu.bs.netsc.entity.UserInfo;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

public interface UserInfoService {
    public UserInfo getUserInfoByUId(String uId);

    public List<HashMap<String,Object>> getUserInfoByUstate(String ustate);

    public int add(UserInfo userInfo);

    public int update(String uId, UserInfo userInfo);

    public int delete(String uId);
}
