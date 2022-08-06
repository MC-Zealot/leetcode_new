package com.leetcode_6th;

import java.util.HashMap;
import java.util.Map;

public class Isomorphic {
    public boolean isIsomorphic(String s, String t) {
        if(s==null || t==null || s.length() != t.length()){
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char cs = s.charAt(i);
            char ct = t.charAt(i);
            if(map.containsKey(cs)){
                if(map.get(cs)!= ct){
                    return false;
                }
            }
            if(map.containsValue(ct)){
                if(map.containsKey(cs)){
                    char val = map.get(cs);
                    if(val!=ct){
                        return false;
                    }
                }else{
                    return false;
                }

            }
            map.put(cs, ct);
        }
        StringBuffer sb = new StringBuffer();
        for(int i = 0; i < s.length(); i++){
            sb.append(map.get(s.charAt(i)));
        }
        return sb.toString().equals(t);
    }

    public static void main(String[] args) {
        Isomorphic i = new Isomorphic();
        System.out.println(i.isIsomorphic("badc", "baba"));
    }
}
