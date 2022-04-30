package com.leetCode._2th;
/**
 *
 * @Description:
 * Reverse bits of a given 32 bits unsigned integer.

For example, given input 43261596 (represented in binary as 00000010100101000001111010011100), return 964176192 (represented in binary as 00111001011110000010100101000000).

Follow up:
If this function is called many times, how would you optimize it?
 * @author Zealot
 * @date 2016年2月14日 上午10:56:48
 *
 */
public class ReverseBits {
	// you need treat n as an unsigned value
	public int reverseBits(int n) {
		int reVal = 0;
		for(int i = 1;i <=32; i++) {
			if((n & 1) == 1) {//注意加小括号
				reVal = (reVal<<1) +1;
			}else{
				reVal = reVal<<1;
			}
			n = n >> 1;
		}

		return reVal;
	}
}
