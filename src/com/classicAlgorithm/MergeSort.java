package com.classicAlgorithm;

import java.util.Arrays;

/**
 * 归并排序
 * 
 * @author Zealot
 * @date 2016年3月21日 下午9:51:08
 *
 */
public class MergeSort {
	// 将有二个有序数列a[first...mid]和a[mid...last]合并。
	public void mergearray(int a[], int first, int mid, int last) {
		int temp[] = new int[a.length];
		int i = first, j = mid + 1;
		int m = mid, n = last;
		int k = 0;

		while (i <= m && j <= n) {
			if (a[i] <= a[j])
				temp[k++] = a[i++];
			else
				temp[k++] = a[j++];
		}

		while (i <= m){
			temp[k++] = a[i++];
		}

		while (j <= n){
			temp[k++] = a[j++];
		}

		for (i = 0; i < k; i++){
			a[first + i] = temp[i];
		}
	}

	public void mergesort(int a[], int first, int last) {
		if (first < last) {
			int mid = (first + last) / 2;
			mergesort(a, first, mid); // 左边有序
			mergesort(a, mid + 1, last); // 右边有序
			mergearray(a, first, mid, last); // 再将二个有序数列合并
		}
	}


	public int[] sortArray(int[] nums) {
		if(nums.length == 1){
			return nums;
		}
		return mergeSort(nums);
	}
	public int[] mergeSort(int[] nums){
		if(nums.length <= 1){
			return nums;
		}
		int pivot = nums.length / 2;
		int[] left = Arrays.copyOfRange(nums, 0, pivot);
		int[] right = Arrays.copyOfRange(nums, pivot, nums.length);

		int[] leftSorted = mergeSort(left);
		int[] rightSorted = mergeSort(right);

		return mergeArray(leftSorted, rightSorted);
	}
	public int[] mergeArray(int[] leftSorted, int[] rightSorted){
		int[] ret = new int[leftSorted.length + rightSorted.length];
		int leftIndex = 0;
		int rightIndex = 0;
		for(int i = 0 ;i < ret.length; i++){
			if(leftIndex == leftSorted.length){
				ret[i] = rightSorted[rightIndex++];
				continue;
			}else if(rightIndex == rightSorted.length){
				ret[i] = leftSorted[leftIndex++];
				continue;
			}
			if(leftSorted[leftIndex] <= rightSorted[rightIndex]){
				ret[i] = leftSorted[leftIndex++];
			}else{
				ret[i] = rightSorted[rightIndex++];
			}
		}
		return ret;
	}
	public static void main(String[] args) {
		int[] a = {1,4,6,7,23,3,5,8,12,11};
		int[] b = {5,1,1,2,0,0};
		MergeSort ms = new MergeSort();
		int[]ret = ms.mergeSort(a);
		for(int i = 0; i < ret.length; i++) {
			System.out.print(ret[i] + "\t");
		}
	}
}
