package com.leetcode_4th.math;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zealot
 * Created on: Mar 15, 2020 12:11:16 PM
 */
public class AddStrings {
	public String addStrings2(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0, i = num1.length()-1, j = num2.length()-1;
        while(i >= 0 || j >= 0 || carry != 0){
            if(i>=0) carry += num1.charAt(i--)-'0';
            if(j>=0) carry += num2.charAt(j--)-'0';
            sb.append(carry%10);
            carry /= 10;
        }
        return sb.reverse().toString();
    }
	
	public String addStrings(String num1, String num2) {
        //两个字符串同时从最后一位开始，向前遍历，然后相加，进位
        int len1 = num1.length();
        int len2 = num2.length();
        StringBuffer sb = new StringBuffer();
        int carry = 0;
        int idx1 = len1  - 1;
        int idx2 = len2  - 1;
        while(idx1 >= 0 && idx2 >= 0){
            int digit1 = num1.charAt(idx1) - '0';
            int digit2 = num2.charAt(idx2) - '0';
            int sum = digit1 + digit2 + carry;
            if(sum >= 10){
                carry = 1;
                sum-=10;
            }else{
                carry=0;
            }
            idx1--;
            idx2--;
            sb.append(sum);
        }
        while(idx1>=0){
            int digit1 = num1.charAt(idx1) - '0';
            int sum = digit1 + carry;
            if(sum >= 10){
                carry = 1;
                sum-=10;
            }else{
                carry=0;
            }
            idx1--;
            sb.append(sum);
        }
        while(idx2>=0){
            int digit2 = num2.charAt(idx2) - '0';
            int sum = digit2 + carry;
            if(sum >= 10){
                carry = 1;
                sum-=10;
            }else{
                carry=0;
            }
            idx2--;
            sb.append(sum);
        }
        if(carry>0){
            sb.append(carry);
        }
        return sb.reverse().toString();
    }
	public static void main(String[] args) {
		List<Character> res = new ArrayList<Character>(10);//保存所有的非字母
		System.out.println(res.size());
		for(int i = 0; i < 10; i++){//初始化res
            res.add('0');
        }
		System.out.println(res.size());
		for(int i = 0; i < res.size(); i++) {
			res.set(i, 'a');
			System.out.println(res.get(i));
		}
	}
}
