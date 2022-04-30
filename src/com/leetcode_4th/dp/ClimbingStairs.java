package com.leetcode_4th.dp;

/**
 * 
 * @author zealot
 * Created on: Mar 1, 2020 10:34:46 PM
 */
public class ClimbingStairs {
	public int climbStairs(int n) {
        if(n<=2){
            return n;
        }
        int ret = 0;
        int[] nums=new int[n];
        nums[0] = 1;
        nums[1] = 2;
        for(int i = 2; i < n; i++){
            nums[i] = nums[i - 1] + nums[i - 2];
        }
        return nums[n - 1];
    }
}
