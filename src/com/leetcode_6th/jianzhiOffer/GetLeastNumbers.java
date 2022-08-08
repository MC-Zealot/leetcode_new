package com.leetcode_6th.jianzhiOffer;

import java.util.PriorityQueue;

/**
 * 剑指 Offer 40. 最小的k个数
 * 输入整数数组 arr ，找出其中最小的 k 个数。例如，输入4、5、1、6、2、7、3、8这8个数字，则最小的4个数字是1、2、3、4。
 *
 *
 *
 * 示例 1：
 *
 * 输入：arr = [3,2,1], k = 2
 * 输出：[1,2] 或者 [2,1]
 * 示例 2：
 *
 * 输入：arr = [0,1,2,1], k = 1
 * 输出：[0]
 *
 *
 * 限制：
 *
 * 0 <= k <= arr.length <= 10000
 * 0 <= arr[i] <= 10000
 */
public class GetLeastNumbers {
    public int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0){
            return new int[0];
        }
        PriorityQueue pq = new PriorityQueue(k);
        for(int i = 0; i < arr.length; i++){
            pq.add(arr[i]);
        }
        int[] ret = new int[k];
        k = arr.length < k? arr.length:k;
        for(int i = 0 ;i < k; i++){
            int tmp = (int)pq.poll();
            ret[i] = tmp;
        }
        return ret;
    }

    public static void main(String[] args) {
        GetLeastNumbers g = new GetLeastNumbers();
        int[] arr = {0,1,2,1};
        int k = 1;
        int[] ret = g.getLeastNumbers(arr, k);
        System.out.println(ret);
    }
}
