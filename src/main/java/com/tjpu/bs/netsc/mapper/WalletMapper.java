package com.tjpu.bs.netsc.mapper;

import com.tjpu.bs.netsc.entity.Trolley;
import com.tjpu.bs.netsc.entity.Wallet;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface WalletMapper {
    @Select("SELECT * FROM tb_wallet WHERE wId = #{wId}")
    public Wallet getWalletByWId(@Param("wId") int wId);

    @Select("SELECT * FROM tb_wallet WHERE uId = #{uId}")
    public Wallet getWalletByUId(@Param("uId") String uId);

    @Select("SELECT * FROM tb_wallet")
    public List<HashMap<String,Object>> getWalletList();

    @Insert("insert into tb_wallet(wId,wName,money,payPassword,uId,firstUse) values(#{wId},#{wName},#{money},#{payPassword},#{uId},#{firstUse})")
    public int add(Wallet wallet);

    @Update("UPDATE tb_wallet SET money = #{wallet.money},payPassword = #{wallet.payPassword},firstUse = #{wallet.firstUse} WHERE uId = #{uId}")
    public int update(@Param("uId") String uId, @Param("wallet") Wallet wallet);

    @Delete("DELETE from tb_wallet where wId = #{wId} ")
    public int delete(@Param("wId") int wId);
}
