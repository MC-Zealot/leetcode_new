package com.leetcode_6th.jianzhiOffer;

/**
 * 剑指 Offer 49. 丑数
 * 我们把只包含质因子 2、3 和 5 的数称作丑数（Ugly Number）。求按从小到大的顺序的第 n 个丑数。
 *
 * 示例:
 *
 * 输入: n = 10
 * 输出: 12
 * 解释: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 是前 10 个丑数。
 * 说明:
 *
 * 1 是丑数。
 * n 不超过1690。
 * 注意：本题与主站 264 题相同：https://leetcode-cn.com/problems/ugly-number-ii/
 */
public class NthUglyNumber {
    public int nthUglyNumber(int n) {
        if(n <= 6){
            return n;
        }

        int num = 7;
        int cnt = 6;
        while(cnt <= n + 1){
            int a = num / 2;
            if(a * 2 == num){
                cnt++;
                System.out.println(cnt+": "+num);
                if(cnt == n){
                    return num;
                }
                num++;

                continue;
            }
            int b = num / 3;
            if(b * 3 == num){
                cnt++;
                System.out.println(cnt+": "+num);
                if(cnt == n){
                    return num;
                }
                num++;

                continue;
            }
            int c = num / 5;
            if(c * 5 == num){
                cnt++;
                System.out.println(cnt+": "+num);
                if(cnt == n){
                    return num;
                }
                num++;
                continue;
            }
            num++;
        }
        return -1;
    }

    public int nthUglyNumber2(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        int a = 1;
        int b = 1;
        int c = 1;
        for(int i = 2; i < n + 1; i++){
            int aTmp = dp[a] * 2;
            int bTmp = dp[b] * 3;
            int cTmp = dp[c] * 5;
            int min = Math.min(cTmp, Math.min(aTmp, bTmp));
            if(min == aTmp){
                a++;
            }
            if(min == bTmp){
                b++;
            }
            if(min == cTmp){
                c++;
            }
            dp[i] = min;
        }
        return dp[n];
    }

    public static void main(String[] args) {
        NthUglyNumber nn = new NthUglyNumber();
        int ret = nn.nthUglyNumber2(10);
        System.out.println(ret);
    }
}
