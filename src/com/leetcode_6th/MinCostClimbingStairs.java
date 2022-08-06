package com.leetcode_6th;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] newCost = new int[cost.length + 1];
        for(int i = 0; i < cost.length; i++){
            newCost[i] = cost[i];
        }
        int memo0 = cost[0];
        if(cost.length <= 1){
            return 0;
        }
        int memo1 = cost[1];
        for(int i = 2; i < newCost.length ; i++){
            // memo[i] = newCost[i] + Math.min(memo[i - 1], memo[i - 2]);
            int memoTmp = newCost[i] + Math.min(memo0, memo1);
            memo0 = memo1;
            memo1 = memoTmp;
        }
        return memo1;
    }
}
