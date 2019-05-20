package com.tjpu.bs.netsc.pojo;

import java.io.Serializable;
import java.util.Map;


/**
 * 用于向页面传递信息的类
 * @author jt
 *
 */
public class Result implements Serializable{
	
	private boolean success;
	private boolean flag;
	private String message;
	private Map map;
	
	public Result(boolean success, String message) {
		super();
		this.success=success;
		this.flag = success;
		this.message = message;
	}
	
	
	
	public Result(boolean success, String message, Map map) {
		super();
		this.success = success;
		this.flag = success;
		this.message = message;
		this.map = map;
	}



	public Map getMap() {
		return map;
	}


	public void setMap(Map map) {
		this.map = map;
	}


	public boolean isFlag() {
		return flag;
	}
	public void setFlag(boolean flag) {
		this.flag = flag;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	
	public boolean isSuccess() {
		return success;
	}
	public void setSuccess(boolean success) {
		this.success = success;
	}
	
}
