package com.tjpu.bs.netsc.entity;

import java.lang.reflect.Field;
import java.util.HashMap;

public class test2{
    static void bianLi(Object obj){
        Field[] fields = obj.getClass().getDeclaredFields();
        for(int i = 0 , len = fields.length; i < len; i++) {
            // 对于每个属性，获取属性名
            String varName = fields[i].getName();
            try {
                // 获取原来的访问控制权限
                boolean accessFlag = fields[i].isAccessible();
                // 修改访问控制权限
                fields[i].setAccessible(true);
                // 获取在对象f中属性fields[i]对应的对象中的变量
                Object o;
                try {
                    o = fields[i].get(obj);
                    System.err.println("传入的对象中包含一个如下的变量：" + varName + " = " + o);
                } catch (IllegalAccessException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
                // 恢复访问控制权限
                fields[i].setAccessible(accessFlag);
            } catch (IllegalArgumentException ex) {
                ex.printStackTrace();
            }
        }
    }
    public static void main(String[] args) {
//        UserInfo userInfo = new UserInfo(3,"管理员","gf","sdf","sdf","dfsdf","sdf","sdfaf",new Long("15620225280"),"sfds","asda",1,"sdf");
//        test2.bianLi(userInfo);
        HashMap<String,Object> maps= new HashMap<>();
//        maps.put("idcard","4568021");
//        maps.put("tel",15620225);
//        maps.put("sex",null);

        System.out.println(maps);

    }
}