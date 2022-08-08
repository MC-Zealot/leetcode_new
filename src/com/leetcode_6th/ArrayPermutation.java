package com.leetcode_6th;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ArrayPermutation {
    /**
     * 因为输入的s中可能出现重复字符
     * 所以要对结果进行去重
     * @param s
     * @return
     */
    public String[] permutation(String s) {
        if(s == null){
            return null;
        }
        Set<String> list = new HashSet<>();
        boolean[] flags = new boolean[s.length()];
        dfs(s, "", list, flags);
        String[] ret = new String[list.size()];
        int i = 0;
        for(String str:list){
            ret[i] = str;
            i++;
        }

        return ret;
    }
    public void dfs(String s, String sb, Set<String> list, boolean[] flags){
        if(sb.length() == s.length()){
            list.add(sb);
            return;
        }
        for(int i = 0; i < s.length(); i++){
            if(flags[i] == false){
                flags[i] = true;
                sb += String.valueOf(s.charAt(i));
                dfs(s, sb, list, flags);
                sb = sb.substring(0, sb.length() - 1);
                flags[i] = false;
            }
        }
    }

    public static void main(String[] args) {
        ArrayPermutation ap = new ArrayPermutation();
        String s = "baa";
        System.out.println(ap.permutation(s));
    }
}
