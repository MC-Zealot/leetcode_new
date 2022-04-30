package com.leetCode._1th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 Given a collection of numbers, return all possible permutations.

 For example,
 [1,2,3] have the following permutations:
 [1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].
 * @author Zealot
 * @date 2015年8月25日 下午9:11:25
 */
public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		if (nums.length == 1) {
			List<Integer> li = new ArrayList<Integer>();
			li.add(nums[0]);
			List<List<Integer>> lli = new ArrayList<List<Integer>>();
			lli.add(li);
			return lli;
		} else {
			List<List<Integer>> lli = new ArrayList<List<Integer>>();
			for (int i = 0; i < nums.length; i++) {
				int head = nums[i];
				int[] sub = new int[nums.length - 1];
				for (int j = 0; j < sub.length; j++) {
					if (j < i) {
						sub[j] = nums[j];
					} else {
						sub[j] = nums[j + 1];
					}
				}
				List<List<Integer>> sublist = permute(sub);
				for (List<Integer> e : sublist) {
					e.add(0, head);
				}
				lli.addAll(sublist);
			}
			return lli;
		}
	}
	/**
	 *
	 * @date 2016年2月27日 下午9:10:40
	 * @param num
	 * @return
	 */
	public ArrayList<ArrayList<Integer>> permute2(int[] num) {
		ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
		if(num==null || num.length==0)
			return res;
		helper(num, new boolean[num.length], new ArrayList<Integer>(), res);
		return res;
	}
	private void helper(int[] num, boolean[] used, ArrayList<Integer> item, ArrayList<ArrayList<Integer>> res)
	{
		if(item.size() == num.length)
		{
			res.add(new ArrayList<Integer>(item));
			return;
		}
		for(int i=0;i<num.length;i++)
		{
			if(!used[i])
			{
				used[i] = true;
				item.add(num[i]);
				helper(num, used, item, res);
				item.remove(item.size()-1);
				used[i] = false;
			}
		}
	}
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
//		list.p
//		System.out.println(list.toString());
		list.add(1, "9");
//		System.out.println(list.toString());
		Permutations p = new Permutations();
		int[] nums = {1,2,3};
//		System.out.println(p.permute(nums));
		List<List<Integer>> combs = new ArrayList<>();
		int n = 4;
		for (int i = 1; i <= n; i++) combs.add(Arrays.asList(i));
		System.out.println(combs.toString());
	}
}
