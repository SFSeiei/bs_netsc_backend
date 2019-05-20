package com.tjpu.bs.netsc.service.impl;

import com.tjpu.bs.netsc.entity.Role;
import com.tjpu.bs.netsc.mapper.RoleMapper;
import com.tjpu.bs.netsc.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RoleServiceimopl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;

    @Override
    public Role getRoleInfoById(int roleId){return roleMapper.getRoleById(roleId);}
    @Override
    public int add(Role role){return roleMapper.add(role);}
    @Override
    public int update(int roleId, Role role){return roleMapper.update(roleId,role);}
    @Override
    public int delete(int roleId){return roleMapper.delete(roleId);}
}
