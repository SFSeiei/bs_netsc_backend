package com.tjpu.bs.netsc.mapper;

import com.tjpu.bs.netsc.entity.Product;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface ProductMapper {
    //SELECT
    @Select("SELECT * FROM tb_products WHERE sId = #{sId}")
    public List<HashMap<String,Object>> getProductBySId(@Param("sId") int sId);

    @Select("SELECT * FROM tb_products ")
    public List<HashMap<String,Object>> getProducts();

    @Select("SELECT * FROM tb_products WHERE pId = #{pId}")
    public Product getProductByPId(@Param("pId") int pId);

    @Select("SELECT * FROM tb_products WHERE pName = #{pName}")
    public List<HashMap<String,Object>> getProductByPName(@Param("pName") String pName);

    @Select("SELECT * FROM tb_products WHERE bCName = #{bCName}")
    public List<HashMap<String,Object>> getProductByBCName(@Param("bCName") String bCName);

    //INSERT
    @Insert("insert into tb_products(pId,bCId,pName,bCName,sId,pState, pReleaseTime, pPhoto, pPrice, pMemPrice,pDescribe,sellTime,overTime,sName) values(#{pId},#{bCId},#{pName}, #{bCName}, #{sId},#{pState}, now(),#{pPhoto},#{pPrice},#{pMemPrice},#{pDescribe},#{sellTime},#{overTime},#{sName})")
    public int add(Product product);

    //UPDATE
    @Update("UPDATE tb_products SET bCId = #{product.bCId}, pName = #{product.pName},bCName = #{product.bCName},pState = #{product.pState},pPhoto = #{product.pPhoto},pPrice = #{product.pPrice},pMemPrice = #{product.pMemPrice},pDescribe = #{product.pDescribe} WHERE pId = #{pId}")
    public int update(@Param("pId") int pId, @Param("product") Product product);

    //DELETE
    @Delete("DELETE from tb_products where pId = #{pId}")
    public int delete(@Param("pId") int pId);
}
