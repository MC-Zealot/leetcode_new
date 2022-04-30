package com.leetCode._2th;

/**
 * Given an integer, write a function to determine if it is a power of three.
 * 
 * Follow up: Could you do it without using any loop / recursion?
 * 
 * @author Zealot
 * @date 2016年1月10日 上午11:54:37
 */
public class PowerofThree {
	public boolean isPowerOfThree(int n) {
		if(n<0){
			return false;
		}
//		Math.
		for(int i = 0; i < n/2; i++){
			if(Math.pow(i, 3)==n){
				return true;
			}
		}
		
		return false;
	}
    public boolean isPowerOfThree2(int n) {
		for(int i = 1; i < n/2; i++){
			System.out.println(i<<1<<1);
			if(i<<1<<1==n){
				return true;
			}
		}
		
		return false;
	}
    public boolean isPowerOfThree3(int n) {
    	return n == 0 ? false : n == Math.pow(3, Math.round(Math.log(n) / Math.log(3)));
    } 
	public static void main(String[] args) {
//		System.out.println(Math.pow(3, Math.round(Math.log(8) / Math.log(3))));
//		System.out.println(Math.round(2.5235424352));
//		System.out.println(Math.pow(3, 2));
		PowerofThree pt = new PowerofThree();
		System.out.println(pt.isPowerOfThree3(81));
	}
}
