package com.tjpu.bs.netsc.mapper;

import com.tjpu.bs.netsc.entity.OrderInfo;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface OrderInfoMapper {
    @Select("SELECT * FROM tb_orderinfo WHERE oIId = #{oIId}")
    public OrderInfo getOrderInfoByOIId(@Param("oIId") int oIId);

    @Select("SELECT * FROM tb_orderinfo WHERE orderId = #{oId}")
    public List<HashMap<String,Object>> getOrderInfoByOId(@Param("oId") int oId);

    @Select("SELECT * FROM tb_orderinfo")
    public List<HashMap<String,Object>> getOrderInfoList();

    @Insert("insert into tb_orderinfo(orderId,oIId,pId,pName,pNumber,pPrice) values(#{orderId},#{oIId},#{pId},#{pName},#{pNumber},#{pPrice})")
    public int add(OrderInfo orderInfo);

    @Update("UPDATE tb_orderinfo SET pNumber = #{orderInfo.pNumber} WHERE oIId = #{oIId}")
    public int update(@Param("oIId") int oIId, @Param("orderInfo") OrderInfo orderInfo);

    @Delete("DELETE from tb_orderinfo where oIId = #{oIId} ")
    public int delete(@Param("oIId") int oIId);

    @Delete("DELETE from tb_orderinfo where orderId = #{orderId} ")
    public int deleteByOrderId(@Param("orderId") int orderId);
}
