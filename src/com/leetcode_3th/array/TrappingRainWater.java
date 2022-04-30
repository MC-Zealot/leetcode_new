package com.leetcode_3th.array;

import java.util.Arrays;

/**
 * 我们先来看一种方法，这种方法是基于动态规划Dynamic Programming的，
 * 我们维护一个一维的dp数组，这个DP算法需要遍历两遍数组，第一遍遍历dp[i]中存入i位置左边的最大值，然后开始第二遍遍历数组，
 * 第二次遍历时找右边最大值，然后和左边最大值比较取其中的较小值，然后跟当前值A[i]相比，如果大于当前值，则将差值存入结果，代码如下：
 * 
 * @author Zealot
 * @date Jul 18, 2019 3:44:48 PM
 *
 */
public class TrappingRainWater {
	public int trap(int[] height) {
		if (height == null || height.length == 0)
			return 0;
		int max = 0;
		int min = 0;
		int res = 0;
		int[] container = new int[height.length];
		for (int i = 0; i < height.length; i++) {// 从目前为止最高的，放到新的数组container中
			container[i] = max;
			max = Math.max(max, height[i]);// 并且找到最大的
		}
		for (int i = height.length - 1; i >= 0; i--) {
			container[i] = Math.min(min, container[i]);// container到目前为止最小的
			min = Math.max(min, height[i]);
			res += container[i] - height[i] > 0 ? container[i] - height[i] : 0;
		}
		return res;
	}

	/**
	 * 最后我们来看一种只需要遍历一次即可的解法，这个算法需要left和right两个指针分别指向数组的首尾位置，从两边向中间扫描，
	 * 在当前两指针确定的范围内，先比较两头找出较小值，如果较小值是left指向的值，则从左向右扫描，如果较小值是right指向的值，
	 * 则从右向左扫描，若遇到的值比当较小值小，则将差值存入结果，如遇到的值大，则重新确定新的窗口范围，以此类推直至left和right指针重合，
	 * 具体参见代码如下：
	 * 
	 * 
	 * @date Jul 18, 2019 3:49:49 PM
	 * @param height
	 * @return
	 */
	int trap2(int[] height) {
		int res = 0, l = 0, r = height.length - 1;
		while (l < r) {
			int min = Math.min(height[l], height[r]);
			if (min == height[l]) {
				++l;
				while (l < r && height[l] < min) {
					res += min - height[l++];
				}
			} else {
				--r;
				while (l < r && height[r] < min) {
					res += min - height[r--];
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		TrappingRainWater trw = new TrappingRainWater();
		int[] height = { 0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1 };
		System.out.println(trw.trap(height));
	}
}
