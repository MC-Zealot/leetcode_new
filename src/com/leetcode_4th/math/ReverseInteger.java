package com.leetcode_4th.math;

/**
 * 
 * @author zealot
 * Created on: Mar 1, 2020 7:00:27 PM
 */
public class ReverseInteger {
	public int reverse(int x) {
        //每一次计算 if(num2 > Integer.MAX_VALUE - num1) 则返回0
        //记录符号
        //遍历数字，从最后一位开始，int digit = x % 10; 下一位，
        int ret = 0;
        int flag = 1;
        if(x<0){
            flag = -1;
            x = -x;
        }
        while(x>0){
            int digit = x % 10;
            int new_ret = ret *10 + digit;
        
            if((new_ret - digit) / 10 != ret){
                return 0;
            }
            x=x/10;
            ret = new_ret;
        }
        return flag * ret;
    }
}
