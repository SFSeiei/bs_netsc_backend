package com.tjpu.bs.netsc.mapper;

import com.tjpu.bs.netsc.entity.Trolley;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface TrolleyMapper {
    @Select("SELECT * FROM tb_trolley WHERE tId = #{tId}")
    Trolley getTrolleyByTId(@Param("tId") int tId);

    @Select("SELECT * FROM tb_trolley WHERE pName = #{pName} AND uId = #{uId}")
    Trolley getTrolleyByPNameAndUId(@Param("pName") String pName,@Param("uId") String uId);

    @Select("SELECT * FROM tb_trolley WHERE pId = #{pId} AND uId = #{uId}")
    Trolley getTrolleyByPIdAndUId(@Param("pId") int pId,@Param("uId") String uId);

    @Select("SELECT * FROM tb_trolley WHERE uId = #{uId}")
    public List<HashMap<String,Object>> getTrolleyByUId(@Param("uId") String uId);

    @Select("SELECT * FROM tb_trolley")
    public List<HashMap<String,Object>> getTrolleyList();

    @Insert("insert into tb_trolley(tId,pId,uId,pNumber,pPrice,getPTime,pName,sId) values(#{tId},#{pId},#{uId},#{pNumber},#{pPrice},now(),#{pName},#{sId})")
    public int add(Trolley trolley);

    @Update("UPDATE tb_trolley SET pNumber = #{trolley.pNumber} WHERE tId = #{tId}")
    public int update(@Param("tId") int tId, @Param("trolley") Trolley trolley);

    @Delete("DELETE from tb_trolley where tId = #{tId} ")
    public int delete(@Param("tId") int tId);

    @Delete("DELETE from tb_trolley where pId = #{pId} ")
    public int deleteByPId(@Param("pId") int pId);
}
