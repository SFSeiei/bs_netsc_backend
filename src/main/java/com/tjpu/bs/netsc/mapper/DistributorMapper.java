package com.tjpu.bs.netsc.mapper;

import com.tjpu.bs.netsc.entity.Distributor;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface DistributorMapper {
    @Select("SELECT * FROM tb_distributors WHERE dId = #{dId}")
    Distributor getDistributorByDId(@Param("dId") int dId);

    @Select("SELECT * FROM tb_distributors")
    public List<HashMap<String,Object>> getDistributorList();

    @Select("SELECT * FROM tb_distributors WHERE sId = #{sId}")
    public List<HashMap<String,Object>> getDistributorBySId(@Param("sId") int sId);

    @Select("SELECT * FROM tb_distributors WHERE sId = #{sId} AND dState = #{dState}")
    public List<HashMap<String,Object>> getDistributorBySIdAndDState(@Param("sId") int sId,@Param("dState") String dState);

    @Insert("insert into tb_distributors(dId,sId,dName,dState) values(#{dId},#{sId},#{dName},#{dState})")
    public int add(Distributor distributor);

    @Update("UPDATE tb_distributors SET dState = #{distributor.dState} WHERE dId = #{dId}")
    public int update(@Param("dId") int dId, @Param("distributor") Distributor distributor);

    @Delete("DELETE from tb_distributors where dId = #{dId} ")
    public int delete(@Param("dId") int dId);
}
