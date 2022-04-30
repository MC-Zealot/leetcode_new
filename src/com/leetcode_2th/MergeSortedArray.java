package com.leetcode_2th;
/**
 * Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.
 * 
 * @author Zealot
 * @date 2016年5月21日 下午8:18:48 
 *
 */
public class MergeSortedArray {
	/**
	 * time: O(m+n)
	 * space: O(m+n)
	 * @date 2016年5月21日 下午8:23:46
	 * @param nums1
	 * @param m
	 * @param nums2
	 * @param n
	 */
	public void merge(int[] nums1, int m, int[] nums2, int n) {
		int[] c = new int[m+n];
		for(int i = 0, j = 0, k = 0; k < m + n; k++) {
			if(i < m && j < n) {
				c[k] = nums1[i] < nums2[j] ? nums1[i++] : nums2[j++];
				continue;
			}
			if(i < m) {
				c[k] = nums1[i++];
				continue;
			}
			if(j < n) {
				c[k] = nums2[j++];
				continue;
			}
		}
		nums1 = c;
    }

	public void merge2(int A[], int m, int B[], int n) {
		if (A == null || B == null)
			return;
		int idx1 = m - 1;
		int idx2 = n - 1;
		int len = m + n - 1;
		while (idx1 >= 0 && idx2 >= 0) {
			if (A[idx1] > B[idx2]) {
				A[len--] = A[idx1--];
			} else {
				A[len--] = B[idx2--];
			}
		}
		while (idx2 >= 0) {
			A[len--] = B[idx2--];
		}
	}

	public static void main(String[] args) {
		MergeSortedArray m = new MergeSortedArray();
		int[] a = {};
		int[] b = {1};
		m.merge(a, a.length, b, b.length);
	}
}
