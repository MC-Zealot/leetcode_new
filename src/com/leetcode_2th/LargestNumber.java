package com.leetcode_2th;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月10日 下午1:46:58 
 *
 */
public class LargestNumber {
	public String largestNumber(int[] nums) {
		List<String> list = new ArrayList<String>();
		for(int i = 0; i < nums.length; i++) {
			list.add(String.valueOf(nums[i]));
		}
		Collections.sort(list,new Comparator<String>() {
			public int compare(String s1, String s2) {
				String leftRight = s1 + s2;
				String rightLeft = s2 + s1;
				return -leftRight.compareTo(rightLeft);

			}}
			);
		StringBuffer sb = new StringBuffer();
		for(int i = 0; i <list.size(); i++) {
			sb.append(list.get(i));
		}
		while (sb.charAt(0) == '0' && sb.length() > 1) {
			sb.deleteCharAt(0);
		}
		return sb.toString();
    }
	public static void main(String[] args) {
		int[] a = {3, 30, 34, 5, 9};
		LargestNumber l  = new LargestNumber();
		System.out.println(l.largestNumber(a));
	}
}
