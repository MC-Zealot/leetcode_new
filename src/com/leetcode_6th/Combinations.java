package com.leetcode_6th;

import java.util.ArrayList;
import java.util.List;

public class Combinations {
    int n;
    int k;
    public List<List<Integer>> combine(int n, int k) {
        this.n = n;
        this.k = k;
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        dfs(1, new ArrayList<Integer>(), ret);
        return ret;
    }
    public void dfs(int index, List<Integer> tmp, List<List<Integer>> ret){
        if(tmp.size() == k){
            ret.add(new ArrayList<Integer>(tmp));
            return;
        }
        for(int i = index; i <= n; i++){
            tmp.add(i);
            dfs(i + 1, tmp, ret);
            tmp.remove(new Integer(i));
        }
    }
}
