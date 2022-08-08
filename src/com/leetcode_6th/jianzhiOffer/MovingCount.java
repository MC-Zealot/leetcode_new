package com.leetcode_6th.jianzhiOffer;

/**
 *面试题13. 机器人的运动范围
 * 地上有一个m行n列的方格，从坐标 [0,0] 到坐标 [m-1,n-1] 。一个机器人从坐标 [0, 0] 的格子开始移动，
 * 它每次可以向左、右、上、下移动一格（不能移动到方格外），也不能进入行坐标和列坐标的数位之和大于k的格子。
 *
 * 例如，当k为18时，机器人能够进入方格 [35, 37] ，因为3+5+3+7=18。
 * 但它不能进入方格 [35, 38]，因为3+5+3+8=19。
 * 请问该机器人能够到达多少个格子？
 *
 * 示例 1：
 * 输入：m = 2, n = 3, k = 1
 * 输出：3
 *
 * 示例 2：
 * 输入：m = 3, n = 1, k = 0
 * 输出：1
 */
public class MovingCount {
    int m;
    int n;
    int k;
    int ret;
    public int numToSum(int num){
        int sum = 0;
        while(num > 0){
            int digit = num %10;
            sum += digit;
            num = num / 10;
        }
        return sum;
    }
    public int movingCount(int m, int n, int k) {
        this.m = m;
        this.n = n;
        this.k = k;
        this.ret = 0 ;
        boolean[][] flags = new boolean[m][n];
        dfs(0, 0, flags);
        return ret;
    }
    public void dfs(int i, int j, boolean[][] flags){
        if(i < 0 || i >= m || j < 0 || j >= n || flags[i][j]){
            return;
        }
        int num = numToSum(i) + numToSum(j);
        if(num > k){
            return;
        }
        ret++;
        flags[i][j] = true;
        dfs(i + 1, j, flags);//下
        dfs(i, j + 1, flags);//右
        dfs(i - 1, j, flags);//上
        dfs(i, j - 1, flags);//左
    }

    public static void main(String[] args) {
        MovingCount mc = new MovingCount();
        int ret = mc.movingCount(2,3,1);
        System.out.println(ret);
    }
}
