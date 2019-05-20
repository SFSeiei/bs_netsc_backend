package com.tjpu.bs.netsc.controller;

import com.tjpu.bs.netsc.entity.Trolley;
import com.tjpu.bs.netsc.mapper.TrolleyMapper;
import com.tjpu.bs.netsc.pojo.JsonResult;
import com.tjpu.bs.netsc.service.TrolleyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class TrolleyController {
    @Autowired
    private TrolleyService trolleyService;

    /**
     * 根据UID查询购物车列表
     * @param uid
     * @return
     */
    @RequestMapping(value = "trolleys/uid={uid}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getTrolleysByUId (@PathVariable(value = "uid") String uid){
        JsonResult r = new JsonResult();
        try {
            List<HashMap<String,Object>> trolleyList = trolleyService.getTrolleyByUId(uid);
            r.setResult(trolleyList);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据TID查询购物车
     * @param tid
     * @return
     */
    @RequestMapping(value = "trolley/{tid}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getTrolleyByTId (@PathVariable(value = "tid") int tid){
        JsonResult r = new JsonResult();
        try {
            Trolley trolley = trolleyService.getTrolleyByTId(tid);
            r.setResult(trolley);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据PName&UId查询购物车
     * @param uId,pName
     * @return
     */
    @RequestMapping(value = "trolley/uId={uId}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getTrolleyByPNameAndUId (@PathVariable(value = "uId") String uId,@RequestParam(value = "pName") String pName){
        JsonResult r = new JsonResult();
        try {
            Trolley trolley = trolleyService.getTrolleyByPNameAndUId(pName, uId);
            r.setResult(trolley);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 查询购物车列表
     * @param
     * @return
     */
    @RequestMapping(value = "trolleys", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getTrolleys (){
        JsonResult r = new JsonResult();
        try {
            List<HashMap<String,Object>> trolleylist = trolleyService.getTrolleyList();
            r.setResult(trolleylist);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加购物车
     * @param trolley
     * @return
     */
    @RequestMapping(value = "trolley", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody Trolley trolley){
        JsonResult r = new JsonResult();
        try {
            int orderId = trolleyService.add(trolley);
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
     * 根据tid删除购物车
     * @param tid
     * @return
     */
    @RequestMapping(value = "trolley/{tid}", method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete (@PathVariable(value = "tid") int tid){
        JsonResult r = new JsonResult();
        try {
            int ret = trolleyService.delete(tid);
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
     * 根据tid修改购物车信息
     * @param tid,trolley
     * @return
     */
    @RequestMapping(value = "trolley/{tid}", method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update (@PathVariable("tid") int tid, @RequestBody Trolley trolley){
        JsonResult r = new JsonResult();
        try {
            int ret = trolleyService.update(tid, trolley);
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
