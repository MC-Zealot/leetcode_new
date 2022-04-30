package com.leetCode._1th;

/**
 * Given an array of numbers nums, in which exactly two elements appear only
 * once and all the other elements appear exactly twice. Find the two elements
 * that appear only once.
 * 
 * For example:
 * 
 * Given nums = [1, 2, 1, 3, 2, 5], return [3, 5].
 * 题意为给定一个整数数组，其中有两个数只出现一次，其余数出现两次。要求线性时间、常量空间找出这两个数。
 * 
 * 我们知道，两个相等的数异或结果为0。因此，首次扫描数组，得到两个单独的数A、B的异或结果AxorB。因为A和B不相等，因此AxorB一定不为0，
 * 且二进制位为1的位A和B一定不同。任取AxorB中的一个二进制位，可以将原数组元素分成两组异或即得结果。 Note: The order of the
 * result is not important. So in the above example, [5, 3] is also correct.
 * Your algorithm should run in linear runtime complexity. Could you implement
 * it using only constant space complexity?
 * 
 * @author Zealot
 * @date 2015年8月24日 下午10:21:00
 */
public class SingleNumberIII {
	public int[] singleNumber(int[] nums) {
		// Pass 1 :
		// Get the XOR of the two numbers we need to find
		int diff = 0;
		for (int num : nums) {
			diff ^= num;
		}
		// Get its last set bit
		diff &= -diff;

		// Pass 2 :
		int[] rets = { 0, 0 }; // this array stores the two numbers we will
								// return
//		把数组分成两组，通过2个数异或的那一位，然后每一组再进行异或，得到相应数值，台聪明了
		for (int num : nums) {
			if ((num & diff) == 0) // the bit is not set
			{
				rets[0] ^= num;
			} else // the bit is set
			{
				rets[1] ^= num;
			}
		}
		return rets;
	}

	public static void main(String[] args) {
		int a = 3;
		System.out.println(a & -a);
	}
}
