package com.tjpu.bs.netsc.mapper;

import com.tjpu.bs.netsc.entity.Bigcategories;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BigcategoriesMapper {
    @Select("SELECT * FROM tb_bigcategories WHERE bCId = #{bCId}")
    Bigcategories getBigcategoriesByBId(@Param("bCId") int bCId);

    @Select("SELECT * FROM tb_bigcategories")
    public List<Bigcategories> getBigcategoriesList();

    @Insert("insert into tb_bigcategories(bCId,bCName) values(#{bCId},#{bCName})")
    public int add(Bigcategories bigcategories);

    @Update("UPDATE tb_bigcategories SET bCName = #{bigcategories.bCName} WHERE bCId = #{bCId}")
    public int update(@Param("bCId") int bCId, @Param("bigcategories") Bigcategories bigcategories);

    @Delete("DELETE from tb_bigcategories where bCId = #{bCId} ")
    public int delete(@Param("bCId") int bCId);
}
