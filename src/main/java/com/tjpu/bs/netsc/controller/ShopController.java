package com.tjpu.bs.netsc.controller;

import com.tjpu.bs.netsc.entity.Shop;
import com.tjpu.bs.netsc.pojo.JsonResult;
import com.tjpu.bs.netsc.service.ShopService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class ShopController {
    @Autowired
    private ShopService shopService;

    /**
     * 根据UID查询店铺列表
     * @param id
     * @return
     */
    @RequestMapping(value = "shops/{id}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getShopsByUId (@PathVariable(value = "id") String id){
        JsonResult r = new JsonResult();
        try {
            List<HashMap<String,Object>> shopList = shopService.getShopByUId(id);
            r.setResult(shopList);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据SID查询店铺
     * @param sid
     * @return
     */
    @RequestMapping(value = "shop/{sid}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getShopBySId (@PathVariable(value = "sid") int sid){
        JsonResult r = new JsonResult();
        try {
            Shop shop = shopService.getShopBySId(sid);
            r.setResult(shop);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加店铺
     * @param shop
     * @return
     */
    @RequestMapping(value = "shop", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody Shop shop){
        JsonResult r = new JsonResult();
        try {
            int orderId = shopService.add(shop);
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
     * 根据sid删除店铺
     * @param sid
     * @return
     */
    @RequestMapping(value = "shop/{sid}", method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete (@PathVariable(value = "sid") int sid){
        JsonResult r = new JsonResult();
        try {
            int ret = shopService.delete(sid);
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
     * 根据id修改店铺信息
     * @param sid,shop
     * @return
     */
    @RequestMapping(value = "shop/{sid}", method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update (@PathVariable("sid") int sid, @RequestBody Shop shop){
        JsonResult r = new JsonResult();
        try {
            int ret = shopService.update(sid, shop);
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
