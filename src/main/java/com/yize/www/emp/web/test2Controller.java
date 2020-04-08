package com.yize.www.emp.web;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;


public class test2Controller {
    public static void main(String[] args) {
        //list部分
        String aa = new String("AA");
        ArrayList<Object> aList = new ArrayList<>();
        aList.add('1');
        aList.add('2');
        aList.add('3');
        aList.add('4');
        System.out.println(aList.toString());
        for (int i = 0 ;i < aList.size();i++){
            if (aList.get(i).equals('4')){
                aList.remove(i);
            }
        }
        System.out.println("删除后");
        System.out.println(aList.toString());
        //Map部分，迭代器删除指定键值
        Map<String,Object> m = new HashMap<String,Object>();
        m.put("a","a1");
        m.put("b","b23");
        m.put("c","c3");
        m.put("d","d4");
        System.out.println(m.toString());
        //获取迭代器
        Iterator<Map.Entry<String, Object>> iter = m.entrySet().iterator();
        while (iter.hasNext()){
            //获取m.Entry关系对象
            Map.Entry<String, Object> next = iter.next();
            //通过m.Entry关系对象获取到键key和值value
            String key = next.getKey();
            Object value = next.getValue();
            if (value.equals("d4")){
                //通过迭代器执行删除
                iter.remove();
            }
        }


        System.out.println("删除后");
        System.out.println(m.toString());
    }


}
