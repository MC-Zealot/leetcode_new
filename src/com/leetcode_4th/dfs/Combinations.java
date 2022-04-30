package com.leetcode_4th.dfs;

import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author zealot
 * Created on: Mar 5, 2020 1:06:40 PM
 */
public class Combinations {
	public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(n<=0 || k<=0){
            return res;
        }
        dfs(0,new ArrayList<Integer>(), res, n, k);
        return res;
    }   
    public void dfs(int curr, List<Integer> tmp, List<List<Integer>> res, int n, int k){
        if(tmp.size() == k){
            res.add(new ArrayList(tmp));
            return;
        } 
        for(int i = curr; i < n; i++){
            int num = i+1;
            tmp.add(num);
            dfs(i + 1, tmp,res,n,k);
            tmp.remove(tmp.size() - 1);
        }
    }
    public static void main(String[] args) {
		int n = 4,k=2;
		Combinations c = new Combinations();
		List<List<Integer>> res = c.combine(n, k);
	}
}
