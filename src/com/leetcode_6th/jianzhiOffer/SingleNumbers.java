package com.leetcode_6th.jianzhiOffer;

import java.util.Arrays;

/**
 * 剑指 Offer 56 - I. 数组中数字出现的次数
 * 一个整型数组 nums 里除两个数字之外，其他数字都出现了两次。请写程序找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 *
 * 示例 1：
 *
 * 输入：nums = [4,1,4,6]
 * 输出：[1,6] 或 [6,1]
 * 示例 2：
 *
 * 输入：nums = [1,2,10,4,1,4,3,3]
 * 输出：[2,10] 或 [10,2]
 *
 *
 * 限制：
 *
 * 2 <= nums.length <= 10000
 */
public class SingleNumbers {
    public int[] singleNumbers(int[] nums) {
        Arrays.sort(nums);
        int[] ret = new int[2];
        int index = 0;
        for(int i = 0;i < nums.length; ){
            if(i + 1 == nums.length || nums[i] != nums[i + 1]){
                ret[index++] = nums[i++];
            }else{
                i = i+ 2;
            }
        }
        return ret;
    }
    public int[] singleNumbers2(int[] nums) {
        int x = 0, y = 0, n = 0, m = 1;
        for(int num : nums)               // 1. 遍历异或
            n ^= num;
        while((n & m) == 0)               // 2. 循环左移，计算 m
            m <<= 1;
        for(int num: nums) {              // 3. 遍历 nums 分组
            if((num & m) != 0) x ^= num;  // 4. 当 num & m != 0
            else y ^= num;                // 4. 当 num & m == 0
        }
        return new int[] {x, y};          // 5. 返回出现一次的数字
    }

    public static void main(String[] args) {
        SingleNumbers sn = new SingleNumbers();
        int[] nums = {1,1,2,5,2,4,3,4,19,19};
        int[] ret = sn.singleNumbers(nums);
        System.out.println(ret[0]);
        System.out.println(ret[1]);
    }
}
