package com.tjpu.bs.netsc.mapper;

import com.tjpu.bs.netsc.entity.User;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserMapper {
    @Select("SELECT * FROM tb_users WHERE uId = #{uId}")
    User getUserById(@Param("uId") String uId);

    @Select("SELECT * FROM tb_users")
    public List<User> getUserList();

    @Insert("insert into tb_users(uId,username, password,registeTime, onLineState, lasttime) values(#{uId},#{username}, #{password}, now(), #{onLineState}, #{lastTime})")
    public int add(User user);

    @Update("UPDATE tb_users SET username = #{user.username}, password = #{user.password},onLineState = #{user.onLineState}, lasttime = #{user.lastTime} WHERE uId = #{uId}")
    public int update(@Param("uId") String uId, @Param("user") User user);

    @Delete("DELETE from tb_users where uId = #{uId} ")
    public int delete(@Param("uId") String uId);

}
