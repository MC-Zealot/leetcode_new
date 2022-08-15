package com.competition.No306Weekly;

import java.util.HashSet;
import java.util.Set;

public class CountSpecialNumbers {
    public int countSpecialNumbers(int n) {
        int ret = n;
        for(int i = 1;i <= n; i++){
            if(isSpecial(i)){
                n--;
            }
        }
        return ret;
    }
    public boolean isSpecial(int n){
        Set<String> set = new HashSet<>();
        String str = String.valueOf(n);
        for(int i = 0; i < str.length(); i++){
            String s = String.valueOf(str.charAt(i));
            if(set.contains(s)){
                return true;
            }
            set.add(s);
        }
        return false;
    }

    public static void main(String[] args) {
        CountSpecialNumbers c = new CountSpecialNumbers();
        System.out.println(c.isSpecial(100));
    }
}
