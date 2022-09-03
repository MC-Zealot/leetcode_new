package com.leetcode_6th.core;

import java.util.*;

/**
 * 给你一个包含 n 个整数的数组nums，判断nums中是否存在三个元素 a，b，c ，使得a + b + c = 0 ？请你找出所有和为 0 且不重复的三元组。
 *
 * 注意：答案中不可以包含重复的三元组。
 *
 * 示例 1：
 *
 * 输入：nums = [-1,0,1,2,-1,-4]
 * 输出：[[-1,-1,2],[-1,0,1]]
 * 示例 2：
 *
 * 输入：nums = [0,1,1]
 * 输出：[]
 * 示例 3：
 *
 * 输入：nums = [0,0,0]
 * 输出：[[0,0,0]]
 *
 *
 * 提示：
 *
 * 3 <= nums.length <= 3000
 * -105 <= nums[i] <= 105
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/3sum
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class _3Sum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            if(map.containsKey(nums[i])){
                map.get(nums[i]).add(i);
            }else{
                List<Integer> list = new ArrayList<Integer>();
                list.add(i);
                map.put(nums[i], list);
            }
        }
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        for(int i = 0;i < nums.length; i++){
            if(i>0 && nums[i] == nums[i - 1]){
                continue;
            }
            for(int j = i + 1; j < nums.length; j++){
                if(j > i + 1 && nums[j] == nums[j - 1]){
                    continue;
                }
                int sum = nums[i] + nums[j];
                if(map.containsKey(-sum)){
                    List<Integer> indexs = map.get(-sum);
                    for(int k = 0; k < indexs.size(); k++){
                        int index = indexs.get(k);
                        if(index > j + 1 && nums[index] == nums[index - 1]){
                            continue;
                        }
                        if(index > i && index > j){
                            List<Integer> tmp = new ArrayList<Integer>();
                            tmp.add(nums[i]);
                            tmp.add(nums[j]);
                            tmp.add(nums[index]);
                            ret.add(new ArrayList(tmp));
                        }
                    }
                }
            }
        }
        return ret;
    }

    public List<List<Integer>> threeSum2(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        dfs(nums, 0, ret, new ArrayList<Integer>(), 0);
        return ret;
    }
    public void dfs(int[] nums, int index, List<List<Integer>> ret, List<Integer> tmp, int sum){
        if(sum == 0 && tmp.size() == 3){
            ret.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i = index; i < nums.length; i++){
            if(sum + nums[i] > 0 || tmp.size() == 3){
                break;
            }
            if(i > index && nums[i] == nums[i - 1]){
                continue;
            }
            tmp.add(nums[i]);
            dfs(nums, i + 1, ret, tmp, sum + nums[i]);
            tmp.remove(tmp.size() - 1);
        }
    }
}
