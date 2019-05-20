package com.tjpu.bs.netsc.controller;

import com.tjpu.bs.netsc.entity.Address;
import com.tjpu.bs.netsc.pojo.JsonResult;
import com.tjpu.bs.netsc.service.AddressService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
public class AddressController {
    @Autowired
    private AddressService addressService;

    /**
     * 根据ID查询用户地址
     * @param id
     * @return
     */
    @RequestMapping(value = "address/{id}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getAddressByUId (@PathVariable(value = "id") String id){
        JsonResult r = new JsonResult();
        try {
            List<Address> addressList = addressService.getAddressByUId(id);
            r.setResult(addressList);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加用户地址
     * @param address
     * @return
     */
    @RequestMapping(value = "address", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody Address address){
        JsonResult r = new JsonResult();
        try {
            int orderId = addressService.add(address);
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
     * 根据id删除用户地址
     * @param id
     * @return
     */
    @RequestMapping(value = "address/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete (@PathVariable(value = "id") int id){
        JsonResult r = new JsonResult();
        try {
            int ret = addressService.delete(id);
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
     * 根据id修改用户地址
     * @param address
     * @return
     */
    @RequestMapping(value = "address/{id}", method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update (@PathVariable("id") int id, @RequestBody Address address){
        JsonResult r = new JsonResult();
        try {
            int ret = addressService.update(id, address);
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
