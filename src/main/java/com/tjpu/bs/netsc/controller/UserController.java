package com.tjpu.bs.netsc.controller;

import com.tjpu.bs.netsc.entity.User;
import com.tjpu.bs.netsc.entity.UserInfo;
import com.tjpu.bs.netsc.pojo.JsonResult;
import com.tjpu.bs.netsc.service.UserInfoService;
import com.tjpu.bs.netsc.service.UserService;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.*;

/**
 * @author  zhangxp
 * @ClassName  com.tjpu.bs.netsc.controller.UserController
 * @date  2019-3-17  18:35:20
 * @Description
 */
@RestController
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private UserInfoService userInfoService;
    /**
     * 根据ID查询用户
     * @param id
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUserById (@PathVariable(value = "id") String id){
        JsonResult r = new JsonResult();
        try {
            User user = userService.getUserById(id);
            r.setResult(user);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }
    /**
     * 查询用户列表
     * @return
     */
    @RequestMapping(value = "users", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUserList (){
        JsonResult r = new JsonResult();
        try {
            List<User> users = userService.getUserList();
            r.setResult(users);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @RequestMapping(value = "user", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody User user){
        JsonResult r = new JsonResult();
        try {
            int orderId = userService.add(user);
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
     * 根据id删除用户
     * @param id
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> delete (@PathVariable(value = "id") String id){
        JsonResult r = new JsonResult();
        try {
            int ret = userService.delete(id);
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
     * 根据id修改用户信息
     * @param user
     * @return
     */
    @RequestMapping(value = "user/{id}", method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update (@PathVariable("id") String id, @RequestBody User user){
        JsonResult r = new JsonResult();
        try {
            int ret = userService.update(id, user);
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
     * 根据ID查询用户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "userinfo/{id}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUserInfoByUId (@PathVariable(value = "id") String id){
        JsonResult r = new JsonResult();
        try {
            UserInfo userInfo = userInfoService.getUserInfoByUId(id);
            r.setResult(userInfo);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据ustate查询用户列表
     * @return
     */
    @RequestMapping(value = "userinfos/{ustate}", method = RequestMethod.GET)
    public ResponseEntity<JsonResult> getUserInfoListByUstate (@PathVariable(value = "ustate")String ustate){
        JsonResult r = new JsonResult();
        try {
            List<HashMap<String,Object>> userInfos = userInfoService.getUserInfoByUstate(ustate);
            r.setResult(userInfos);
            r.setStatus("ok");
        } catch (Exception e) {
            r.setResult(e.getClass().getName() + ":" + e.getMessage());
            r.setStatus("error");
            e.printStackTrace();
        }
        return ResponseEntity.ok(r);
    }

    /**
     * 根据id修改用户详细信息
     * @param id,userInfo
     * @return
     */
    @RequestMapping(value = "userinfo/{id}", method = RequestMethod.PUT)
    public ResponseEntity<JsonResult> update (@PathVariable("id") String id, @RequestBody UserInfo newUserInfo){
        JsonResult r = new JsonResult();
        UserInfo userInfo = userInfoService.getUserInfoByUId(id);
        try {
            if (newUserInfo.getUserImage()!=null){
                userInfo.setUserImage(newUserInfo.getUserImage());
            }
            if (newUserInfo.getUstate()!=null){
                userInfo.setUstate(newUserInfo.getUstate());
            }
            if(newUserInfo.getEmail()!=null){
                userInfo.setEmail(newUserInfo.getEmail());
            }
            if(newUserInfo.getNickname()!=null){
                userInfo.setNickname(newUserInfo.getNickname());
            }
            if (newUserInfo.getRealname()!=null){
                userInfo.setRealname(newUserInfo.getRealname());
            }
            if (newUserInfo.getUIDcard()!=null){
                userInfo.setUIDcard(newUserInfo.getUIDcard());
            }
            if (newUserInfo.getUSex()!=null){
                userInfo.setUSex(newUserInfo.getUSex());
            }
            if (newUserInfo.getUTel()!=null){
                userInfo.setUTel(newUserInfo.getUTel());
            }
            if (newUserInfo.getSType()!=null){
                userInfo.setSType(newUserInfo.getSType());
            }
            if (newUserInfo.getAddress()!=null){
                userInfo.setAddress(newUserInfo.getAddress());
            }
            if (newUserInfo.getRoleId()!=0){
                userInfo.setRoleId(newUserInfo.getRoleId());
            }
            if (newUserInfo.getURole()!=null){
                userInfo.setURole(newUserInfo.getURole());
            }
            int ret = userInfoService.update(id, userInfo);
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
     * 根据id删除用户信息
     * @param id
     * @return
     */
    @RequestMapping(value = "userinfo/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<JsonResult> deleteInfo (@PathVariable(value = "id") String id){
        JsonResult r = new JsonResult();
        try {
            int ret = userInfoService.delete(id);
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
     * 添加用户
     * @param userInfo
     * @return
     */
    @RequestMapping(value = "userinfo", method = RequestMethod.POST)
    public ResponseEntity<JsonResult> add (@RequestBody UserInfo userInfo){
        JsonResult r = new JsonResult();
        try {
            int orderId = userInfoService.add(userInfo);
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
     * 上传图片
     * @param file
     * @param request
     * @throws IOException
     */
    @RequestMapping( value = "/userinfo/uploadPic/{id}", method = RequestMethod.PUT)
    @ResponseBody
    public ResponseEntity<JsonResult> uploadPic(@PathVariable(value = "id") String id,@RequestParam(value = "file", required = false) MultipartFile file, HttpServletRequest request) throws IOException {
        JsonResult r = new JsonResult();
        //目前这里是写死的本地硬盘路径
        String path = "D:/img/userPhotos";
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
            fileUrl = fileUrl + request.getContextPath() + "/img/userPhotos/" + fileName;
            UserInfo userInfo= new UserInfo();
            userInfo.setUserImage(fileUrl);
            ResponseEntity<JsonResult> updateR = this.update(id,userInfo);
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
