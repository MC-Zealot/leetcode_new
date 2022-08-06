package com.leetcode_6th;

public class BestTimetoBuyandSellStockwithCooldown {
    int[][][] memo;
    int[] prices;
    public int maxProfit(int[] prices) {
        this.prices = prices;
        memo = new int[prices.length][2][2];
        return dp(0, 0, 0);
    }
    public int dp(int i, int holding, int cooldown) {
        if(i == prices.length){
            return 0;
        }
        if(memo[i][holding][cooldown] == 0){
            int doNothing = dp(i + 1, holding, 0);
            int doSomething;
            if(holding==1){
                doSomething = prices[i] + dp(i + 1, 0, 1) ;
            }else{
                if(cooldown==0){
                    doSomething = -prices[i] + dp(i + 1, 1, 0);
                }else{
                    doSomething = doNothing;
                }
            }
            memo[i][holding][cooldown] = Math.max(doNothing, doSomething);
        }
        return memo[i][holding][cooldown];
    }
}
