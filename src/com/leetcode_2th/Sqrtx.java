package com.leetcode_2th;

/**
 * Implement int sqrt(int x).
 * 
 * Compute and return the square root of x.
 * 
 * @author Zealot
 * @date 2016年6月11日 上午11:36:49
 *
 */
public class Sqrtx {
	public int sqrt(int x) {
		if (x < 0)
			return -1;
		if (x == 0)
			return 0;
		int l = 1;
		int r = x / 2 + 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (m <= x / m && x / (m + 1) < m + 1)
				return m;
			if (x / m < m) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return 0;
	}

	public int sqrt2(int x) {
		if (x < 0)
			return -1;
		if (x == 0)
			return 0;
		int l = 1;
		int r = x / 2 + 1;
		while (l <= r) {
			int m = (l + r) / 2;
			if (m == x / m)
				return m;
			if (x / m < m) {
				r = m - 1;
			} else {
				l = m + 1;
			}
		}
		return r;
	}  
	
	public int sqrt3(int x) {
		for(int i = 0; i * i <= x; i++) {
			if(i * i == x){
				return i;
			}
		}
		return -1;
	}
	
	
	
	
	
	
	
	
	public static void main(String[] args) {
		Sqrtx s =  new Sqrtx();
		System.out.println(s.sqrt3(16));
	}
}
