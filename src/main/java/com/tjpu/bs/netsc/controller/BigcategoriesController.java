package com.tjpu.bs.netsc.controller;

import com.tjpu.bs.netsc.entity.Bigcategories;
import com.tjpu.bs.netsc.pojo.JsonResult;
import com.tjpu.bs.netsc.service.BigcategoriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BigcategoriesController {
    @Autowired
    private BigcategoriesService bigcategoriesService;

    /**
     * 根据SCID查询大类
     * @param sCId
     * @return
     */
    @RequestMapping(value = "bigcategories/{sCId}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getBigcategoriesBySCId (@PathVariable(value = "sCId") int sCId){
        JsonResult r = new JsonResult();
        try {
            Bigcategories bigcategories = bigcategoriesService.getBigcategoriesByBId(sCId);
            r.setResult(bigcategories);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
    /**
     * 查询大类列表
     * @return
     */
    @RequestMapping(value = "bigcategories", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getBigcategoriesList (){
        JsonResult r = new JsonResult();
        try {
            List<Bigcategories> bigcategories = bigcategoriesService.getBigcategoriesList();
            r.setResult(bigcategories);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加大类
     * @param bigcategories
     * @return
     */
    @RequestMapping(value = "bigcategory", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody Bigcategories bigcategories){
        JsonResult r = new JsonResult();
        try {
            int orderId = bigcategoriesService.add(bigcategories);
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
     * 根据SCID删除大类
     * @param sCId
     * @return
     */
    @RequestMapping(value = "bigcategories/{sCId}", method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete (@PathVariable(value = "sCId") int sCId){
        JsonResult r = new JsonResult();
        try {
            int ret = bigcategoriesService.delete(sCId);
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
     * 根据SCID修改大类
     * @param sCId,,bigcategories
     * @return
     */
    @RequestMapping(value = "bigcategories/{sCId}", method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update (@PathVariable("sCId") int sCId, @RequestBody Bigcategories bigcategories){
        JsonResult r = new JsonResult();
        try {
            int ret = bigcategoriesService.update(sCId, bigcategories);
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
