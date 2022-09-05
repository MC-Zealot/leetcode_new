package com.competition.No86Biweekly;

import java.util.HashSet;
import java.util.Set;

public class FindSubarrays {
    public boolean findSubarrays(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0; i < nums.length - 1; i++){
            int sum = nums[i] + nums[i + 1];
            if(set.contains(sum)){
                return true;
            }
            set.add(sum);
        }
        return false;
    }

    public static void main(String[] args) {
        FindSubarrays f = new FindSubarrays();
        int[] nums = {0,0,0};
        boolean ret = f.findSubarrays(nums);
        System.out.println(ret);
    }
}
