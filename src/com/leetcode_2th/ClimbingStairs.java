package com.leetcode_2th;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月29日 下午9:15:07 
 *
 */
public class ClimbingStairs {
	public int climbStairs(int n) {
		if(n == 1){
			return 1;
		}else if(n == 2){
			return 2;
		}
		return climbStairs(n - 1) + climbStairs(n - 2);
    }
	/**
	 * SPACE: O(n)
	 * @date 2016年7月1日 下午3:20:32
	 * @param n
	 * @return
	 */
	public int climbStairs2(int n) {
		int[] a = new int[n + 1];
		if(n == 1){
			return 1;
		}else if(n == 2){
			return 2;
		}
		a[1] = 1;
		a[2] = 2;
		for(int i = 3; i <=n; i++) {
			a[i] = a[i -1] + a[i -2];
		}
		return a[n];
    }
	/**
	 * SPACE: O(1)
	 * @date 2016年7月1日 下午3:20:54
	 * @param n
	 * @return
	 */
	public int climbStairs3(int n) {
		int f1 = 1;
		int f2 = 2;
		if (n == 1)
			return f1;
		if (n == 2)
			return f2;
		for (int i = 3; i <= n; i++) {
			int f3 = f1 + f2;
			f1 = f2;
			f2 = f3;
		}
		return f2;
	}  
	public static void main(String[] args) {
		ClimbingStairs c = new ClimbingStairs();
		System.out.println();
	}
}
