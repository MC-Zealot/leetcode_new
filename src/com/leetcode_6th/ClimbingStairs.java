package com.leetcode_6th;

public class ClimbingStairs {
    int[] cache;
    public int climbStairs(int n) {
        if(n <= 2){
            return n;
        }
        cache = new int[n + 1];
        cache[1] = 1;
        cache[2] = 2;
        return helper(n);
    }
    public int helper(int n){
        if(n <= 2){
            return n;
        }
        int ret = 0;
        if(cache[n] == 0){
            ret = helper(n - 1) + helper(n - 2);
            cache[n] = ret;
        }
        return cache[n];
    }
}
