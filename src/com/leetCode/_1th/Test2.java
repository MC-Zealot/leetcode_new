package com.leetCode._1th;

import java.util.HashMap;
import java.util.Map;

public class Test2 {
	public String getZhongWenByInt(int a){
		if(a>100000000){
            return "";
        }
	    String reVal = "";
	    
	    Map<Integer,String> map = new HashMap<Integer, String>();
	    map.put(1,"一");
	    map.put(2,"二");
	    map.put(3,"三");
	    map.put(4,"四");
	    map.put(5,"五");
	    map.put(6,"六");
	    map.put(7,"七");
	    map.put(8,"八");
	    map.put(9,"九");
	    map.put(0,"零");
	    Map<Integer,String> map2 = new HashMap<Integer, String>();
	    map2.put(1,"十");
	    map2.put(2,"百");
	    map2.put(3,"千");
	    map2.put(4,"万");
	    map2.put(5,"十万");
	    map2.put(6,"百万");
	    map2.put(7,"千万");
	    map2.put(8,"亿");

	    String str = String.valueOf(a);
	    char[] chars = str.toCharArray();
	    reVal = String.valueOf(map.get(Integer.parseInt(String.valueOf(chars[chars.length - 1]))));
	    for(int i = chars.length - 2,j=1; i >= 0; i--,j++){
	    	String tmp="";
	    	if(Integer.parseInt(String.valueOf(chars[i]))!=0){
	    		tmp = map.get(Integer.parseInt(String.valueOf(chars[i])))+map2.get(j);
	    	}else{
	    		tmp = map.get(Integer.parseInt(String.valueOf(chars[i])));
	    	}
	    	System.out.println(reVal.charAt(reVal.length()-1));
	    	if(reVal.charAt(reVal.length()-1)!='零'){
	    		reVal = tmp + reVal;
	    	}
	    		
	    }
	    
	    return reVal;
	}
	public static void main(String[] args) {
		Test2 t = new Test2();
		System.out.println(t.getZhongWenByInt(1001));
	}
}
