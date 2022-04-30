package com.leetcode_2th;

import java.util.Arrays;

/**
 * Given an array of non-negative integers, you are initially positioned at the first index of the array.

Each element in the array represents your maximum jump length at that position.

Your goal is to reach the last index in the minimum number of jumps.

For example:
Given array A = [2,3,1,1,4]

The minimum number of jumps to reach the last index is 2. (Jump 1 step from index 0 to 1, then 3 steps to the last index.)

Note:
You can assume that you can always reach the last index.
 * 
 * @author Zealot
 * @date 2016年7月7日 下午3:49:15 
 *
 */
public class JumpGameII {
	public int jump(int[] nums) {
		int n = nums.length;
		int[] minjumps = new int[n];
		Arrays.fill(minjumps, Integer.MAX_VALUE);
		minjumps[0] = 0;
		for (int i = 0; i < n; i++) {
			int farest = Math.min(i + nums[i], n - 1);
			for (int j = i + 1; j <= farest; j++){
				if (minjumps[j] > minjumps[i] + 1){
					minjumps[j] = minjumps[i] + 1;
				}
			}
		}
		return minjumps[n - 1];
	}
	public int jump2(int[] nums) {
		int n = nums.length;
        int ret = 0;
        int cur = 0;//已经覆盖的地方
        int farest = 0;//最远能到达的地方
        for (int i = 0; i < n; ++i) {
            if (i > cur) {
                cur = farest;
                ++ret;
            }
            farest = Math.max(farest, i+nums[i]);
        }

        return ret;
    }
	public static void main(String[] args) {
		JumpGameII j = new JumpGameII();
		int[] a = {2,3,1,1,4};
		System.out.println(j.jump(a));
	}
}
