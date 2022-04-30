package com.leetCode._2th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)
 * 
 * @author Zealot
 * @date 2016年3月9日 下午9:09:40 
 *
 */
public class _4Sum {
	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		Arrays.sort(nums);
		backTracing(nums, target, 0, new ArrayList<Integer>(),0, res);
		return res;
    }
	private void backTracing(int[] nums, int target, int cur, List<Integer> list,int sum,List<List<Integer>> res) {
		if(list.size() == 4 && sum == target){
			res.add(new ArrayList<Integer>(list));
			return ;
		}
		for(int i = cur; i < nums.length; i++) {
			if(list.size()==4){
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

	public List<List<Integer>> fourSum2(int[] num, int target) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (num == null || num.length == 0)
			return res;
		Arrays.sort(num);
		for (int i = num.length - 1; i > 2; i--) {
			if (i == num.length - 1 || num[i] != num[i + 1]) {
				ArrayList<ArrayList<Integer>> curRes = threeSum(num, i - 1,
						target - num[i]);
				for (int j = 0; j < curRes.size(); j++) {
					curRes.get(j).add(num[i]);
				}
				res.addAll(curRes);
			}
		}
		return res;
	}

	private ArrayList<ArrayList<Integer>> threeSum(int[] num, int end,
			int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		for (int i = end; i > 1; i--) {
			if (i == end || num[i] != num[i + 1]) {
				ArrayList<ArrayList<Integer>> curRes = twoSum(num, i - 1,
						target - num[i]);
				for (int j = 0; j < curRes.size(); j++) {
					curRes.get(j).add(num[i]);
				}
				res.addAll(curRes);
			}
		}
		return res;
	}

	private ArrayList<ArrayList<Integer>> twoSum(int[] num, int end, int target) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
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
		long start = System.currentTimeMillis();
		_4Sum s = new _4Sum();
		int[] a = {-489,-487,-471,-464,-451,-421,-414,-405,-396,-355,-354,-350,-336,-335,-334,-307,-298,-296,-295,-287,-267,-256,-247,-231,-170,-130,-120,-109,-96,-80,-78,-71,-63,-56,-44,-43,-13,2,9,18,31,36,39,43,49,49,50,61,68,73,99,107,112,113,120,121,173,180,185,190,203,210,233,246,258,296,319,340,345,370,371,378,395,418,436,444,447,451,460,485};
		
				
		s.fourSum(a, 2926);
		long end = System.currentTimeMillis();
		System.out.println(end-start);
		
	}
}
