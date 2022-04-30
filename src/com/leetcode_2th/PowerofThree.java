package com.leetcode_2th;
/**
 * Given an integer, write a function to determine if it is a power of three.

Follow up:
Could you do it without using any loop / recursion?
 * 
 * @author Zealot
 * @date 2016年6月19日 下午3:18:21 
 *
 */
public class PowerofThree {
	public boolean isPowerOfThree(int n) {
    	return n == 0 ? false : n == Math.pow(3, Math.round(Math.log(n) / Math.log(3)));
    }
}