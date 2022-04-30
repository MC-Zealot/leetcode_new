package com.leetcode_2th;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].
是旋转数组。把数组想成一个圆环，可以无限次旋转。对k取模，多余转的圈，就可以省去了
 * 
 * @author Zealot
 * @date 2016年6月7日 上午11:21:21 
 *
 */
public class RotateArray {
    public void rotate(int[] nums, int k) {
    	k = k % nums.length;
        Queue<Integer> q = new LinkedList<Integer>();
        for(int i = nums.length - k; i < nums.length; i++) {
        	q.offer( nums[i]);
        }
        for(int i =  nums.length - k - 1, j = nums.length - 1; i >=0; i--, j--) {
        	nums[j] = nums[i];
        }
        for(int i = 0; i < k; i++) {
        	nums[i] = q.poll();
        }
        for(int i =0; i < nums.length; i++) {
        	System.out.print(nums[i]+"\t");
        }
    }
    public static void main(String[] args) {
    	RotateArray r = new RotateArray();
    	int[] a ={1,2,3,4,5,6,7};
    	int k = 3;
    	r.rotate(a, k);
	}
}
