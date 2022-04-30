package com.leetCode._2th;

import java.util.List;

import com.leetCode.CommonStructure.NestedInteger;

/**
 * Given a nested list of intergers, return the sum of all integers in the list weighted by their depth.
 * Each element is either an integer, or a list -- whose elements may also be integers or other lists
 * 
 * 
 * 
 * @author Zealot
 * @date 2016年4月1日 上午11:33:19 
 *
 */
public class NestedListWeightSum {
    public int depthSum(List<NestedInteger> nestedList) {
    	if(nestedList==null){
    		return 0;
    	}
    	
    	int depth = 1;
    	return dfs(nestedList, depth);
    }
    private int dfs(List<NestedInteger> nestedList, int depth) {
    	int sum = 0;
    	if(nestedList==null){
    		return sum;
    	}
    	for(int i = 0; i < nestedList.size(); i++) {
    		NestedInteger n = nestedList.get(i);
    		if(n==null){
    			continue;
    		}
    		if(n.isInteger()){
    			sum += depth*n.getInteger();
    		}else{
    			sum += dfs(n.getList(), depth + 1);
    		}
    	}
    	return sum;
	}
}
