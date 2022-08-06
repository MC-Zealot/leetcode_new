package com.leetcode_6th;

public class ReverseString {
    public void reverseString(char[] s) {
        if(s==null || s.length == 0){
            return;
        }
        helper(s, 0) ;
    }
    public void helper(char[] s, int i){
        if(i == s.length/2 ){
            return;
        }
        char tmp = s[i];
        s[i] = s[s.length - 1 - i];
        s[s.length - 1 - i]=tmp;
        helper(s,i + 1);
    }
}
