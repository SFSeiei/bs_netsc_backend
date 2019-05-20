package com.tjpu.bs.netsc.controller;

import com.tjpu.bs.netsc.entity.Distributor;
import com.tjpu.bs.netsc.pojo.JsonResult;
import com.tjpu.bs.netsc.service.DistributorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class DistributorController {
    @Autowired
    private DistributorService distributorService;

    /**
     * 根据SID查询派送人员列表
     * @param sid
     * @return
     */
    @RequestMapping(value = "distributors/{sid}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getDistributorBySId (@PathVariable(value = "sid") int sid){
        JsonResult r = new JsonResult();
        try {
            List<HashMap<String,Object>> distributorList = distributorService.getDistributorBySId(sid);
            r.setResult(distributorList);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据SID,DState查询派送人员列表
     * @param sid,dstate
     * @return
     */
    @RequestMapping(value = "distributorsByDstate/{sid}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getDistributorBySIdAndDstate (@PathVariable(value = "sid") int sid,@RequestParam(value = "dstate") String dstate){
        JsonResult r = new JsonResult();
        try {
            List<HashMap<String,Object>> distributorList = distributorService.getDistributorBySIdAndDState(sid,dstate);
            r.setResult(distributorList);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据DID查询派送人员
     * @param did
     * @return
     */
    @RequestMapping(value = "distributor/{did}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getDistributorByDId (@PathVariable(value = "did") int did){
        JsonResult r = new JsonResult();
        try {
            Distributor distributor = distributorService.getDistributorByDId(did);
            r.setResult(distributor);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 查询派送人员列表
     * @param
     * @return
     */
    @RequestMapping(value = "distributors", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getDistributors (){
        JsonResult r = new JsonResult();
        try {
            List<HashMap<String,Object>> distributorlist = distributorService.getDistributorList();
            r.setResult(distributorlist);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加派送人员
     * @param distributor
     * @return
     */
    @RequestMapping(value = "distributor", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody Distributor distributor){
        JsonResult r = new JsonResult();
        try {
            int orderId = distributorService.add(distributor);
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
     * 根据did删除派送人员
     * @param did
     * @return
     */
    @RequestMapping(value = "distributor/{did}", method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete (@PathVariable(value = "did") int did){
        JsonResult r = new JsonResult();
        try {
            int ret = distributorService.delete(did);
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
     * 根据did修改派送人员信息
     * @param did,distributor
     * @return
     */
    @RequestMapping(value = "distributor/{did}", method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update (@PathVariable("did") int did, @RequestBody Distributor distributor){
        JsonResult r = new JsonResult();
        try {
            int ret = distributorService.update(did, distributor);
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
