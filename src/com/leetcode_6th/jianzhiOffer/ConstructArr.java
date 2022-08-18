package com.leetcode_6th.jianzhiOffer;

/**
 * 剑指 Offer 66. 构建乘积数组
 * 给定一个数组 A[0,1,…,n-1]，请构建一个数组 B[0,1,…,n-1]，其中 B[i] 的值是数组 A 中除了下标 i 以外的元素的积, 即 B[i]=A[0]×A[1]×…×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 *
 * 示例:
 * 输入: [1,2,3,4,5]
 * 输出: [120,60,40,30,24]
 *
 * 提示：
 * 所有元素乘积之和不会溢出 32 位整数
 * a.length <= 100000
 */
public class ConstructArr {
    /**
     * time:O(n)
     * space:O(n)。如果left和right分别用常量遍历2次，可以优化O到(1)
     *
     * @param a
     * @return
     */
    public int[] constructArr(int[] a) {
        int[] ret = new int[a.length];
        int[] tmpAsc = new int[a.length];
        int t = 1;
        for(int i = 0;i < a.length; i++){
            t = t * a[i];
            tmpAsc[i] = t;
        }
        int[] tmpDesc = new int[a.length];
        t = 1;
        for(int i = a.length - 1; i >=0; i--){
            t = t * a[i];
            tmpDesc[i] = t;
        }
        for(int i = 0; i < ret.length; i++){
            int left;
            int right;
            if(i - 1 < 0){
                left = 1;
            }else{
                left = tmpAsc[i - 1];
            }
            if(i + 1 >= ret.length){
                right = 1;
            }else{
                right = tmpDesc[i + 1];
            }
            ret[i] = left * right;
        }
        return ret;
    }
}
