package com.leetCode._2th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a collection of numbers that might contain duplicates, return all possible unique permutations.

 For example,
 [1,1,2] have the following unique permutations:
 [1,1,2], [1,2,1], and [2,1,1].
 *
 * @author Zealot
 * @date 2016年2月27日 下午7:34:35
 *
 */
public class PermutationsII {
	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums.length==0){
			return res;
		}
		int len = nums.length;
		helper(0, new ArrayList<Integer>(), res, nums, len);
		Set<String> set = new HashSet<String>();
		for(List<Integer> l: res){
			StringBuffer sb = new StringBuffer();
			for(Integer i: l){
				sb.append(i).append(" ");
			}
			String str = sb.toString().substring(0, sb.length()-1);
			set.add(str);
		}
		res.clear();
		for(String s: set){
			String[] ss = s.split(" ");
			List<Integer> l = new ArrayList<Integer>();
			for(String a: ss){
				l.add(Integer.parseInt(a));
			}
			res.add(l);
		}
		return res;
	}
	private void helper(int cur, List<Integer> tmp, List<List<Integer>> res, int[] nums, int len) {
		if(tmp.size() == len){
			res.add(new ArrayList<>(tmp));
			System.out.println(tmp.toString());
		}
		for(int i = cur; i< len; i ++){
			tmp.add(nums[i]);
			helper(cur+1, tmp, res, nums, len);
			tmp.remove(tmp.size()-1);
		}
	}
	public List<List<Integer>> permuteUnique2(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums.length==0){
			return res;
		}
		Arrays.sort(nums);
		int len = nums.length;
		helper2(0, new ArrayList<Integer>(), res, nums, len);
		return res;
	}
	private void helper2(int cur, List<Integer> tmp, List<List<Integer>> res, int[] nums, int len) {
		if(tmp.size() == len){

			res.add(new ArrayList<>(tmp));
		}
		for(int i = cur; i< len; i ++){
			if(i!=0&&nums[i]!=nums[i-1]){

				tmp.add(nums[i]);
				helper(cur+1, tmp, res, nums, len);
				tmp.remove(tmp.size()-1);
			}
		}
	}
	/**
	 *
	 * @date 2016年2月27日 下午9:05:54
	 * @param num
	 * @return
	 */
	public List<List<Integer>> permuteUnique3(int[] num) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(num==null && num.length==0)
			return res;
		Arrays.sort(num);
		helper3(num, new boolean[num.length], new ArrayList<Integer>(), res);
		return res;
	}
	private void helper3(int[] num, boolean[] used, ArrayList<Integer> item, List<List<Integer>> res)
	{
		if(item.size() == num.length)
		{
			res.add(new ArrayList<Integer>(item));
			return;
		}
		for(int i=0;i<num.length;i++)
		{
			if(i>0 && !used[i-1] && num[i]==num[i-1]) continue;
			if(!used[i])
			{
				used[i] = true;
				item.add(num[i]);
				helper3(num, used, item, res);
				item.remove(item.size()-1);
				used[i] = false;
			}
		}
	}

	public static void main(String[] args) {
		PermutationsII p = new PermutationsII();
		int[] a = {1,2,3};
		List<List<Integer>> list = p.permuteUnique3(a);
		for(List<Integer> l:list){
			System.out.println(l.toString());
		}
	}
}
