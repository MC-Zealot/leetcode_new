package com.leetCode._2th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a collection of integers that might contain duplicates, nums, return all possible subsets.

 Note:
 Elements in a subset must be in non-descending order.
 The solution set must not contain duplicate subsets.
 For example,
 If nums = [1,2,2], a solution is:

 [
 [2],
 [1],
 [1,2,2],
 [2,2],
 [1,2],
 []
 ]
 * @Description:
 * @author Zealot
 * @date 2016��2��10�� ����6:43:18
 *
 */
public class SubsetsII {
	List<List<Integer>> re = new ArrayList<List<Integer>>();
	List<Integer> tmp = new ArrayList<Integer>();
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		Arrays.sort(nums);
		dfs(0, nums);

		return re;
	}
	private void dfs(int cur, int[] nums) {
		re.add(new ArrayList<Integer>(tmp));
		for(int i = cur; i < nums.length; i++) {
			System.out.println("i:" +i +", cur:" +cur);
			if(i > cur && nums[i] == nums[i-1]) {//��Ϊ�Ѿ����ź����ˣ�����ǰ�������ȣ���pass
				continue;
			}
			tmp.add(nums[i]);
			dfs(i + 1, nums);
			tmp.remove(tmp.size()-1);
		}
	}
	public static void main(String[] args) {
		SubsetsII s = new SubsetsII();
		int[] a = {1,2,2};
		List<List<Integer>> re = s.subsetsWithDup(a);
		for(List<Integer> list: re) {
			System.out.println(list.toString());
		}
	}
}
