package com.leetcode_2th;
/**
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * @author Zealot
 * @date 2016年6月18日 下午2:21:24 
 *
 */
public class PowerofTwo {
	public boolean isPowerOfTwo(int n) {
		if(n<=0){
			return false;
		}
		int count = 0;
		for(int i = 0; i < 32; i++) {
			int digit = n & 1;
			if(digit==1){
				count++;
			}
			n = n>>1;
		}
        return count>1?false:true;
    }
	public static void main(String[] args) {
		PowerofTwo p = new PowerofTwo();
		
		System.out.println(p.isPowerOfTwo(15));
	}
}
