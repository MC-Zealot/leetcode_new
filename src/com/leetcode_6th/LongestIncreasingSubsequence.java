package com.leetcode_6th;

import java.util.Arrays;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp, 1);
        int ret = 0;
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            int max = 0;
            for(int j = 0; j < i; j++){
                if(num > nums[j]){
                    max = Math.max(dp[j], max) ;
                }
            }
            if(max !=0){
                dp[i] = max + 1;
            }
        }
        for(int i = 0; i < nums.length; i++){
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }
}
