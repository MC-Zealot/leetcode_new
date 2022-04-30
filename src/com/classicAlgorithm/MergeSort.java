package com.classicAlgorithm;

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

	public static void main(String[] args) {
		int[] a = {1,4,6,7,23,3,5,8,12,11};
		MergeSort ms = new MergeSort();
		ms.mergesort(a, 0, a.length - 1);
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
	}
}
