package com.leetCode._2th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]
 * @author Zealot
 * @date 2016年1月21日 下午10:44:17
 */
public class Subsets {
	List<Integer> l = new ArrayList<Integer>();
	public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        for(int i = 1; i < nums.length; i++) {
            List<List<Integer>> subList = new ArrayList<List<Integer>>();
            backTrace(nums,i,subList,0);
           for(List<Integer> li : subList){
        	   list.add(li);
           }
           l = new ArrayList<Integer>();
        }
        return list;
    }
    private void backTrace(int[] nums,int size, List<List<Integer>> subList,int i){
        if(l.size()==size){
            subList.add(l);
            i=0;
            return;
        }else{
            for(; i < nums.length; i++) {
                l.add(nums[i]);
                backTrace(nums,size,subList,i+1);
                l = new ArrayList<Integer>();
            }
        }
    }
    public List<List<Integer>> subsets2(int[] nums) {
        List<List<Integer>> list = new ArrayList<List<Integer>>();
        Arrays.sort(nums);
        dfs(nums,0,new ArrayList<Integer>(),list);
        return list;
    }
    public void dfs(int[] nums,int index, List<Integer> path, List<List<Integer>> result){
    	result.add(new ArrayList<Integer>(path));
    	for(int i = index; i < nums.length; i++){
    		path.add(nums[i]);
    		dfs(nums, i+1, path, result);
    		path.remove(path.size()-1);
    	}
    }
    public static void main(String[] args) {
		int[] a ={1,2,3};
		Subsets s = new Subsets();
		List<List<Integer>> list = s.subsets2(a);
//		for(List<Integer> l : list) {
//			System.out.println(l.toString());
//		}
		
	}
}
