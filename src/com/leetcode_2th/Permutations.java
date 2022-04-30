package com.leetcode_2th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 
 * 排列
 * @author Zealot
 * @date 2016年6月12日 上午10:44:48 
 *
 */
public class Permutations {

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if(nums==null || nums.length==0){
			return res;
		}
		dfs(nums, new boolean[nums.length], res, new ArrayList<Integer>());
		return res;
    }
	private void dfs(int[] nums, boolean[] isVisited,List<List<Integer>> res, List<Integer> tmp) {
		if(tmp.size()==nums.length){
			res.add(new ArrayList<Integer>(tmp));
			return ;
		}
		for(int i = 0; i < nums.length; i++) {
			if(!isVisited[i]){
				isVisited[i]= true;
				tmp.add(nums[i]);
				dfs(nums, isVisited, res, tmp);
				tmp.remove(tmp.size()-1);
				isVisited[i]= false;
			}
		}
	}
	public static void main(String[] args) {
		LinkedList<String> list = new LinkedList<String>();
		list.add("1");
		list.add("2");
		list.add("3");
//		list.add(1, "9");
		Permutations p = new Permutations();
		int[] nums = {1,2,3};
		System.out.println(p.permute(nums));
//		List<List<Integer>> combs = new ArrayList<>();
//		int n = 4;
//		for (int i = 1; i <= n; i++) combs.add(Arrays.asList(i));
//		System.out.println(combs.toString());
	}
}
