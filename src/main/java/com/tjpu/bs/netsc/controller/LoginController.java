package com.tjpu.bs.netsc.controller;

import com.tjpu.bs.netsc.entity.User;
import com.tjpu.bs.netsc.entity.UserInfo;
import com.tjpu.bs.netsc.pojo.JsonResult;
import com.tjpu.bs.netsc.pojo.Result;
import com.tjpu.bs.netsc.service.UserInfoService;
import com.tjpu.bs.netsc.service.UserService;
import com.tjpu.bs.netsc.shiro.SuperUsernamePasswordToken;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.LockedAccountException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {
    @Autowired
    private UserInfoService userInfoService;

	@RequestMapping(value = "/login",method = RequestMethod.POST)
	public Result login(@RequestBody User user){
		
		Subject currentUser = SecurityUtils.getSubject();	//创建Subject实例
		
			//--用户是否登陆
		if (!currentUser.isAuthenticated()) {
        			//--把用户名和密码封装在UsernamePasswordToken对象
            	SuperUsernamePasswordToken token = new SuperUsernamePasswordToken(user.getUsername(), user.getPassword());
					//UsernamePasswordUsertypeToken token = new UsernamePasswordUsertypeToken(username,password, false,null,loginType)
            		//--rememberme
				token.setRememberMe(true);
            try {
            		//--执行登录
            	Map<String, Object> map = new HashMap();
                currentUser.login(token);
                    //--获取shiroRealm中SimpleAuthenticationInfo的第一个参数
                map.put("id", currentUser.getPrincipal());
                map.put("roleId", userInfoService.getUserInfoByUId((String)currentUser.getPrincipal()).getRoleId());
                return new Result(true, "登录成功",map);
            } 
            		//--若没有指定的用户，则shiro将会抛出UnknownAccountException异常。
            catch (UnknownAccountException uae) {
            	return new Result(false, "还没有注册哦");
            }
            		//--若账户存在，但密码不匹配，shiro会抛出IncorrectCredentialsException异常。
            catch (IncorrectCredentialsException ice) {
            	return new Result(false, "您输入的密码不正确");
            } 
            		//--用户被锁定的异常
            catch (LockedAccountException lae) {
            	return new Result(false, "异常登录，账户已锁定");
            }
            		//--所有认证异常的父类，还有除以上的其他子类
            catch (AuthenticationException ae) {
            	return new Result(false, ae.getMessage());
            }
        }
		
		return new Result(true, "已登录");
	}
}
