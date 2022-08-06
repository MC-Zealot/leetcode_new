package com.leetcode_6th;

public class FibonacciNumber {
    int[] cache;
    public int fib(int n) {
        if(n <=1){
            return n;
        }
        cache = new int[n + 1];
        cache[1] = 1;
        return helper(n);
    }
    public int helper(int n){
        if(n <=1){
            return n;
        }
        if(cache[n] != 0){
            return cache[n];
        }
        int ret = helper(n - 1) + helper(n - 2);
        cache[n] = ret;
        return ret;
    }
}
