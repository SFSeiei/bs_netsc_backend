package com.tjpu.bs.netsc.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 用于创建将当前时间转化为格式字符串便于存在数据库中的
 * @author 汪翔森
 *
 */
public class DataUtil {
	public static String getDataString() {
		return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
	}
	
	public static String getSuccessiveDataString() {
		return new SimpleDateFormat("yyyyMMddHHmmssSS").format(new Date());
	}
}
