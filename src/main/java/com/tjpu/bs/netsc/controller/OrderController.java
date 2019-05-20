package com.tjpu.bs.netsc.controller;

import com.tjpu.bs.netsc.entity.Order;
import com.tjpu.bs.netsc.pojo.JsonResult;
import com.tjpu.bs.netsc.service.OrderInfoService;
import com.tjpu.bs.netsc.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    /**
     * 根据UID查询订单列表
     * @param uid
     * @return
     */
    @RequestMapping(value = "order/uid={uid}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getOrderByUId (@PathVariable(value = "uid") String uid){
        JsonResult r = new JsonResult();
        try {
            List<HashMap<String,Object>> orderList = orderService.getOrderByUId(uid);
            r.setResult(orderList);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据SID查询订单列表
     * @param sid
     * @return
     */
    @RequestMapping(value = "order/sid={sid}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getOrderBySId (@PathVariable(value = "sid") int sid){
        JsonResult r = new JsonResult();
        try {
            List<HashMap<String,Object>> orderList = orderService.getOrderBySId(sid);
            r.setResult(orderList);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据OID查询订单
     * @param oid
     * @return
     */
    @RequestMapping(value = "order/{oid}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getOrderByOId (@PathVariable(value = "oid") int oid){
        JsonResult r = new JsonResult();
        try {
            Order order = orderService.getOrderByOId(oid);
            r.setResult(order);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 查询订单列表
     * @param
     * @return
     */
    @RequestMapping(value = "orders", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getOrders (){
        JsonResult r = new JsonResult();
        try {
            List<HashMap<String,Object>> orderlist = orderService.getOrderList();
            r.setResult(orderlist);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加订单
     * @param order
     * @return
     */
    @RequestMapping(value = "order", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody Order order){
        JsonResult r = new JsonResult();
        try {
            int orderId = orderService.add(order);
            if (orderId < 0) {
                r.setResult(orderId);
                r.setStatus("fail");
            } else {
                r.setResult(orderId);
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据oid删除订单
     * @param oid
     * @return
     */
    @RequestMapping(value = "order/{oid}", method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete (@PathVariable(value = "oid") int oid){
        JsonResult r = new JsonResult();
        try {
            int ret = orderService.delete(oid);
            if (ret < 0) {
                r.setResult(ret);
                r.setStatus("fail");
            } else {
                r.setResult(ret);
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据oid修改订单信息
     * @param oid,order
     * @return
     * #{order.sendGTime},payWay = #{order.payWay},getGTime = #{order.getGTime},payTime = #{order.payTime}, oState= #{order.oState}, oComment= #{order.oComment}
     */
    @RequestMapping(value = "order/{oid}", method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update (@PathVariable("oid") int oid, @RequestBody Order orderNew){
        JsonResult r = new JsonResult();
        Order order = orderService.getOrderByOId(oid);
        try {
            if (orderNew.getSendGTime()!=null){
                order.setSendGTime(orderNew.getSendGTime());
            }
            if(orderNew.getPayWay()!=null){
                order.setPayWay(orderNew.getPayWay());
            }
            if(orderNew.getGetGTime()!=null){
                order.setGetGTime(orderNew.getGetGTime());
            }
            if (orderNew.getPayTime()!=null){
                order.setPayTime(orderNew.getPayTime());
            }
            if (orderNew.getOState()!=null){
                order.setOState(orderNew.getOState());
            }
            if (orderNew.getOComment()!=null){
                order.setOComment(orderNew.getOComment());
            }
            System.out.println(orderNew.getDId());
            if (orderNew.getDId()!=0){
                order.setDId(orderNew.getDId());
            }
            if (orderNew.getDName()!=null){
                order.setDName(orderNew.getDName());
            }
            int ret = orderService.update(oid,order);
            if (ret < 0) {
                r.setResult(ret);
                r.setStatus("fail");
            } else {
                r.setResult(ret);
                r.setStatus("ok");
            }
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");

            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
}
