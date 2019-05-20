package com.tjpu.bs.netsc.controller;

import com.tjpu.bs.netsc.entity.Product;
import com.tjpu.bs.netsc.pojo.JsonResult;
import com.tjpu.bs.netsc.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@RestController
public class ProductController {
    @Autowired
    private ProductService productService;

    /**
     * 根据SID查询商品列表
     * @param sid
     * @return
     */
    @RequestMapping(value = "products/sid={sid}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getProductsBySId (@PathVariable(value = "sid") int sid){
        JsonResult r = new JsonResult();
        try {
            List<HashMap<String,Object>> prodectList = productService.getProductBySId(sid);
            r.setResult(prodectList);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据PID查询商品
     * @param pid
     * @return
     */
    @RequestMapping(value = "product/{pid}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getProductByPId (@PathVariable(value = "pid") int pid){
        JsonResult r = new JsonResult();
        try {
            Product product = productService.getProductByPId(pid);
            r.setResult(product);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据PName查询商品
     * @param pName
     * @return
     */
    @RequestMapping(value = "products/pName={pName}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getProductByPName (@PathVariable(value = "pName") String pName){
        JsonResult r = new JsonResult();
        try {
            List<HashMap<String,Object>> productlist = productService.getProductByPName(pName);
            r.setResult(productlist);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
    /**
     * 根据BCName查询商品
     * @param bCName
     * @return
     */
    @RequestMapping(value = "products/bCName={bCName}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getProductByBCName (@PathVariable(value = "bCName") String bCName){
        JsonResult r = new JsonResult();
        try {
            List<HashMap<String,Object>> productlist = productService.getProductByBCName(bCName);
            r.setResult(productlist);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
    /**
     * 查询商品列表
     * @param
     * @return
     */
    @RequestMapping(value = "products", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getProducts (){
        JsonResult r = new JsonResult();
        try {
            List<HashMap<String,Object>> productlist = productService.getProducts();
            r.setResult(productlist);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加商品
     * @param product
     * @return
     */
    @RequestMapping(value = "product", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody Product product){
        JsonResult r = new JsonResult();
        try {
            int orderId = productService.add(product);
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
     * 根据pid删除商品
     * @param pid
     * @return
     */
    @RequestMapping(value = "product/{pid}", method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete (@PathVariable(value = "pid") int pid){
        JsonResult r = new JsonResult();
        try {
            int ret = productService.delete(pid);
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
     * 根据pid修改商品信息
     * @param pid,product
     * @return
     */
    @RequestMapping(value = "product/{pid}", method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update (@PathVariable("pid") int pid, @RequestBody Product productNew){
        JsonResult r = new JsonResult();
        Product product = productService.getProductByPId(pid);
        try {
            if (productNew.getPDescribe()!=null){
                product.setPDescribe(productNew.getPDescribe());
            }
            if (!String.valueOf(productNew.getPMemPrice()).equals("0.0")){
                product.setPMemPrice(productNew.getPMemPrice());
            }
            if (!String.valueOf(productNew.getPPrice()).equals("0.0")){
                product.setPPrice(productNew.getPPrice());
            }
            if (productNew.getPPhoto()!=null){
                product.setPPhoto(productNew.getPPhoto());
            }
            if (productNew.getPState()!=null){
                product.setPState(productNew.getPState());
            }
            if (productNew.getBCName()!=null){
                product.setBCName(productNew.getBCName());
            }
            if (productNew.getBCId()!=0){
                product.setBCId(productNew.getBCId());
            }
            if (productNew.getPName()!=null){
                product.setPName(productNew.getPName());
            }
            int ret = productService.update(pid, product);
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
     * 上传图片
     * @param file
     * @param request
     * @throws IOException
     */
    @RequestMapping( value = "product/uploadPic/{pid}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<JsonResult> uploadPic(@PathVariable(value = "pid") int pid, @RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) throws IOException {
        JsonResult r = new JsonResult();
        //目前这里是写死的本地硬盘路径
        String path = "D:/img/productPhotos";
        //获取文件名称
        String fileName = file.getOriginalFilename();
        //获取文件名后缀
        Calendar currTime = Calendar.getInstance();
        String time = String.valueOf(currTime.get(Calendar.YEAR)) + String.valueOf((currTime.get(Calendar.MONTH) + 1));
        //获取文件名后缀
        String suffix = fileName.substring(file.getOriginalFilename().lastIndexOf("."));
        suffix = suffix.toLowerCase();
        if (suffix.equals(".jpg") || suffix.equals(".jpeg") || suffix.equals(".png") || suffix.equals(".gif")) {
            fileName = UUID.randomUUID().toString() + suffix;
            File targetFile = new File(path, fileName);
            if (!targetFile.getParentFile().exists()) {    //注意，判断父级路径是否存在
                targetFile.getParentFile().mkdirs();
            }
            long size = 0;
            //保存
            try {
                file.transferTo(targetFile);
                size = file.getSize();
            } catch (Exception e) {
                e.printStackTrace();
                r.setResult("上传失败,异常：" + e.getClass().getName() + ":" + e.getMessage());
                r.setStatus("error");
                return ResponseEntity.ok(r);    //R.error("上传失败！");
            }
            //项目url，这里可以使用常量或者去数据字典获取相应的url前缀；
            String fileUrl = "http://localhost:8080";
            System.out.println(request);
            System.out.println(request.getContextPath());
            //文件获取路径
            fileUrl = fileUrl + request.getContextPath() + "/img/productPhotos/" + fileName;
            Product product = new Product();
            product.setPPhoto(fileUrl);
            ResponseEntity<JsonResult> updateR = this.update(pid, product);
            r.setResult("上传成功，fileUrl=" + fileUrl + ",updateR:" + updateR);
            r.setStatus("ok");
            return ResponseEntity.ok(r);   //R.ok().put("fileUrl", fileUrl);
        } else {
            r.setResult("上传失败，图片格式有误，请上传.jpg、.png、.jpeg格式的文件");
            r.setStatus("fail");
            return ResponseEntity.ok(r);   //R.error("图片格式有误，请上传.jpg、.png、.jpeg格式的文件");
        }
    }
}
