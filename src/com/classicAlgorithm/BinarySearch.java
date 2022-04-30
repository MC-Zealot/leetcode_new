package com.classicAlgorithm;

/**
 * 对有序数组，进行二分查找
 * 
 * @author Zealot
 * @date 2016年3月11日 下午9:50:31
 *
 */
public class BinarySearch {
	private int binarySearch(int[] array, int des) {
		int start = 0;
		int end = array.length - 1;
		while (start <= end) {
			int mid = (start + end) / 2;
			if (array[mid] == des) {
				return mid;
			} else if (array[mid] > des) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return -1;
	}
}
