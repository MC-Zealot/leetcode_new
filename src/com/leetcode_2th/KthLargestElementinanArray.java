package com.leetcode_2th;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order, 
 * not the kth distinct element.

For example,
Given [3,2,1,5,6,4] and k = 2, return 5.

Note: 
You may assume k is always valid, 1 ≤ k ≤ array's length.
 * 
 * @author Zealot
 * @date 2016年7月3日 下午10:44:14 
 *
 */
public class KthLargestElementinanArray {
	/**
	 * rumtime complexity: nlogn
	 * @date 2016年7月3日 下午10:47:23
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findKthLargest(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length-k];
	}
	
	/**
	 * nlogk
	 * @date 2016年7月3日 下午10:58:40
	 * @param nums
	 * @param k
	 * @return
	 */
	public int findKthLargest2(int[] nums, int k) {
		PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k);
		for (int i = 0; i < nums.length; i++) {
			//小鱼size
			if(queue.size()<k){
				queue.add(nums[i]);
			}else if(queue.size()==k&& queue.peek()< nums[i]){//等于size
				queue.poll();
				queue.add(nums[i]);
			}
			
		}
		return queue.poll();
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
		if (orgL < right && k <= right)
			return quickSelect(arr, k, orgL, right);
		// 这时如果左指针还小于等于k，说明kth在右半边
		if (left < orgR && k >= left)
			return quickSelect(arr, k, left, orgR);
		return arr[k];

	}
    
    private void swap(int[] arr, int idx1, int idx2){
        int tmp = arr[idx1] + arr[idx2];
        arr[idx1] = tmp - arr[idx1];
        arr[idx2] = tmp - arr[idx2];
    
    }
	public static void main(String[] args) {
		KthLargestElementinanArray k = new KthLargestElementinanArray();
		int[] a = {3,2,1,5,6,4};
		System.out.println(k.findKthLargest2(a, 3));
	}
}
