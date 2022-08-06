package com.leetcode_6th;

public class BestTimetoBuyandSellStockIV {
    int[] prices;
    int[][][] memo;
    public int maxProfit(int k, int[] prices) {
        this.prices = prices;
        memo = new int[prices.length][k + 1][2];
        return dp(0, k, 0);
    }
    public int dp(int i, int transactionsRemaining, int holding){
        if(transactionsRemaining == 0 || i == prices.length) {
            return 0;
        }
        if(memo[i][transactionsRemaining][holding] == 0){
            int doNothing = dp(i + 1, transactionsRemaining, holding) ;
            int doSomething;
            if(holding == 1){
                doSomething = prices[i] + dp(i + 1, transactionsRemaining - 1, 0);
            }else{
                doSomething = -prices[i] + dp(i + 1, transactionsRemaining , 1);
            }
            memo[i][transactionsRemaining][holding] = Math.max(doNothing, doSomething);
        }
        return memo[i][transactionsRemaining][holding];
    }
}
