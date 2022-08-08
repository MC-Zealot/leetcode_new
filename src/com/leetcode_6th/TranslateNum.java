package com.leetcode_6th;

import java.util.HashMap;
import java.util.Map;

public class TranslateNum {
    Map<Integer, Integer> memo = new HashMap<>();
    public int translateNum(int num) {
        int n = 0;
        int tmp = num;
        while(tmp > 0){
            n++;
            tmp = tmp / 10;
        }
        return dp(0, String.valueOf(num), n);
    }
    public int dp(int index, String num, int n){
        if(memo.containsKey(index)){
            return memo.get(index);
        }
        if(index == n){
            return 1;
        }
        if(index == n -1){
            return 1;
        }

        int ans = dp(index + 1, num, n);

        if(num.charAt(index) != '0' && Integer.parseInt(num.substring(index, index + 2)) <= 25){
            ans += dp(index + 2, num, n);
        }
        memo.put(index, ans);
        return ans;
    }

    public static void main(String[] args) {
        TranslateNum tn = new TranslateNum();
        int ret = tn.translateNum(506);
        System.out.println(ret);
    }
}
