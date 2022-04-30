package com.leetcode_2th;
/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

For example,
Given nums = [0, 1, 3] return 2.

Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 * 
 * @author Zealot
 * @date 2016年7月2日 下午1:30:51 
 *
 */
public class MissingNumber {
	public int missingNumber(int[] nums) {
		int sum = 0;
		int n = nums.length;
		for(int i = 0; i < n; i++) {
			sum+=nums[i];
		}
		return n * (1 + n) /2 - sum;
    }
	/**
	 * 将这个少了一个数的数组合0到n之间完整的数组异或一下，那么相同的数字都变为0了
	 * @date 2016年7月2日 下午2:20:45
	 * @param nums
	 * @return
	 */
	public int missingNumber2(int[] nums) {
        int res = 0;
        int res2 =0;
        int res3 = 0;
        for (int i = 0; i < nums.length; i++) {
			res2 ^= nums[i];
			res3 ^= i + 1;//之所以要i + 1，是因为，nums.length是缺少了一个数的，长度也少了1。i代表原来的数组，所以要在缺少1的nums.length+ 1
		}
        System.out.println(res2^ res3);
        for (int i = 0; i < nums.length; ++i) {
            res ^= (i + 1) ^ nums[i];
        }
        return res;
    }
	public static void main(String[] args) {
		int[] a = {0,1,3};
		MissingNumber m = new MissingNumber();
		System.out.println(m.missingNumber2(a));
	}
}
