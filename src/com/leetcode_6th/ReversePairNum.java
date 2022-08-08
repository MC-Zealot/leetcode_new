package com.leetcode_6th;

import java.util.Arrays;

/**
 * 在数组中的两个数字，如果前面一个数字大于后面的数字，则这两个数字组成一个逆序对。输入一个数组，求出这个数组中的逆序对的总数。
 *
 *  
 *
 * 示例 1:
 *
 * 输入: [7,5,6,4]
 * 输出: 5
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/shu-zu-zhong-de-ni-xu-dui-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class ReversePairNum {
    int ret;
    public int reversePairs(int[] nums) {
        int len = nums.length;
        ret = 0;
        if (len < 2) {
            return 0;
        }

        int[] copy = new int[len];
        for (int i = 0; i < len; i++) {
            copy[i] = nums[i];
        }

        int[] temp = new int[len];
        reversePairs(copy, 0, len - 1, temp);
        return ret;
    }

    private void reversePairs(int[] nums, int left, int right, int[] temp) {
        if (left == right) {
            return ;
        }

        int mid = left + (right - left) / 2;
        reversePairs(nums, left, mid, temp);
        reversePairs(nums, mid + 1, right, temp);

//        if (nums[mid] <= nums[mid + 1]) {
//            return leftPairs + rightPairs;
//        }

        mergeAndCount(nums, left, mid, right, temp);
//        return leftPairs + rightPairs + crossPairs;
    }

    private void mergeAndCount(int[] nums, int left, int mid, int right, int[] temp) {
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
        }

        int i = left;
        int j = mid + 1;

        for (int k = left; k <= right; k++) {
            if (i == mid + 1) {
                nums[k] = temp[j];
                j++;
            } else if (j == right + 1) {
                nums[k] = temp[i];
                i++;
            } else if (temp[i] <= temp[j]) {
                nums[k] = temp[i];
                i++;
            } else {
                nums[k] = temp[j];
                j++;
                ret += (mid - i + 1);
            }
        }
    }

    public static void main(String[] args) {
        ReversePairNum r = new ReversePairNum();
        int[] a = {7,5,6,4};
        int ret = r.reversePairs(a);
        System.out.println(ret);
    }
}
