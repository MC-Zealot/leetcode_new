package com.leetcode_3th.array;

import java.util.HashMap;
import java.util.Map;

/**
 * 给定一个整数数组和一个整数 k，你需要找到该数组中和为 k 的连续的子数组的个数。
 * 
 * 示例 1 :
 * 
 * 输入:nums = [1,1,1], k = 2 输出: 2 , [1,1] 与 [1,1] 为两种不同的情况。 说明 :
 * 
 * 数组的长度为 [1, 20,000]。 数组中元素的范围是 [-1000, 1000] ，且整数 k 的范围是 [-1e7, 1e7]。
 * 
 * 
 * @author Zealot
 * @date Jul 22, 2019 12:26:26 PM
 *
 */
public class SubarraySumEqualsK {
	int res = 0;
//有点像2sum
	/**
	 * case里边会有为0的情况 超时了
	 * 
	 * @date Jul 22, 2019 1:00:45 PM
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraySum(int[] nums, int k) {
		boolean[] flags = new boolean[nums.length];
		dfs(0, nums, k, 0, flags, 0);
		return res;
	}

	public void dfs(int curr, int[] nums, int k, int sum, boolean[] flags, int count) {

		if (count != 0 && sum == k) {
			System.out.println("bingo");
			res++;
		}
		for (int i = curr; i < nums.length; i++) {
			if (count != 0 && flags[i - 1] == false) {
				return;
			}
			flags[i] = true;
			System.out.println(nums[i]);
			dfs(i + 1, nums, k, sum + nums[i], flags, count + 1);
			System.out.println(nums[i]+"out");
			flags[i] = false;
		}
	}

	/**
	 * O(n^2) 超时
	 * @date Jul 22, 2019 1:24:56 PM
	 * @param nums
	 * @param k
	 * @return
	 */
	public int subarraySum2(int[] nums, int k) {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		int tmp = 0;
		int n = nums.length;
		for(int i = 0; i < n; i++) {
			tmp+=nums[i];
			map.put(i, tmp);
		}
		map.put(-1, 0);
		
		for (int i = 0; i < n; i++) {
			for (int j = i ; j < n; j++) {
				int sum = map.get(j) - map.get(i-1);
				 if(sum==k) {
					res++;
				}
			}
		}
		return res;
	}
	public int subarraySum3(int[] nums, int k) {
        int res = 0, n = nums.length;
        for (int i = 0; i < n; ++i) {
            int sum = nums[i];
            if (sum == k) ++res;
            for (int j = i + 1; j < n; ++j) {
                sum += nums[j];
                if (sum == k) ++res;
            }
        }
        return res;
    }

	public static void main(String[] args) {
		SubarraySumEqualsK s = new SubarraySumEqualsK();
//		int[] nums = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 };
//		int[] nums = { 1,1,1 };
		int[] nums = {28,54,7,-70,22,65,-6};
		System.out.println(s.subarraySum2(nums, 100));
	}
}
