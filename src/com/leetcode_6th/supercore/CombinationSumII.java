package com.leetcode_6th.supercore;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 *
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 *
 * 注意：解集不能包含重复的组合。
 * 示例 1:
 * 输入: candidates = [10,1,2,7,6,1,5], target = 8,
 * 输出:
 * [
 * [1,1,6],
 * [1,2,5],
 * [1,7],
 * [2,6]
 * ]
 * 示例 2:
 *
 * 输入: candidates = [2,5,2,1,2], target = 5,
 * 输出:
 * [
 * [1,2,2],
 * [5]
 * ]
 * 提示:
 * 1 <= candidates.length <= 100
 * 1 <= candidates[i] <= 50
 * 1 <= target <= 30
 */
public class CombinationSumII {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        Arrays.sort(candidates);
        dfs(candidates, target, 0, ret, new ArrayList<Integer>(), 0);
        return ret;
    }
    public void dfs(int[] candidates, int target, int tmpSum, List<List<Integer>> ret, List<Integer> list, int start){
        if(tmpSum == target){
            ret.add(new ArrayList<Integer>(list));
            return;
        }else if(tmpSum > target){
            return;
        }
        for(int i = start;i < candidates.length; i++){
            if(i > start && candidates[i] == candidates[i - 1]){//i > start：在开始的这一层，在dfs之前这一层，如果有重复则跳过
                continue;
            }
            list.add(candidates[i]);
            dfs(candidates, target, tmpSum + candidates[i], ret, list, i + 1);
            list.remove(list.size() - 1);
        }
    }
}
