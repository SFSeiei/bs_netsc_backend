package com.tjpu.bs.netsc.controller;

import com.tjpu.bs.netsc.entity.OrderInfo;
import com.tjpu.bs.netsc.pojo.JsonResult;
import com.tjpu.bs.netsc.service.OrderInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class OrderInfoController {
    @Autowired
    private OrderInfoService orderInfoService;

    /**
     * 根据OIID查询订单信息列表
     * @param oid
     * @return
     */
    @RequestMapping(value = "orderinfo/oid={oid}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getOrderInfoByOId (@PathVariable(value = "oid") int oid){
        JsonResult r = new JsonResult();
        try {
            List<HashMap<String,Object>> orderinfoList = orderInfoService.getOrderInfoByOId(oid);
            r.setResult(orderinfoList);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据OIID查询订单信息
     * @param oiid
     * @return
     */
    @RequestMapping(value = "order/{oiid}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getOrderInfoByOIId (@PathVariable(value = "oiid") int oiid){
        JsonResult r = new JsonResult();
        try {
            OrderInfo orderInfo = orderInfoService.getOrderInfoByOIId(oiid);
            r.setResult(orderInfo);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 查询订单信息列表
     * @param
     * @return
     */
    @RequestMapping(value = "orderinfos", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getOrderInfos (){
        JsonResult r = new JsonResult();
        try {
            List<HashMap<String,Object>> orderinfolist = orderInfoService.getOrderInfoList();
            r.setResult(orderinfolist);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加订单信息
     * @param orderInfo
     * @return
     */
    @RequestMapping(value = "orderinfo", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody OrderInfo orderInfo){
        JsonResult r = new JsonResult();
        try {
            int orderId = orderInfoService.add(orderInfo);
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
     * 根据OIId删除订单信息
     * @param oiid
     * @return
     */
    @RequestMapping(value = "orderinfo/{oiid}", method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete (@PathVariable(value = "oiid") int oiid){
        JsonResult r = new JsonResult();
        try {
            int ret = orderInfoService.delete(oiid);
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
     * 根据orderId删除订单信息
     * @param orderId
     * @return
     */
    @RequestMapping(value = "orderinfo/orderId={orderId}", method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> deleteByOrderId (@PathVariable(value = "orderId") int orderId){
        JsonResult r = new JsonResult();
        try {
            int ret = orderInfoService.deleteByOrderId(orderId);
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
     * 根据oiid修改订单信息
     * @param oiid,orderInfo
     * @return
     */
    @RequestMapping(value = "orderinfo/{oiid}", method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update (@PathVariable("oiid") int oiid, @RequestBody OrderInfo orderInfo){
        JsonResult r = new JsonResult();
        try {
            int ret = orderInfoService.update(oiid,orderInfo);
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
