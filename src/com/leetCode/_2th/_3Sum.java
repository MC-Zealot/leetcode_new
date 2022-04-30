package com.leetCode._2th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c in S such that a + b + c = 0? Find all unique triplets in the array which gives the sum of zero.

Note:
Elements in a triplet (a,b,c) must be in non-descending order. (ie, a ≤ b ≤ c)
The solution set must not contain duplicate triplets.
    For example, given array S = {-1 0 1 2 -1 -4},

    A solution set is:
    (-1, 0, 1)
    (-1, -1, 2)

 * 
 * @author Zealot
 * @date 2016年3月9日 下午5:20:43 
 *
 */
public class _3Sum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		int target = 0;
		backTracing(nums, target, 0, new ArrayList<Integer>(),0, res);
		return res;
    }
	private void backTracing(int[] nums, int target, int cur, List<Integer> list,int sum,List<List<Integer>> res) {
		if(list.size() == 3 && sum == target){
//			System.out.println(list.get(0)+"+"+list.get(1)+"+"+list.get(2)+"="+sum);
			res.add(new ArrayList<Integer>(list));
			return ;
		}
		for(int i = cur; i < nums.length; i++) {
			if(sum + nums[i] > target||list.size()==3){
				break;
			}
			if(i > cur && nums[i-1] == nums[i]){
				continue;
			}
			list.add(nums[i]);
			backTracing(nums, target, i + 1, list, sum + nums[i], res);
			list.remove(list.size()-1);
		}
	}
	/**
	 * 夹逼法
	 * 时间复杂度为O(n^2+nlogn)=(n^2),空间复杂度是O(n)
	 * @date 2016年3月9日 下午9:40:51
	 * @param num
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> threeSum2(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length <= 2)
			return res;
		Arrays.sort(num);
		for (int i = num.length - 1; i >= 2; i--) {
			if (i < num.length - 1 && num[i] == num[i + 1])
				continue;
			ArrayList<ArrayList<Integer>> curRes = twoSum(num, i - 1, -num[i]);
			for (int j = 0; j < curRes.size(); j++) {
				curRes.get(j).add(num[i]);
			}
			res.addAll(curRes);
		}
		return res;
	}

	private ArrayList<ArrayList<Integer>> twoSum(int[] num, int end, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if (num == null || num.length <= 1)
			return res;
		int l = 0;
		int r = end;
		while (l < r) {
			if (num[l] + num[r] == target) {
				ArrayList<Integer> item = new ArrayList<Integer>();
				item.add(num[l]);
				item.add(num[r]);
				res.add(item);
				l++;
				r--;
				while (l < r && num[l] == num[l - 1])
					l++;
				while (l < r && num[r] == num[r + 1])
					r--;
			} else if (num[l] + num[r] > target) {
				r--;
			} else {
				l++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		_3Sum a = new _3Sum();
		int[] array = {-1, 0, 1, 2,-1, -4};
		a.threeSum(array);
	}
}
