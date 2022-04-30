package com.leetCode._2th;

import java.text.DecimalFormat;

/**
 * Implement int sqrt(int x).

 Compute and return the square root of x.
 *
 * @author Zealot
 * @date 2016年3月5日 下午3:53:24
 *
 */
public class Sqrtx {
	/**
	 * WA
	 * @date 2016年6月11日 上午11:52:30
	 * @param x
	 * @return
	 */
	@Deprecated
	public int mySqrt(int x) {
		if(x<=0){
			return 0;
		}
		int i  = 1;
		for(; i*i<=x;){
			i++;
		}
		return --i;
	}

	public int mySqrt2(int x) {
		if (x == 0){
			return 0;
		}
		int left = 1, right = x/2+1;
		while (true) {
			int mid = left + (right - left)/2;
			if (mid > x/mid) {
				right = mid - 1;
			} else {
				if (mid + 1 > x/(mid + 1))
					return mid;
				left = mid + 1;
			}
		}
	}
	public static void main(String[] args) {
//		Sqrtx x = new Sqrtx();
//		System.out.println(x.mySqrt(2));
//		for(int i=2;i<1000;i++){
//			int sum=0;
//			//查找因数
//			for (int j = 1; j < i; j++) {
//				if (i % j == 0) {
//					sum += j;
//				}
//				if (sum == i)
//					System.out.println(i);
//			}
//		}
//		String[] s;
//		s.length
		DecimalFormat df = new DecimalFormat("0");   
	}
}
