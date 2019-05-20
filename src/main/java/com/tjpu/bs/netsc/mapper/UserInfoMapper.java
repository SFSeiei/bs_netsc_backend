package com.tjpu.bs.netsc.mapper;

import com.tjpu.bs.netsc.entity.User;
import com.tjpu.bs.netsc.entity.UserInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Repository
public interface UserInfoMapper {
    //SELECT
    @Select("SELECT * FROM tb_userinfo WHERE uId = #{uId}")
    UserInfo getUserInfoByUId(@Param("uId") String uId);

    @Select("SELECT * FROM tb_users INNER JOIN tb_userinfo  ON tb_users.uId=tb_userinfo.uId WHERE tb_userinfo.ustate = #{ustate}")
    public List<HashMap<String,Object>> getUserInfoByUstate(@Param("ustate") String ustate);
//    Map<String,Object>
    //INSERT
    @Insert("insert into tb_userinfo(uIId,uId,ustate,email,nickname, realname, uIDcard, uSex, uTel, sType,address,roleId,uRole,userImage) values(#{uIId},#{uId},#{ustate}, #{email}, #{nickname},#{realname}, #{uIDcard},#{uSex},#{uTel},#{sType},#{address},#{roleId},#{uRole},#{userImage})")
    public int add(UserInfo userInfo);

    //UPDATE
    @Update("UPDATE tb_userinfo SET email = #{userInfo.email}, ustate = #{userInfo.ustate},nickname = #{userInfo.nickname},realname = #{userInfo.realname},uIDcard = #{userInfo.uIDcard},uSex = #{userInfo.uSex},uTel = #{userInfo.uTel},sType = #{userInfo.sType},address = #{userInfo.address},roleId = #{userInfo.roleId},uRole = #{userInfo.uRole},userImage = #{userInfo.userImage} WHERE uId = #{uId}")
    public int update(@Param("uId") String uId, @Param("userInfo") UserInfo userInfo);

    @Update("UPDATE tb_userinfo SET ustate = #{userInfo.ustate},sType = #{userInfo.sType} WHERE uId = #{uId}")
    public int updateTypeState(@Param("uId") String uId, @Param("userInfo") UserInfo userInfo);

    //DELETE
    @Delete("DELETE from tb_userinfo where uId = #{uId}")
    public int delete(@Param("uId") String uId);
}
