package com.tjpu.bs.netsc.mapper;

import com.tjpu.bs.netsc.entity.Shop;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface ShopMapper {
    //SELECT
    @Select("SELECT * FROM tb_shops WHERE uId = #{uId}")
    public List<HashMap<String,Object>> getShopByUId(@Param("uId") String uId);

    @Select("SELECT * FROM tb_shops WHERE sId = #{sId}")
    public Shop getShopBySId(@Param("sId") int sId);

    //INSERT
    @Insert("insert into tb_shops(sId,sName,bScope,shopMan,shopManTel, shopState, sRegisteTime, sDescribe, sPayDescribe, deliveryDescribe,uId,sPayNumber,sAddress) values(#{sId},#{sName},#{bScope}, #{shopMan}, #{shopManTel},#{shopState}, now(),#{sDescribe},#{sPayDescribe},#{deliveryDescribe},#{uId},#{sPayNumber},#{sAddress})")
    public int add(Shop shop);

    //UPDATE
    @Update("UPDATE tb_shops SET sName = #{shop.sName}, bScope = #{shop.bScope},shopMan = #{shop.shopMan},shopManTel = #{shop.shopManTel},shopState = #{shop.shopState},sDescribe = #{shop.sDescribe},sPayDescribe = #{shop.sPayDescribe},deliveryDescribe = #{shop.deliveryDescribe},sAddress = #{shop.sAddress} WHERE sId = #{sId}")
    public int update(@Param("sId") int sId, @Param("shop") Shop shop);

    //DELETE
    @Delete("DELETE from tb_shops where sId = #{sId}")
    public int delete(@Param("sId") int sId);
}
