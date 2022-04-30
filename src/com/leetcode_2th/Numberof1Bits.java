package com.leetcode_2th;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月29日 下午1:40:32 
 *
 */
public class Numberof1Bits {
	public int hammingWeight(int n) {
        int size = 0;
        while(n>0){
            if((n & 1)==1){
            	size++;
            }
            n= n >>> 1;
        }
        return size;
    }
public int hammingWeight2(int n) {
        
        int ans = 0;
        while (n != 0) {//可能有负数
            ans += n & 1;
            n >>>= 1;
        }
        return ans;
    
    }
	public static void main(String[] args) {
		int a = 5;
		Numberof1Bits n = new Numberof1Bits();
		System.out.println(n.hammingWeight(a));
	}
}
