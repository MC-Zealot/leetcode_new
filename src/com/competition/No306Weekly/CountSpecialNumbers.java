package com.competition.No306Weekly;

import java.util.HashSet;
import java.util.Set;

/**
 * 2376. 统计特殊整数
 * 如果一个正整数每一个数位都是 互不相同 的，我们称它是 特殊整数 。
 *
 * 给你一个 正 整数 n ，请你返回区间 [1, n] 之间特殊整数的数目。
 *
 * 示例 1：
 * 输入：n = 20
 * 输出：19
 * 解释：1 到 20 之间所有整数除了 11 以外都是特殊整数。所以总共有 19 个特殊整数。
 * 示例 2：
 *
 * 输入：n = 5
 * 输出：5
 * 解释：1 到 5 所有整数都是特殊整数。
 * 示例 3：
 *
 * 输入：n = 135
 * 输出：110
 * 解释：从 1 到 135 总共有 110 个整数是特殊整数。
 * 不特殊的部分数字为：22 ，114 和 131 。
 *
 * 提示：
 * 1 <= n <= 2 * 109
 */
public class CountSpecialNumbers {
    public int countSpecialNumbers2(int n) {
        int ret = n;
        for(int i = 1;i <= n; i++){
            if(isSpecial(i)){
                n--;
            }
        }
        return ret;
    }
    public boolean isSpecial(int n){
        Set<String> set = new HashSet<>();
        String str = String.valueOf(n);
        for(int i = 0; i < str.length(); i++){
            String s = String.valueOf(str.charAt(i));
            if(set.contains(s)){
                return true;
            }
            set.add(s);
        }
        return false;
    }

    public int countSpecialNumbers(int n) {
        int ret = 0;
        boolean[] flags = new boolean[10];
        for(int i = 1; i <= 9; i++){
            flags[i] = true;
            ret += dfs(i, n, flags);
            flags[i] = false;
        }
        return ret;
    }
    public int dfs(long tmp, int n, boolean[] flags){
        if(tmp > n){
            return 0;
        }
        int ret = 0;
        for(int i = 0; i < 10; i++){
            if(flags[i]){
                continue;
            }
            flags[i] = true;
            ret += dfs(tmp * 10 + i, n, flags);
            flags[i] = false;
        }
        return ret + 1;
    }


    int ret;
    public int countSpecialNumbers3(int n) {
        ret = 0;
        boolean[] flags = new boolean[10];
        for(int i = 1; i <= 9; i++){
            flags[i] = true;
            dfs2(i, n, flags);
            flags[i] = false;
        }
        return ret;
    }
    public void dfs2(long tmp, int n, boolean[] flags){
        if(tmp > n){
            return;
        }
        ret++;
        for(int i = 0; i < 10; i++){
            if(flags[i]){
                continue;
            }
            flags[i] = true;
            dfs(tmp * 10 + i, n, flags);
            flags[i] = false;
        }
    }
    public static void main(String[] args) {
        CountSpecialNumbers c = new CountSpecialNumbers();
        System.out.println(c.isSpecial(100));
    }
}
