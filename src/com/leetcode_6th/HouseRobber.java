package com.leetcode_6th;

import java.util.HashMap;
import java.util.Map;

public class HouseRobber {
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    public int rob(int[] nums) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        if(nums.length == 0) {
            return 0;
        }
        return robDp(nums.length - 1, nums) ;
    }
    public int robDp(int i, int[] nums){
        if(map.containsKey(i)) {
            return map.get(i);
        }
        if(i==0){
            return nums[0];
        }else if(i == 1){
            return Math.max(nums[1], nums[0]);
        }
        int ret = Math.max(robDp(i - 1, nums), robDp(i -2,nums) + nums[i]);
        map.put(i, ret);
        return ret;
    }
}
