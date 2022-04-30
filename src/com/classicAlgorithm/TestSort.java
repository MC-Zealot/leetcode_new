package com.classicAlgorithm;

import java.util.ArrayList;
import java.util.List;

public class TestSort {
	static int[] a = {3,1,6,2};
	private int adjustArray( int i, int j) {
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
	public static void main(String[] args) {
		TestSort q = new TestSort();
		
//		q.quickSort(0, a.length - 1);
		q.quick_sort(a, 0, a.length - 1);
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + "\t");
		}
		List list = new ArrayList();
		list.addAll(new ArrayList());
	}
}
