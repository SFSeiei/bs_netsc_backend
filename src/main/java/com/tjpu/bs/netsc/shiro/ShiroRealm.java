package com.tjpu.bs.netsc.shiro;

import com.tjpu.bs.netsc.entity.User;
import com.tjpu.bs.netsc.pojo.JsonResult;
import com.tjpu.bs.netsc.service.UserService ;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.realm.AuthenticatingRealm;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 查询表中信息进行身份认证
 * @author zhangxp
 *
 */

public class ShiroRealm extends AuthenticatingRealm {
    @Autowired
    private UserService userService;

    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        //获取用户用户名
        String userName = (String) token.getPrincipal();

        //去数据库查找
        List<User> users1 = userService.getUserList();

        //参数为用户(object)id，数据库中的密码，加密盐值，远程地址
        String uId ="";
        String password = "";
        for (User oneuser : users1) {
            if (oneuser.getUsername().equals(userName)) {
                uId = oneuser.getUId();
                password = oneuser.getPassword();
                break;
            }
        }
        return new SimpleAuthenticationInfo(uId, password, ByteSource.Util.bytes(uId), getName());
    }
}


