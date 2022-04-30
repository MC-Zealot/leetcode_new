package com.leetcode_2th;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月6日 下午1:23:01 
 *
 */
public class ReverseInteger {
	public int reverse(int x) {
		int flag = 1;
		if(x<0){
			flag = -1;
			x = -x;
		}
        int res = 0;
		while(x>0){
			int last = x % 10;
			x = x / 10;
			int tmp = res;
			res = res * 10 + last;
			if((res - last)/10!=tmp){
				return 0;
			}
		}
        
        return flag * res;
    }
	public static void main(String[] args) {
		ReverseInteger r = new ReverseInteger();
		System.out.println(r.reverse(1534236469));
	}
}
