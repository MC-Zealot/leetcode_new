package com.leetcode_6th.jianzhiOffer;

/**
 * 剑指 Offer 53 - II. 0～n-1中缺失的数字
 * 一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字都在范围0～n-1之内。在范围0～n-1内的n个数字中有且只有一个数字不在该数组中，请找出这个数字。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [0,1,3]
 * 输出: 2
 * 示例 2:
 *
 * 输入: [0,1,2,3,4,5,6,7,9]
 * 输出: 8
 */
public class MissingNumber {
    public int missingNumber(int[] nums) {
        int n = nums.length + 1;
        for(int i = 0 ;i < n; i++){
            if(i == nums.length){
                return i;
            }
            int num = nums[i];
            if(i != num){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MissingNumber mn = new MissingNumber();
        int[] nums = {0,1,2,3,4,5,6,7,9};
        int ret = mn.missingNumber(nums);
        System.out.println(ret);
    }
}
