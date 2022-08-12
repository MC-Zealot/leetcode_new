package com.leetcode_6th.jianzhiOffer;

import java.util.HashSet;
import java.util.Set;

/**
 * 剑指 Offer 61. 扑克牌中的顺子
 * 从若干副扑克牌中随机抽 5 张牌，判断是不是一个顺子，即这5张牌是不是连续的。2～10为数字本身，A为1，J为11，Q为12，K为13，而大、小王为 0 ，可以看成任意数字。A 不能视为 14。
 *
 * 示例 1:
 * 输入: [1,2,3,4,5]
 * 输出: True
 *
 * 示例 2:
 * 输入: [0,0,1,2,5]
 * 输出: True
 *
 *
 * 限制：
 * 数组长度为 5
 * 数组的数取值为 [0, 13] .
 */
public class IsStraight {
    int max;
    int min;
    int cnt = 0;
    public boolean isStraight(int[] nums) {
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        findX(nums);
        Set<Integer> set = new HashSet<>();
        int start = min;
        for(int i = 0; i < nums.length;i++){
            set.add(start++);
        }
        for(int i = 0; i < nums.length; i++){
            int num = nums[i];
            if(num == 0){
                continue;
            }
            set.remove(num);
        }
        return set.size()==cnt;
    }
    public void findX(int[] nums){
        for(int i = 0;i < nums.length; i++){
            int num = nums[i];
            if(num == 0){
                cnt++;
            }else{
                min = Math.min(min, num);
                max = Math.max(max, num);
            }
        }
    }

    public static void main(String[] args) {
        IsStraight  is = new IsStraight();
        int[] nums = {2,3,4,5,7};
        boolean ret = is.isStraight(nums);
        System.out.println(ret);
    }
}
