package com.leetcode_6th.supercore;

import java.util.ArrayList;
import java.util.List;

/**
 * 46. 全排列
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 *
 * 示例 1：
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 示例 2：
 * 输入：nums = [0,1]
 * 输出：[[0,1],[1,0]]
 * 示例 3：
 *
 * 输入：nums = [1]
 * 输出：[[1]]
 *
 * 提示：
 * 1 <= nums.length <= 6
 * -10 <= nums[i] <= 10
 * nums 中的所有整数 互不相同
 */
public class Permutations {
    int[] nums;
    public List<List<Integer>> permute(int[] nums) {
        this.nums = nums;
        boolean[] flags = new boolean[nums.length];
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        dfs(flags, ret, new ArrayList<Integer>());
        return ret;
    }
    public void dfs(boolean[] flags, List<List<Integer>> ret, List<Integer> tmp){
        if(tmp.size() == nums.length){
            ret.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(flags[i] == true){
                continue;
            }
            if(tmp.size() > nums.length){
                break;
            }
            int num = nums[i];
            tmp.add(num);
            flags[i] = true;
            dfs(flags, ret, tmp);
            tmp.remove(tmp.size() - 1);
            flags[i] = false;
        }
    }
}
