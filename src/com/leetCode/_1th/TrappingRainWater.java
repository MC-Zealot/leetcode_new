package com.leetCode._1th;

/**
 * Given n non-negative integers representing an elevation map where the width
 * of each bar is 1, compute how much water it is able to trap after raining.
 * 
 * For example, Given [0,1,0,2,1,0,1,3,2,1,2,1], return 6.
 * 
 * @author Zealot
 * @date 2015年9月14日 下午8:07:23
 */
public class TrappingRainWater {
	public int trap(int[] height) {
		int max = 0;
		for (int i = 0; i < height.length; i++) {
			if (max < height[i]) {
				max = height[i];
			}
		}
		// 创建矩阵
		int[][] a = new int[max][height.length];
		for (int row = max - 1; row >= 0; row--) {// 从下往上
			for (int col = 0; col < height.length; col++) {
				if (height[col] != 0) {
					a[row][col] = 1;
					height[col] = height[col] - 1;
				}
			}
		}
		int water = 0;
		int left = -1;
		for (int row = 0; row < max; row++) {// 从下往上
			left = -1;
			for (int col = 0; col < height.length; col++) {
//				System.out.print(a[row][col]);
				if (a[row][col] == 1) {
					if (left == -1) {
						left = col;
					}else {
//						System.out.print(col - left - 1);
						water += (col - left - 1);
						left = col;
					}
				}
			}
//			System.out.println();
		}
		return water;
	}

	public static void main(String[] args) {
		TrappingRainWater t = new TrappingRainWater();
		int[] a = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(t.trap(a));
	}
}
