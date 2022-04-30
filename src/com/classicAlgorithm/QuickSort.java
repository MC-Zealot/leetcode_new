package com.classicAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class QuickSort {
	static int[] a = {3,1,6,2};
	private int adjustArray( int i, int j) {
		print_array(a);
		int x = a[i];
		while(i < j){
			while(i < j && x <= a[j]){
				j--;
			}
			if(i < j) {
				a[i] = a[j];
				i++;
			}
			while(i < j && x > a[i]) {
				i++;
			}
			if(i < j) {
				a[j] = a[i];
				j--;
			}
		}
		a[i] = x;
		return i;
	}
	private void quickSort(int l, int r) {
		if(l < r) {
			int i = adjustArray( l, r);
			quickSort(l, i);
			quickSort(i + 1, r);
		}
	}

	void quick_sort(int s[], int l, int r) {
		print_array(a);
		if (l < r) {
			// Swap(s[l], s[(l + r) / 2]); //将中间的这个数和第一个数交换 参见注1
			int i = l, j = r, x = s[l];
			while (i < j) {
				while (i < j && s[j] >= x)
					// 从右向左找第一个小于x的数
					j--;
				if (i < j)
					s[i++] = s[j];

				while (i < j && s[i] < x)
					// 从左向右找第一个大于等于x的数
					i++;
				if (i < j)
					s[j--] = s[i];
			}
			s[i] = x;
			quick_sort(s, l, i - 1); // 递归调用
			quick_sort(s, i + 1, r);
			
		}
	}
	
	private int adjustArray2(int i, int j) {
		int x = a[i];
		while (i < j) {
			while (i < j && x <= a[j]) {
				j--;
			}
			if (i < j) {
				a[i] = a[j];
				i++;
			}
			while (i < j && x > a[i]) {
				i++;
			}
			if (i < j) {
				a[j] = a[i];
				j--;
			}
		}
		a[i] = x;
		return i;
	}

	private void quickSort2(int l, int r) {
		if(l<r) {
			int i = adjustArray2(l, r);
			adjustArray2(l, i);
			adjustArray2(i + 1, r);
		}
	}
	
	public static void main(String[] args) {
		QuickSort q = new QuickSort();
		q.qs(0, a.length - 1);
//		q.quick_sort(a, 0, a.length - 1);
		print_array(a);
		List list = new ArrayList();
		list.addAll(new ArrayList());
	}
	private static void print_array(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	private int adjustArra(int i, int j) {
		int x=a[i];
		while(i < j) {
			while(i < j && x <= a[j]) {
				j--;
			}
			if(i < j) {
				a[i] = a[j];
				i++;
			}
			while(i < j && x > a[i]) {
				i++;
			}
			if(i < j) {
				a[j]=a[i];
				j--;
			}
			
		}
		a[i] = x;
		return i;
	}
	/**
	 *  1、从数列中挑出一个元素，称为"基准"（pivot）。
	 	2、重新排序数列，所有比基准值小的元素摆放在基准前面，所有比基准值大的元素摆在基准后面（相同的数可以到任何一边）。在这个分区结束之后，该基准就处于数列的中间位置。这个称为分区（partition）操作。
		3、递归地（recursively）把小于基准值元素的子数列和大于基准值元素的子数列排序。
	 * @param l
	 * @param r
	 * Created on: Feb 18, 2020 12:20:59 PM
	 */
	private void qs(int l, int r) {
		if(l < r) {
			int i = adjustArra(l, r);
			qs(l, i);
			qs(i+1, r);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
