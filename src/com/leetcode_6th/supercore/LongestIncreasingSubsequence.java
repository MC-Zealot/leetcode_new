package com.leetcode_6th.supercore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class LongestIncreasingSubsequence {
    public int lengthOfLIS(int[] nums) {
        int[] dp = new int[nums.length];//当选择第i个num的时候，当前的max
        Arrays.fill(dp,1);
        int ret = 1;
        for(int i = 1; i < nums.length; i++){
            int num = nums[i];
            int max = 0;
            for(int j = 0; j < i; j++){
                if(nums[j] < num){
                    max = Math.max(dp[j], max);
                }
            }
            dp[i] = max + 1;
            ret = Math.max(ret, dp[i]);
        }
        return ret;
    }

    int max = 0;
    public int lengthOfLIS2(int[] nums) {
        dfs(nums, new ArrayList<Integer>(), 0);
        return max;
    }
    public void dfs(int[] nums, List<Integer> tmp, int index){
        max = Math.max(max, tmp.size());
        for(int i = index; i < nums.length; i++){
            int num = nums[i];
            if(tmp.size() > 0 && tmp.get(tmp.size() - 1) >= num){
                continue;
            }
            tmp.add(num);
            dfs(nums, tmp, i + 1);
            tmp.remove(tmp.size() - 1);
        }
    }
}
