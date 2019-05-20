package com.tjpu.bs.netsc.service;

import com.tjpu.bs.netsc.entity.User;
import com.tjpu.bs.netsc.exception.regist.UserNameIsHaveException;

import java.util.List;

public interface UserService {
    public User getUserById(String id);

    public List<User> getUserList();

    public int add (User user) throws UserNameIsHaveException;

    public int update(String id, User user);

    public int delete(String id);

}
