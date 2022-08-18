package com.leetcode_6th.jianzhiOffer;

import java.util.HashMap;

/**
 * 剑指 Offer II 010. 和为 k 的子数组
 * 给定一个整数数组和一个整数 k ，请找到该数组中和为 k 的连续子数组的个数。
 *
 * 示例 1：
 * 输入:nums = [1,1,1], k = 2
 * 输出: 2
 * 解释: 此题 [1,1] 与 [1,1] 为两种不同的情况
 *
 * 示例 2：
 * 输入:nums = [1,2,3], k = 3
 * 输出: 2
 *
 *
 * 提示:
 * 1 <= nums.length <= 2 * 104
 * -1000 <= nums[i] <= 1000
 * -107 <= k <= 107
 *
 * 注意：本题与主站 560 题相同： https://leetcode-cn.com/problems/subarray-sum-equals-k/
 */
public class SubarraySum {
    /**
     *     * 时间复杂度：O(n^2)
     *      * 空间：O(n)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum(int[] nums, int k) {
        int sum = 0;
        int[] sumArr = new int[nums.length + 1];
        for(int i = 0;i < nums.length; i++){
            int num = nums[i];
            sum+= num;
            sumArr[i + 1] = sum;
        }
        int ret = 0;
        for(int i = 0; i < sumArr.length; i++){
            for(int j = i + 1; j < sumArr.length; j++){
                int diff = sumArr[j]-sumArr[i];
                if(diff == k){
                    ret++;
                }
            }
        }
        return ret;
    }

    /**
     * 时间复杂度：O(n)
     * 空间：O(n)
     * @param nums
     * @param k
     * @return
     */
    public int subarraySum2(int[] nums, int k) {
        int count = 0, pre = 0;
        HashMap< Integer, Integer > mp = new HashMap < > ();
        mp.put(0, 1);
        for (int i = 0; i < nums.length; i++) {
            pre += nums[i];
            if (mp.containsKey(pre - k)) {
                count += mp.get(pre - k);
            }
            mp.put(pre, mp.getOrDefault(pre, 0) + 1);
        }
        return count;
    }

    public static void main(String[] args) {
        SubarraySum ss = new SubarraySum();
        int[] nums = {1,2,3};
        int k = 3;
        int ret = ss.subarraySum(nums, k);
        System.out.println(ret);
    }
}
