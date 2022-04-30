package com.leetcode_4th.string;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zealot
 * Created on: Mar 15, 2020 2:27:44 PM
 */
public class ReverseOnlyLetters {
	public String reverseOnlyLetters(String S) {
        if(S==null){
            return null;
        }
        StringBuffer tmp = new StringBuffer();//用一个tmp装所有的字母，
        List<Character> res = new ArrayList<Character>();//保存所有的非字母
        for(int i = 0; i < S.length(); i++){//初始化res，都为0
            res.add(null);
        }
        StringBuffer sb = new StringBuffer();//最终返回的
        for(int i = 0; i < S.length(); i++){//tmp和res赋值
            char c = S.charAt(i);
            if(isZimu(c)){
                tmp.append(c);
            }else{
                res.set(i, c);
            }
        }
        String s = tmp.reverse().toString();
        int j = 0;
        
        for(int i = 0; i < res.size() ; i++){
            if(res.get(i)!=null){
                sb.append(res.get(i));
            }else{
                if(j<s.length()){
                    sb.append(s.charAt(j++));
                }
                
            }
        }
        
        return sb.toString();
    }
    //判断是否是字母S.charAt(i) - 'A' >= 0 && S.charAt(i) - 'A'  <= 25
    //S.charAt(i) - 'a' >= 0 && S.charAt(i) - 'a'  <= 25
    public boolean isZimu(char c){
        if((c >= 'A' && c <= 'Z' )|| (c >= 'a' && c <= 'z' ) ){
            return true;
        }
        return false;
    }
    /**
     * 从前后两端开始找，找到字母交换位置
     * @param S
     * @return
     * Created on: Mar 15, 2020 2:32:01 PM
     */
    public String reverseOnlyLetters2(String S) {
        char[] arr=S.toCharArray();    
        int i=0,j=arr.length-1;
        char temp='0';
        while(i<j){
            while(!(('a'<=arr[i]&&arr[i]<='z')||('A'<=arr[i]&&arr[i]<='Z'))&&i<j){
                i++;
            }
            while(!(('a'<=arr[j]&&arr[j]<='z')||('A'<=arr[j]&&arr[j]<='Z'))&&i<j){
                j--;
            }
            if(i<j){
                temp=arr[i];
                arr[i]=arr[j];
                arr[j]=temp;
                i++;
                j--;
            }
        }
        return new String(arr);
    }
    public static void main(String[] args) {
    	ReverseOnlyLetters rol = new ReverseOnlyLetters();
    	String S = "6C40E";
	}
}
