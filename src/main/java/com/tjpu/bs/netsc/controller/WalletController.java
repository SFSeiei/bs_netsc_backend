package com.tjpu.bs.netsc.controller;

import com.tjpu.bs.netsc.entity.Wallet;
import com.tjpu.bs.netsc.pojo.JsonResult;
import com.tjpu.bs.netsc.service.WalletService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;

@RestController
public class WalletController {
    @Autowired
    private WalletService walletService;

    /**
     * 根据UID查询钱包列表
     * @param uid
     * @return
     */
    @RequestMapping(value = "wallet/uid={uid}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getWalletByUId (@PathVariable(value = "uid") String uid){
        JsonResult r = new JsonResult();
        try {
            Wallet wallet = walletService.getWalletByUId(uid);
            r.setResult(wallet);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据WID查询钱包
     * @param wid
     * @return
     */
    @RequestMapping(value = "wallet/{wid}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getWalletByWId (@PathVariable(value = "wid") int wid){
        JsonResult r = new JsonResult();
        try {
            Wallet wallet = walletService.getWalletByWId(wid);
            r.setResult(wallet);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 查询钱包列表
     * @param
     * @return
     */
    @RequestMapping(value = "wallets", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getWallets (){
        JsonResult r = new JsonResult();
        try {
            List<HashMap<String,Object>> walletlist = walletService.getWalletList();
            r.setResult(walletlist);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加钱包
     * @param wallet
     * @return
     */
    @RequestMapping(value = "wallet", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody Wallet wallet){
        JsonResult r = new JsonResult();
        try {
            int orderId = walletService.add(wallet);
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
     * 根据wid删除钱包
     * @param wid
     * @return
     */
    @RequestMapping(value = "wallet/{wid}", method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete (@PathVariable(value = "wid") int wid){
        JsonResult r = new JsonResult();
        try {
            int ret = walletService.delete(wid);
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
     * 根据uid修改钱包信息
     * @param uid,wallet
     * @return
     */
    @RequestMapping(value = "wallet/{uid}", method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update (@PathVariable("uid") String uid, @RequestBody Wallet walletNew){
        JsonResult r = new JsonResult();
        Wallet wallet = walletService.getWalletByUId(uid);
        System.out.println(String.valueOf(walletNew.getMoney()));
        try {
            if (!String.valueOf(walletNew.getMoney()).equals("0.0")){
                wallet.setMoney(walletNew.getMoney());
            }
            if(walletNew.getFirstUse()!=null){
                wallet.setFirstUse(walletNew.getFirstUse());
            }
            if(walletNew.getPayPassword()!=null){
                wallet.setPayPassword(walletNew.getPayPassword());
            }
            int ret = walletService.update(uid,wallet);
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
