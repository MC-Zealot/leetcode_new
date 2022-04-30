package com.leetcode_2th;

/**
 * There are two sorted arrays nums1 and nums2 of size m and n respectively.
 * Find the median of the two sorted arrays. The overall run time complexity
 * should be O(log (m+n)).
 * 
 * @author Zealot
 * @date 2016年6月2日 下午9:48:45
 *
 */
public class MedianofTwoSortedArrays {
	public double findMedianSortedArrays(int[] nums1, int[] nums2) {
		int[] c = merge(nums1, nums2);
		int size = c.length;
		double median = 0;
		if(size % 2 == 0){
			median = (c[size/2 - 1] + c[size/2]) /2.0;
		}else{
			median = (double)c[size/2];
		}
		return median;
    }
	private int[] merge(int[] a, int[] b) {
		int m = a.length, n = b.length;
		int i = m -1, j = n -1, k = m + n - 1;
		int[] c = new int[m + n];
		while(i >= 0 && j >= 0) {
			c[k--] = a[i] > b[j] ? a[i--] : b[j--];
		}
		while(i >= 0) {
			c[k--] = a[i--];
		}
		while(j >= 0) {
			c[k--] = b[j--];
		}
		return c;
	}
	public static void main(String[] args) {
		
	}
}
