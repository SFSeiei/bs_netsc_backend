package com.tjpu.bs.netsc.mapper;

import com.tjpu.bs.netsc.entity.ProductPhotos;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface ProductPhotosMapper {
    @Select("SELECT * FROM tb_productPhotos WHERE pPId = #{pPId}")
    ProductPhotos getProductPhotoByPPId(@Param("pPId") int pPId);

    @Select("SELECT * FROM tb_productPhotos")
    public List<HashMap<String,Object>> getProductPhotoList();

    @Select("SELECT * FROM tb_productPhotos WHERE pId = #{pId}")
    public List<HashMap<String,Object>> getProductPhotoByPId(@Param("pId") int pId);

    @Insert("insert into tb_productPhotos(pPId,pPurl,pId) values(#{pPId},#{pPurl},#{pId})")
    public int add(ProductPhotos productPhotos);

    @Update("UPDATE tb_productPhotos SET roleName = #{role.roleName} WHERE pPId = #{pPId}")
    public int update(@Param("pPId") int pPId, @Param("productPhotos") ProductPhotos productPhotos);

    @Delete("DELETE from tb_productPhotos where pPId = #{pPId} ")
    public int delete(@Param("pPId") int pPId);
}
