package com.tjpu.bs.netsc.service;

import com.tjpu.bs.netsc.entity.Role;

public interface RoleService {
    public Role getRoleInfoById(int roleId);

    public int add(Role role);

    public int update(int roleId, Role role);

    public int delete(int roleId);
}
