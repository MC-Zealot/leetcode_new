package com.leetCode._2th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given a set of candidate numbers (C) and a target number (T), find all unique combinations in C where the candidate numbers sums to T.

The same repeated number may be chosen from C unlimited number of times.

Note:
All numbers (including target) will be positive integers.
Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
The solution set must not contain duplicate combinations.
For example, given candidate set 2,3,6,7 and target 7, 
A solution set is: 
[7] 
[2, 2, 3] 
 * @author Zealot
 *@date 2016.02.10
 */
public class CombinationSum {
	 List<List<Integer>> re = new ArrayList<List<Integer>>();
		List<Integer> tmp = new ArrayList<Integer>();
	    public List<List<Integer>> combinationSum(int[] candidates, int target) {
	    	Arrays.sort(candidates);
	    	dfs(0,0, candidates, target);
	    	return re;
	    }
	    
	    private void dfs(int cur, int sum, int[] candidates, int target) {
	    	
	    	if(target == sum){
	    		re.add(new ArrayList<Integer>(tmp));
	    	}else if(target>sum){
	    		for(int i = cur; i < candidates.length ; i++) {
	    			tmp.add(candidates[i]);
	    			dfs(i , sum + candidates[i], candidates, target);//因为每一个值可以重复，所以i不用++
	    			tmp.remove(tmp.size()-1);
	    		}
	    	}
	    	
		}
	    public static void main(String[] args) {
	    	CombinationSum c = new CombinationSum();
	    	int[] a = {2,3,6,7};
	    	List<List<Integer>> re = c.combinationSum(a, 7);
		    for(List<Integer> list: re) {
				System.out.println(list.toString());
			}
		}
}
