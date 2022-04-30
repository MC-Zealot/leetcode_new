package com.leetcode_3th.dfs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Permutations {
	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<List<Integer>>();
		if (nums.length == 0 || nums == null) {
			return res;
		}
		int[] flags = new int[nums.length];
		Arrays.sort(nums);
		dfs(nums, flags, res, new ArrayList<Integer>());

		return res;
	}

	public void dfs(int[] nums, int[] flags, List<List<Integer>> res, List<Integer> tmp) {
		
		if (nums.length==tmp.size()) {
			res.add(new ArrayList<Integer>(tmp));
			return;
		}
		for(int i = 0; i < nums.length; i++) {
			if(flags[i] == 1) {
				continue;
			}
			tmp.add(nums[i]);
			flags[i]=1;
			dfs(nums,flags,res, tmp);
			flags[i]=0;
			tmp.remove(tmp.size()-1);
		}
		
	}
//	public List<List<Integer>> cnk(int N, int K){
//	  	List<List<Integer>> res = new ArrayList<List<Integer>>();
//	 	if(N==0||K==0){
//	   		return res;   
//	    }
//	  	//构造数组
//	  	int[] a = new int[N];
//	  	for(int i = 0; i < N; i++){
//	     	a[i] = i + 1; 
//	    }
//	  	int[] flags = new int[N];
//	  	Set<String>  res2 = new HashSet<String>();
//	  	dfs(a,0,K,flags,res,new ArrayList<Integer>());
//	  
//	  	//res2转换成res，HashSet转List<List<Integer>>，然后返回
//	  	for(int i = 0; i < res2.size(); i++){
//	  		
//	    	String tmp = res2.get(i);
//	      	String[] digits = tmp.split(",");
//	      	List<Integer> l = new ArrayList<Integer>();
//	      	for(int j = 0; j < digits.length; j++) {
//	        	l.add(Integer.parseInt(digits[i]));
//	        }
//	      	res.add(l);
//	    }
//	  	return res;
//	}
////最大连通子图
//	public void dfs(int[] a, int cur, int K, int[] flags,Set<String> res2, List<Integer> tmp){
//		 if(tmp.size()==K){
//	       //判断tmp是否重复，1,2,3,4 与4，3，2，1重复。
//	       //如果重复则不add
//	       //解决重复问题：tmp排序，组成字符串,add到Set里边
//	       	Collections.sort(tmp);
//	        StringBuffer sb = new StringBuffer();
//	       	for(int i = 0; i< tmp.size(); i++){
//	        	sb.append(tmp.get(i)).append(",");
//	        }
//	       	String sb_str = sb.toString();
//	       	int len = sb_str.length();
//	       	sb_str = sb_str.substring(0, len -2);
//	      	res2.add(sb_str);
//	     }
//	  		
//	  	 for(int i = cur; i < a.length; i++){
//	     	if(flags[i] == 1){
//	        	continue;
//	        }
//	       tmp.add(a[i]);
//	       flags[i] = 1;
//	       dfs(a,cur + 1, K,flags,res2,tmp);
//	       flags[i] = 0;
//	       tmp.remove(tmp.size() -1);
//	     }
//	}

	public static void main(String[] args) {
		Permutations p = new Permutations();
		int[] nums = { 4, 2, 0, 2, 3, 2, 0 };
//		List<List<Integer>> res = p.cnk(6,4);
//		for(int i = 0; i < res.size(); i ++) {
//			System.out.println(res.get(i));
//		}
//		String tmp = "123";
//		System.out.println(p.permute(nums));
//		List<List<Integer>> combs = new ArrayList<>();
//		int n = 4;
//		for (int i = 1; i <= n; i++) combs.add(Arrays.asList(i));
//		System.out.println(combs.toString());
	}
}
