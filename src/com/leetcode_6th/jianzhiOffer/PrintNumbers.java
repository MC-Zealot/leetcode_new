package com.leetcode_6th.jianzhiOffer;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 17. 打印从1到最大的n位数
 * 输入数字 n，按顺序打印出从 1 到最大的 n 位十进制数。比如输入 3，则打印出 1、2、3 一直到最大的 3 位数 999。
 *
 * 示例 1:
 *
 * 输入: n = 1
 * 输出: [1,2,3,4,5,6,7,8,9]
 *
 *
 * 说明：
 *
 * 用返回一个整数列表来代替打印
 * n 为正整数
 */
public class PrintNumbers {
    public int[] printNumbers(int n) {
        if(n <= 0){
            return new int[0];
        }
        List<Integer> list = new ArrayList<>();
        for(int i = 1; numNum(i) <=n; i++){
            list.add(i);
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
    public int numNum(int n){
        int ret = 0;
        while(n > 0){
            ret++;
            n = n / 10;
        }
        return ret;
    }

    public static void main(String[] args) {
        PrintNumbers pn = new PrintNumbers();
        int n = 2;
        int[] ret = pn.printNumbers(n);
        for(int i = 0; i < ret.length; i++){
            System.out.println(ret[i]);
        }
    }
}
