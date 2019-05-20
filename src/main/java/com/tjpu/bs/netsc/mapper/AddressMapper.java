package com.tjpu.bs.netsc.mapper;

import com.tjpu.bs.netsc.entity.Address;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddressMapper {
    @Select("SELECT * FROM tb_address WHERE uId = #{uId}")
    public List<Address> getAddressByUId(@Param("uId") String uId);

    @Insert("insert into tb_address(addId,addName,uId,linkmanName,telphone) values(#{addId},#{addName},#{uId}, #{linkmanName}, #{telphone})")
    public int add(Address address);

    @Update("UPDATE tb_address SET addName = #{address.addName}, linkmanName = #{address.linkmanName},telphone = #{address.telphone} WHERE addId = #{addId}")
    public int update(@Param("addId") int addId, @Param("userInfo") Address address);

    @Delete("DELETE from tb_address where addId = #{addId}")
    public int delete(@Param("addId") int addId);
}
