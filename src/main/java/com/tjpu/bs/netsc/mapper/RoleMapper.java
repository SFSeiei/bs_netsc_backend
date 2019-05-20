package com.tjpu.bs.netsc.mapper;

import com.tjpu.bs.netsc.entity.Role;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RoleMapper {
    @Select("SELECT * FROM tb_roles WHERE roleId = #{roleId}")
    Role getRoleById(@Param("roleId") int roleId);

    @Select("SELECT * FROM tb_roles")
    public List<Role> getRoleList();

    @Insert("insert into tb_roles(roleId,roleName) values(#{roleId},#{roleName})")
    public int add(Role role);

    @Update("UPDATE tb_roles SET roleName = #{role.roleName} WHERE roleId = #{roleId}")
    public int update(@Param("roleId") int roleId, @Param("role") Role role);

    @Delete("DELETE from tb_roles where uId = #{roleId} ")
    public int delete(@Param("roleId") int roleId);
}
