package com.leetcode_6th.jianzhiOffer;

import java.util.*;

/**
 * 剑指 Offer 60. n个骰子的点数
 * 把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。输入n，打印出s的所有可能的值出现的概率。
 *
 * 你需要用一个浮点数数组返回答案，其中第 i 个元素代表这 n 个骰子所能掷出的点数集合中第 i 小的那个的概率。
 *
 * 示例 1:
 * 输入: 1
 * 输出: [0.16667,0.16667,0.16667,0.16667,0.16667,0.16667]
 * 示例 2:
 *
 * 输入: 2
 * 输出: [0.02778,0.05556,0.08333,0.11111,0.13889,0.16667,0.13889,0.11111,0.08333,0.05556,0.02778]
 *
 * 限制：
 * 1 <= n <= 11
 */
public class DicesProbability {
    public double[] dicesProbability2(int n) {
        List<Double> list = new ArrayList<>();
//        int end = n * 6;
        int end = n * 6;
        int newEnd ;
        if((end - n + 1 ) % 2== 0){
            newEnd = (end - (n - 1)) / 2 ;
        }else{
            newEnd = (end - (n - 1)) / 2 + 1;
        }
        for(int i = n; i <= newEnd + n - 1; i++){
            double p = getP(n, i);
             if(p != 0){
                list.add(p);
            }
        }
        List<Double> list2 =  new ArrayList<>();
        int k;
        if((end - n + 1) %2 == 0){
            //双数
            k = 0;
        }else{
            //单数
            k = 1;
        }
        for(int i = list.size() - 1 - k; i >=0; i--){
            list2.add(list.get(i));
        }
        list.addAll(list2);
        return list.stream().mapToDouble(i -> i).toArray();
    }
    int ret;
    public double getP(int n, int num){
        ret = 0;
        dfs(n, num, 0, 0);

        int fenmu = 1;
        for(int i = 0; i < n; i++){
            fenmu = fenmu * 6;
        }
//        System.out.println("n: " + n + ", num: " + num +", ret: "+ret+", p: " + ret * 1d / (fenmu));
        return ret * 1d / (fenmu);
    }

    /**
     *
     * @param n 需要n个骰子
     * @param tmp 当前骰子个数
     * @param num n个骰子需要组合的数是num
     * @param sum 当前组合的数是sum
     */
    public void dfs(int n, int num, int tmp, int sum){
        if(sum > num || tmp > n || (tmp == n && sum != num)){
            return;
        }
        if (tmp == n && sum == num) {
            ret++;
            return;
        }
        for(int i = 1; i <= 6; i++){
            if(sum + i > num || tmp + 1 > n ){
                break;
            }
            dfs(n, num, tmp + 1, sum + i);
        }
    }

    public double[] dicesProbability(int n) {
        // 动态规划空间优化【二维数组中第i层的j取决于第i-1层的前6个，所以可以压缩空间到一维数组】
        int[] dp = new int[6*n+1];  // 这里为了与数组下标对应，所以多了一列
        for(int i=1; i<=6; ++i){    // 初始化只有一个骰子的情况
            dp[i] = 1;
        }

        for(int i=2; i<=n; ++i){                    // 处理第i个骰子
            for(int j=6*i; j>=i; --j){              // 倒序处理
                dp[j] = 0;                              //首先清空上层的数据，否则会把上一次的结果加到这一次
                for(int k=1; k<=6 && j-k > 0; ++k){
                    dp[j] += dp[j-k];
                }
            }
            dp[i-1] = 0;                            // 清理残留数据
        }

        double[] res = new double[5*n+1];
        double sum = Math.pow(6,n);
        for(int i=0; i<res.length; ++i){
            res[i] = dp[i+n] / sum;
        }
        return res;
    }
    public static void main(String[] args) {
        DicesProbability dp = new DicesProbability();
        double[] ret = dp.dicesProbability(3);
        for(int i = 0; i < ret.length; i++){
            System.out.println(ret[i]);
        }
    }
}
