package com.leetCode._2th;

import com.util.VersionControl;

/**
 * You are a product manager and currently leading a team to develop a new
 * product. Unfortunately, the latest version of your product fails the quality
 * check. Since each version is developed based on the previous version, all the
 * versions after a bad version are also bad.
 * 
 * Suppose you have n versions [1, 2, ..., n] and you want to find out the first
 * bad one, which causes all the following ones to be bad.
 * 
 * You are given an API bool isBadVersion(version) which will return whether
 * version is bad. Implement a function to find the first bad version. You
 * should minimize the number of calls to the API.
 * 
 * 
 * 
 * @author Zealot
 * @date 2016年4月7日 下午10:55:32
 *
 */
public class FirstBadVersion {
	public int firstBadVersion(int n) {
		// write your code here
		if (n == 1) {
			return 1;
		}

		int left = 1;
		int right = n;

		while (left + 1 < right) {
			int mid = left + (right - left) / 2;
			if (VersionControl.isBadVersion(mid)) {
				right = mid;
			} else {
				left = mid;
			}
		}

		if (VersionControl.isBadVersion(left)) {
			return left;
		}

		return right;
	}
	public static void main(String[] args) {
		String str = "hello";
		System.out.println(str.substring(0,1));
	}
}
