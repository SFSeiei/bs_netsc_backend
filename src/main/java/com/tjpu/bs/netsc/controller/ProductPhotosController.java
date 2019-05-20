package com.tjpu.bs.netsc.controller;

import com.tjpu.bs.netsc.entity.ProductPhotos;
import com.tjpu.bs.netsc.pojo.JsonResult;
import com.tjpu.bs.netsc.service.ProductPhotosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
public class ProductPhotosController {
    @Autowired
    private ProductPhotosService productPhotosService;

    /**
     * 根据PID查询商品图片列表
     * @param pid
     * @return
     */
    @RequestMapping(value = "productPhotos/{pid}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getProductPhotosByPId (@PathVariable(value = "pid") int pid){
        JsonResult r = new JsonResult();
        try {
            List<HashMap<String,Object>> distributorList = productPhotosService.getProductPhotoByPId(pid);
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
     * 根据PPID查询商品图片
     * @param ppid
     * @return
     */
    @RequestMapping(value = "productPhoto/{ppid}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getProductPhotoByPPId (@PathVariable(value = "ppid") int ppid){
        JsonResult r = new JsonResult();
        try {
            ProductPhotos productPhotos = productPhotosService.getProductPhotoByPPId(ppid);
            r.setResult(productPhotos);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 查询商品图片列表
     * @param
     * @return
     */
    @RequestMapping(value = "productPhotos", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getProductPhotos (){
        JsonResult r = new JsonResult();
        try {
            List<HashMap<String,Object>> productPhotolist = productPhotosService.getProductPhotoList();
            r.setResult(productPhotolist);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加商品图片
     * @param productPhotos
     * @return
     */
    @RequestMapping(value = "productPhoto", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody ProductPhotos productPhotos){
        JsonResult r = new JsonResult();
        try {
            int orderId = productPhotosService.add(productPhotos);
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
     * 根据ppid删除商品图片
     * @param ppid
     * @return
     */
    @RequestMapping(value = "productPhoto/{ppid}", method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete (@PathVariable(value = "ppid") int ppid){
        JsonResult r = new JsonResult();
        try {
            int ret =productPhotosService.delete(ppid);
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
     * 根据ppid修改商品图片
     * @param ppid,productPhotos
     * @return
     */
    @RequestMapping(value = "productPhoto/{ppid}", method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update (@PathVariable("ppid") int ppid, @RequestBody ProductPhotos productPhotos){
        JsonResult r = new JsonResult();
        try {
            int ret = productPhotosService.update(ppid, productPhotos);
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
    @RequestMapping( value = "/productPhoto/uploadPic/{pid}", method = RequestMethod.POST)
    @ResponseBody
    public ResponseEntity<JsonResult> uploadPic(@PathVariable(value = "pid") int pid, @RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) throws IOException {
        JsonResult r = new JsonResult();
        //目前这里是写死的本地硬盘路径
        String path = "D:/img/productPhotos";
        //获取文件名称
        String fileName = file.getOriginalFilename();
        //获取文件名后缀
        Calendar currTime = Calendar.getInstance();
        String time = String.valueOf(currTime.get(Calendar.YEAR))+String.valueOf((currTime.get(Calendar.MONTH)+1));
        //获取文件名后缀
        String suffix = fileName.substring(file.getOriginalFilename().lastIndexOf("."));
        suffix = suffix.toLowerCase();
        if(suffix.equals(".jpg") || suffix.equals(".jpeg") || suffix.equals(".png")|| suffix.equals(".gif")){
            fileName = UUID.randomUUID().toString()+suffix;
            File targetFile = new File(path, fileName);
            if(!targetFile.getParentFile().exists()){    //注意，判断父级路径是否存在
                targetFile.getParentFile().mkdirs();
            }
            long size = 0;
            //保存
            try {
                file.transferTo(targetFile);
                size = file.getSize();
            } catch (Exception e) {
                e.printStackTrace();
                r.setResult("上传失败,异常："+e.getClass().getName() + ":" + e.getMessage());
                r.setStatus("error");
                return ResponseEntity.ok(r);    //R.error("上传失败！");
            }
            //项目url，这里可以使用常量或者去数据字典获取相应的url前缀；
            String fileUrl="http://localhost:8080";
            System.out.println(request);
            System.out.println(request.getContextPath());
            //文件获取路径
            fileUrl = fileUrl + request.getContextPath() + "/img/productPhotos/" + fileName;
            ProductPhotos productPhotos= new ProductPhotos();
            productPhotos.setPPurl(fileUrl);
            productPhotos.setPId(pid);
            ResponseEntity<JsonResult> updateR = this.add(productPhotos);
            r.setResult("上传成功，fileUrl="+fileUrl+",updateR:"+updateR);
            r.setStatus("ok");
            return  ResponseEntity.ok(r);   //R.ok().put("fileUrl", fileUrl);
        }else{
            r.setResult("上传失败，图片格式有误，请上传.jpg、.png、.jpeg格式的文件");
            r.setStatus("fail");
            return ResponseEntity.ok(r);   //R.error("图片格式有误，请上传.jpg、.png、.jpeg格式的文件");
        }

    }
}
