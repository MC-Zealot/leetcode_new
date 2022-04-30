package com.leetCode._1th;

/**
 * Given an integer, write a function to determine if it is a power of two.
 * 
 * @author Zealot
 * @date 2015年9月6日 下午9:24:53
 */
public class PowerofTwo {
	public boolean isPowerOfTwo(int n) {
		int x = 1;
		while(x<=n){
			x = x<<1;
		}
		if(x>>1==n){
			return true;
		}
		return false;
	}
	public boolean isPowerOfTwo2(int n) {  
	       return n > 0 && ((n & (n - 1)) == 0 );  
	    } 
	public static void main(String[] args) {
		PowerofTwo p = new PowerofTwo();
		System.out.println(p.isPowerOfTwo(8));
//		System.out.println(7%2);
//		System.out.println(1<<1);
//		System.out.println(1<<2);
	}
}
