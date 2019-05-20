package com.tjpu.bs.netsc.service.impl;

import com.tjpu.bs.netsc.entity.UserInfo;
import com.tjpu.bs.netsc.mapper.RoleMapper;
import com.tjpu.bs.netsc.mapper.UserInfoMapper;
import org.apache.shiro.util.ByteSource;
import com.tjpu.bs.netsc.exception.regist.UserNameIsHaveException;
import com.tjpu.bs.netsc.mapper.UserMapper;
import com.tjpu.bs.netsc.entity.User;
import com.tjpu.bs.netsc.service.UserService;
import com.tjpu.bs.netsc.util.NoteUtil;
import org.apache.shiro.crypto.hash.SimpleHash;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceimpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserInfoMapper userInfoMapper;
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public User getUserById(String id) {
        return userMapper.getUserById(id);
    }

    @Override
    public List<User> getUserList() {
        return userMapper.getUserList();
    }

    @Override
    public int add(User user) throws UserNameIsHaveException{
        /**
         * 对所有人的username进行重复审查，如有重复，抛出异常
         */
        List<User> users = this.getUserList();
        for(User oneuser : users) {
            if(user.getUsername().equals(oneuser.getUsername())) {
                throw new UserNameIsHaveException();
            }
        }

         user.setUId(NoteUtil.createId()); //创建id
        /*
         * 对密码进行加密
         */
        String hashAlgorithmName = "MD5";	//使用MD5加密
        Object salt = ByteSource.Util.bytes(user.getUId());	//以医生主键id进行盐值加密
        String result = new SimpleHash(hashAlgorithmName, user.getPassword(), salt, 1024).toHex();	//进行加密
        user.setPassword(result);	//将加密后的密码设置到用户属性中

        UserInfo userInfo = new UserInfo();   //同时创建个人信息，并设置默认角色

        userInfo.setUId(user.getUId());
        userInfo.setURole(roleMapper.getRoleById(2).getRoleName());
        userInfo.setRoleId(2);
        userInfo.setUstate("未提交申请");

        userMapper.add(user);
        return userInfoMapper.add(userInfo);
    }

    @Override
    public int update(String id, User userNew) {
        User user = userMapper.getUserById(id);
        if (userNew.getUsername()!=null){
            user.setUsername(userNew.getUsername());
        }
        if (userNew.getPassword()!=null){
            String hashAlgorithmName = "MD5";	//使用MD5加密
            Object salt = ByteSource.Util.bytes(id);	//以医生主键id进行盐值加密
            String result = new SimpleHash(hashAlgorithmName, userNew.getPassword(), salt, 1024).toHex();	//进行加密
            user.setPassword(result);
        }
        if(userNew.getOnLineState()!=null){
            user.setOnLineState(userNew.getOnLineState());
        }
        if(userNew.getLastTime()!=null){
            user.setLastTime(userNew.getLastTime());
        }
        return userMapper.update(id, user);
    }

    @Override
    public int delete(String id) {
        return userMapper.delete(id);
    }

}
