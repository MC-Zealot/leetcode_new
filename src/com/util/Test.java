package com.util;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * 测试常见的面试题
 * @author zealot
 * Created on: Feb 17, 2020 9:49:40 PM
 */
public class Test {

	/**
	 * 二分查找, 输入有序数组，
	 * 如果找到，返回序号，如果没找到，返回-1
	 * @param a
	 * @param target
	 * @return
	 * Created on: Feb 17, 2020 9:50:35 PM
	 */
	private int binarySearch(int[] a, int target) {
		int ret = -1;
		Arrays.sort(a);
		int l = 0, r = a.length - 1;

		while (l <= r) {
			int mid = (l + r) / 2;
			if (a[mid] == target) {
				return mid;
			} else if (target > a[mid]) {
				l = mid + 1;
			} else {
				r = mid - 1;
			}
		}
		return ret;
	}
	
//	static int[] a = { 1, 5, 4, 2 ,3};
	static int[] a = { 1, 4, 2 ,0,0,1,3};

	private int adjustArray(int l, int r) {
		int x = a[l];
		while (l < r) {
			while (l < r && x <= a[r]) {
				r--;
			}
			if (l < r) {
				a[l] = a[r];
				l++;
			}
			while(l < r && x > a[l]) {
				l++;
			}
			if(l < r) {
				a[r]=a[l];
				r--;
			}
			
		}
		a[l]=x;
		return l;
	}

	/**
	 * 快排
	 * 外部：找到中间点，分割点左边快排，分割点右边快排
	 * 调整数组，返回中间的点，在数组中使中间点左边小于中间点，中间点右边大于中间点
	 * @param a
	 * @return
	 */
	private void quickSort(int l, int r) {
		if(l < r) {
			int i = adjustArray(l, r);
			quickSort(l, i);
			quickSort(i + 1, r);
		}
	}
	
	private static void print_array(int[] a) {
		for(int i = 0; i < a.length; i++) {
			System.out.print(a[i] + " ");
		}
		System.out.println();
	}
	
	
	
	
	
	
	public void quick_sort(int l, int r){
		if(l < r) {
			int i = adjust_array(l,r);
			quick_sort(l, i);
			quick_sort(i+1, r);
		}
	}
	
	
	private int adjust_array(int l, int r) {
		int x = a[l];
		while(l < r) {
			while(l < r && x <= a[r]) {
				r--;
			}
			if(l<r) {
				a[l] = a[r];
				l++;
			}
			while(l < r && x > a[l]) {
				l++;
			}
			if(l < r) {
				a[r] = a[l];
				r--;
			}
		}
		a[l]=x;
		return l;
	}
	
	
	public String addStrings(String num1, String num2) {
		
		StringBuffer ret = new StringBuffer();
		if(num1==null || num2==null) {
			return ret.toString();
		}
        int i = num1.length() - 1;
        int j = num2.length() - 1;
        int flag = 0;
		while (i >= 0 && j >= 0) {
			int a = num1.charAt(i) - '0';
			int b = num2.charAt(j) - '0';
			int x = a + b + flag;
			if (x >= 10) {
				flag = 1;
				x = x - 10;
			}else {
				flag=0;
			}
			ret.append(x);
			i--;
			j--;
		}
		while(i>=0) {
			int a = num1.charAt(i) - '0';
			int x = a + flag;
			if(x>=10) {
				flag=1;
				x=x-10;
			}else {
				flag=0;
			}
			ret.append(x);
			i--;
		}
		while(j>=0) {
			int b = num2.charAt(j) - '0';
			int x = b + flag;
			if(x>=10) {
				flag=1;
				x=x-10;
			}else {
				flag=0;
			}
			ret.append(x);
			j--;
		}
		if(flag>0) {
			ret.append(flag);
		}
		
		return ret.reverse().toString();
    }

	public String addString(String num1, String num2) {
		StringBuffer ret = new StringBuffer();
		int i = num1.length() - 1;
		int j = num2.length() - 1;
		int flag = 0;
		while(i >=0 && j >=0) {
			int a = num1.charAt(i) - '0';
			int b = num2.charAt(j) - '0';
			int x = a + b + flag;
			if(x >= 10) {
				x = x - 10;
				flag = 1;
			}else {
				flag =0;
			}
			ret.append(x);
			i--;
			j--;
		}
		while(i >=0) {
			int a = num1.charAt(i) - '0';
			int x = a + flag;
			if(x >=10) {
				x=x-10;
				flag=1;
			}else {
				flag=0;
			}
			ret.append(x);
			i--;
		}
		while(j >= 0) {
			int b = num2.charAt(i) - '0';
			int x = b + flag;
			if(x >= 10) {
				x = x- 10;
				flag = 1;
			}else {
				flag = 0;
			}
			ret.append(x);
			j--;
		}
		if(flag>0) {
			
		}
		
		return ret.reverse().toString();
	}
	
	public int[] twoSum(int[] nums, int target) {
		int[] ret= {-1,-1};
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int i = 0; i < nums.length; i++) {
			int a = nums[i];
			if(map.containsKey(target - a)) {
				ret[0] = map.get(target-a);
				ret[1] = i;
				return ret;
			}
			map.put(nums[i],i);
		}
		
		return ret;
    }
	
	
	
	public int adjustarray(int l, int r) {
		int x = a[l];
		while (l < r) {
			while (l < r && x <= a[r]) {
				r--;
			}
			if(l < r) {//停下来的时候，如果还是l<r，那么a[r]就会大于x
				a[l] = a[r];
				l++;
			}
			while(l < r && x > a[l]) {
				l++;
			}
			if(l < r) {
				a[r] = a[l];
				r--;
			}
		}
		a[l]=x;
		
		return l;
	}
	
	
	public void qs(int l, int r) {
		if(l < r) {
			int i = adjustarray(l,r);
			qs(l, i);
			qs(i+1, r);
		}
	}
	
	
	
	
	/**
	 * 
	 * @param l
	 * @param r
	 * Created on: Feb 28, 2020 1:12:42 AM
	 */
	public void qs2(int l, int r) {
		if (l < r) {
			int i = adjustArray2(l, r);
			qs(l, i);
			qs(i + 1, r);
		}
	}

	public int adjustArray2(int l, int r) {
		int x = a[l];
		while (l < r) {
			while (l < r && x <= a[r]) {
				r--;
			}
			if (l < r) {
				a[l] = a[r];
				l++;
			}
			while (l < r && x > a[l]) {
				l++;
			}
			if (l < r) {
				a[r] = a[l];
				r--;
			}
			a[l] = x;
		}
		return l;
	}
	
	public static void main(String[] args) {
		print_array(a);
		Test t = new Test();
		t.qs2(0, a.length-1);
		String s ="13";
		
		print_array(a);
//		String ret = t.addStrings("6", "501");
//		System.out.println(ret);
	}
}
