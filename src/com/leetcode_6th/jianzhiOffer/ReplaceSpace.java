package com.leetcode_6th.jianzhiOffer;

/**
 * 剑指 Offer 05. 替换空格
 * 请实现一个函数，把字符串 s 中的每个空格替换成"%20"。
 */
public class ReplaceSpace {
    public String replaceSpace(String s) {
        if(s==null){
            return null;
        }
        s = s.replace(" ", "%20");
        return s;
    }
}
