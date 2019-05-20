package com.tjpu.bs.netsc.shiro;

import org.apache.shiro.authc.UsernamePasswordToken;

/**
 * @author zhangxp
 */
public class SuperUsernamePasswordToken extends UsernamePasswordToken{
	
	public SuperUsernamePasswordToken(String username, String password) {
		super(username, password);
		// TODO Auto-generated constructor stub
	}
}
