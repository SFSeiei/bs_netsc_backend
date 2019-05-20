package com.tjpu.bs.netsc.mapper;

import com.tjpu.bs.netsc.entity.Order;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;

@Repository
public interface OrderMapper {
    @Select("SELECT * FROM tb_orders WHERE orderId = #{oId}")
    public Order getOrderByOId(@Param("oId") int oId);

    @Select("SELECT * FROM tb_orders WHERE uId = #{uId}")
    public List<HashMap<String,Object>> getOrderByUId(@Param("uId") String uId);

    @Select("SELECT * FROM tb_orders WHERE sId = #{sId}")
    public List<HashMap<String,Object>> getOrderBySId(@Param("sId") int sId);

    @Select("SELECT * FROM tb_orders")
    public List<HashMap<String,Object>> getOrderList();

    @Insert("insert into tb_orders(orderId,uId,proPrice,mPrice,createTime,getGWay,sendGTime,getGTime,payWay,payTime,oState,oComment,getAddress,linkmanName,telphone,sId) values(#{orderId},#{uId},#{proPrice},#{mPrice},now(),#{getGWay},#{sendGTime},#{getGTime},#{payWay},#{payTime},#{oState},#{oComment},#{getAddress},#{linkmanName},#{telphone},#{sId})")
    public int add(Order order);

    @Update("UPDATE tb_orders SET sendGTime = #{order.sendGTime},payWay = #{order.payWay},getGTime = #{order.getGTime},payTime = #{order.payTime}, oState= #{order.oState}, oComment= #{order.oComment},dId= #{order.dId},dName= #{order.dName} WHERE orderId = #{oId}")
    public int update(@Param("oId") int oId, @Param("order") Order order);

    @Delete("DELETE from tb_orders where orderId = #{oId} ")
    public int delete(@Param("oId") int oId);
}
