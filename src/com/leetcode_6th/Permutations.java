package com.leetcode_6th;

import java.util.ArrayList;
import java.util.List;

public class Permutations {
    int[] nums;
    int size;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        size = nums.length;
        int[] flags = new int[nums.length];
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        dfs(ret, new ArrayList<Integer>(), flags);
        return ret;
    }
    public void dfs(List<List<Integer>> ret, List<Integer> tmp, int[] flags){
        if(tmp.size() == size) {
            ret.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i = 0; i < size; i++){
            if(flags[i] == 1){
                continue;
            }
            flags[i] = 1;
            tmp.add(nums[i]);
            dfs(ret, tmp, flags);
            flags[i] = 0;
            tmp.remove(tmp.size() - 1);
        }
    }
}
