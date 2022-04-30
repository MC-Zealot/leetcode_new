package com.leetcode_3th.others.divide_conquer;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * 在未排序的数组中找到第 k 个最大的元素。请注意，你需要找的是数组排序后的第 k 个最大的元素，而不是第 k 个不同的元素。

示例 1:

输入: [3,2,1,5,6,4] 和 k = 2
输出: 5
示例 2:

输入: [3,2,3,1,2,4,5,5,6] 和 k = 4
输出: 4
说明:

你可以假设 k 总是有效的，且 1 ≤ k ≤ 数组的长度。

 * 
 * @author Zealot
 * @date Aug 2, 2019 12:22:18 PM 
 *
 */
public class KthLargestElementinanArray {
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}
	
	/**
	 * 用小顶堆
	 * 空间复杂度O(k)
	 * @param nums
	 * @param k
	 * @return
	 * Created on: Feb 23, 2020 12:22:25 PM
	 */
	public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> p = new PriorityQueue<Integer>();
        for(int i = 0 ; i < nums.length; i++){
            p.add(nums[i]);
            if(p.size()>k) p.poll();
        }
        return p.poll();
    }
	/**
	 * avr: O(n) worst O(n^2)
	 * @date 2016年7月3日 下午11:10:46
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findKthLargest3(int[] nums, int k) {
        return quickSelect(nums, k - 1, 0, nums.length - 1);
    }
    
	/**
	 * 跟快速排序一个思路。先取一个枢纽值，将数组中小于枢纽值的放在左边，大于枢纽值的放在右边，具体方法是用左右两个指针，如果他们小于枢纽值则将他们换到对面，
	 * 
	 * 一轮过后记得将枢纽值赋回分界点。如果这个分界点是k，说明分界点的数就是第k个数。
	 * 
	 * 否则，如果分界点大于k，则在左半边做同样的搜索。如果分界点小于k，则在右半边做同样的搜索。
	 * 
	 * 时间复杂度O(n)
	 * 空间复杂度O(1)
	 * @date Aug 2, 2019 12:48:05 PM
	 * @param arr
	 * @param k
	 * @param left
	 * @param right
	 * @return
	 */
	private int quickSelect(int[] arr, int k, int left, int right) {
		int pivot = arr[(left + right) / 2];
		int orgL = left, orgR = right;
		while (left <= right) {
			// 从右向左找到第一个小于枢纽值的数
			while (arr[left] > pivot) {
				left++;
			}
			// 从左向右找到第一个大于枢纽值的数
			while (arr[right] < pivot) {
				right--;
			}
			// 将两个数互换
			if (left <= right) {
				swap(arr, left, right);
				left++;
				right--;
			}
		}
		// 最后退出的情况应该是右指针在左指针左边一格
		// 这时如果右指针还大于等于k，说明kth在左半边
		if (orgL < right && k <= right) {
			return quickSelect(arr, k, orgL, right);
		}
		// 这时如果左指针还小于等于k，说明kth在右半边
		if (left < orgR && k >= left) {
			return quickSelect(arr, k, left, orgR);
		}
			
		return arr[k];

	}
    
    private void swap(int[] arr, int idx1, int idx2){
        int tmp = arr[idx1] + arr[idx2];
        arr[idx1] = tmp - arr[idx1];
        arr[idx2] = tmp - arr[idx2];
    
    }
	public static void main(String[] args) {
		KthLargestElementinanArray k = new KthLargestElementinanArray();
		int[] nums= {3,2,3,1,2,4,5,5,6};
		System.out.println(k.findKthLargest2(nums, 4));
	}
}
