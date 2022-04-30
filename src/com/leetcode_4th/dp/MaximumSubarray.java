package com.leetcode_4th.dp;
/**
 * 
 * @author zealot
 * Created on: Mar 1, 2020 10:09:55 PM
 */
public class MaximumSubarray {
	public int maxSubArray(int[] nums) {
        if(nums==null || nums.length<=0){
            return 0;
        }
        int local_max=nums[0];//加当前节点大小，如果local_max<=0，则清零
        int globle_max=nums[0];//全局最大
        
        for(int i = 1;i < nums.length; i++){
            //计算local_max=local+ nums[i]
            //如果local_max大，则更新globel_max。
            //如果globle_max大，则local_max为0
            local_max += nums[i];
            if(local_max<nums[i]){
                local_max=nums[i];
            }
            if(local_max>globle_max){
                globle_max=local_max;
            }
        }
        return globle_max;
    }
}
