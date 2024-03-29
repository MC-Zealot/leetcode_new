package com.leetcode_4th.array;

import java.util.*;

/**
 * 给定一个整数数组 nums 和一个目标值 target，请你在该数组中找出和为目标值的那 两个 整数，并返回他们的数组下标。

你可以假设每种输入只会对应一个答案。但是，你不能重复利用这个数组中同样的元素。

示例:

给定 nums = [2, 7, 11, 15], target = 9

因为 nums[0] + nums[1] = 2 + 7 = 9
所以返回 [0, 1]

 * @author zealot
 * Created on: Feb 23, 2020 6:12:55 PM
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target) {
		int[] ret= {-1,-1};
		if(nums.length==0) {
			return ret;
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			if(map.containsKey(target - nums[i])) {
				ret[0]=map.get(target- nums[i]);
				ret[1]=i;
				return ret;
			}
			map.put(nums[i], i);
		}
		
		return ret;
    }
	/**
	 * 
	 * @param a
	 * @param n
	 * @return
	 * Created on: Mar 4, 2020 1:32:48 PM
	 */
	public List<List<Integer>> twoSum2(int[] a, int n){
		List<List<Integer>> res = new ArrayList<List<Integer>>();
	  	if(a.length==0){
	    	return res;
	    }
	  	Arrays.sort(a);//对数组排序，解决可能重复元素的问题
	  	Map<Integer, Integer> map = new HashMap<Integer, Integer>();//<值，下标>，
	  	Map<Integer, Integer> value_count = new HashMap<Integer, Integer>(); //值，计数
	  	//计算value_count
	  	for(int i = 0 ; i < a.length; i++){
	    	if(value_count.containsKey(a[i])){
	        	int count = value_count.get(a[i]);
	          	value_count.put(a[i], count+1);
	        }else{
	         	value_count.put(a[i],1); 
	        }
	    }
	  
	  
	  	for(int i = 0; i < a.length; i++){
	    	if(map.containsKey(n - a[i])){
	        	List<Integer> pair = new ArrayList<Integer>();
	          	pair.add(map.get(n - a[i]));
	          	pair.add(i);
	          	int tmp1 = value_count.get(map.get(n - a[i]));
	          	int tmp2 = value_count.get(i);
	          	int x = tmp1 + tmp2;
	          	for(int j = 0; j < x; j++){//如果出现多个重复现象
	            	res.add(new ArrayList<Integer>(pair));
	            }
	          	
	        }
	      	map.put(a[i],i);
	    }
	  	return res;

	}
	public int[] findDiagonalOrder(int[][] mat) {
		Map<Integer, List<String>> map = new HashMap<>();
		List<String> ret = new ArrayList<>();
		for(int i = 0; i < mat.length; i++){
			for(int j = 0; j < mat[0].length; j++){
				int key = i + j;
				if(!map.containsKey(key)){
					map.put(key, new ArrayList<String>());
				}
				map.get(key).add(i+"_"+j);
			}
		}
		for(Integer key: map.keySet()){
			List<String> list = map.get(key);
			if(key % 2 == 0){
				Collections.sort(list, Comparator.comparing(o->(-1) * Integer.parseInt(o.split("_")[0] +""+o.split("_")[1])));
			}else{

				Collections.sort(list, Comparator.comparing(o->Integer.parseInt(o.split("_")[0] +""+o.split("_")[1])));
			}
			ret.addAll(list);
		}
		int[] r = new int[mat.length * mat[0].length];
		for(int i = 0; i < r.length; i++){
			String val = ret.get(i);
			int x = Integer.parseInt(val.split("_")[0]);
			int y = Integer.parseInt(val.split("_")[1]);
			r[i] = mat[x][y];
		}
		return r;
	}
	public static void main(String[] args) {
		TwoSum t = new TwoSum();
//		int[] a = {1,1,2,2,1};
//		int n = 3;
////		List<List<Integer>> res = t.twoSum2(a, n);
//		int[] res = t.twoSum(a, n);
//		for(int i = 0; i< res.length; i++) {
//			System.out.println(res[i]);
//		}
		int[][] input = {
				{477,2647,-33},
				{289,735,-277},
				{164,5236,-320},
				{363,1067,-306},
				{345,483,-78},
				{307,3905,140},
				{260,3676,122},
				{195,5003,13},
				{331,4447,293},
				{40,5282,452},
				{335,5225,69}};
//		List<Integer> list = new ArrayList<>();
//		list.add(2);
//		list.add(3);
//		list.add(5);
//		list.add(1);
//		Collections.sort(list);
//		System.out.println(list.toString());
//		Collections.reverse(list);
//		System.out.println(list.toString());
		int[] ret = t.findDiagonalOrder(input);
		for(int i = 0; i<ret.length; i++){
			System.out.println(ret[i]);
		}
	}
}
