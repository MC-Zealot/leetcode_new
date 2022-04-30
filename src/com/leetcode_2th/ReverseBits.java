package com.leetcode_2th;
/**
 * Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), 
return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?
 * 
 * @author Zealot
 * @date 2016年6月17日 上午10:33:52 
 *
 */
public class ReverseBits {
	// you need treat n as an unsigned value
    public int reverseBits(int n) {
        //获取最后一位
    	int res = 0;
    	int x = 32;
    	while(x>0){
    		res = res|(n & 1);
    		if(x!=1){
    			res = res<<1;
    		}
    		n = n>>1;
    		x--;
    	}
    	return res;
    }
    public static void main(String[] args) {
    	ReverseBits r = new ReverseBits();
    	System.out.println(r.reverseBits(43261596));
	}
}
