package com.leetcode_6th.supercore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 47. 全排列 II
 * 给定一个可包含重复数字的序列 nums ，按任意顺序 返回所有不重复的全排列。
 *
 * 示例 1：
 * 输入：nums = [1,1,2]
 * 输出：
 * [[1,1,2],
 *  [1,2,1],
 *  [2,1,1]]
 * 示例 2：
 *
 * 输入：nums = [1,2,3]
 * 输出：[[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
 * 提示：
 * 1 <= nums.length <= 8
 * -10 <= nums[i] <= 10
 */
public class PermutationsII {
    int[] nums;
    public List<List<Integer>> permuteUnique(int[] nums) {
        this.nums = nums;
        boolean[] flags = new boolean[nums.length];
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        dfs(flags, ret, new ArrayList<Integer>());
        return ret;
    }
    public void dfs(boolean[] flags, List<List<Integer>> ret, List<Integer> tmp){
        if(tmp.size() == nums.length){
            ret.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i = 0; i < nums.length; i++){
            if(flags[i] == true || (i > 0 && nums[i] == nums[i - 1] && flags[i - 1] == false)) {//flags[i - 1]在回退的过程中，刚刚被撤销，如果再计算同样的Num，会得到重复的值
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
