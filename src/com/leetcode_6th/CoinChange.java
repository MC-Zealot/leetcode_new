package com.leetcode_6th;

import java.util.Arrays;

public class CoinChange {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        for(int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for(int j = 0; j < coins.length; j++){
                int coin = coins[j];
                if(coin <= i){
                    int tmp= dp[i - coin] + 1;
                    min = Math.min(min, tmp);
                    dp[i] = min;
                }
            }

        }
        if(dp[amount] > amount){
            return -1;
        }
        return dp[amount];
    }
}
