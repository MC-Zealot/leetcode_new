package com.leetcode_2th;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * @author Zealot
 * @date 2016年6月6日 上午11:39:32
 *
 */
public class ContainerWithMostWater {
	public int maxArea(int[] height) {
		if (height.length <= 1) {
			return 0;
		}
		
		int i = 0, j = height.length -1;
		int res = 0;
		while(i < j){
			int hi = height[i];
			int hj = height[j];
			int area = getArea(i, j, hi, hj);
			res = Math.max(area, res);
			if(hi<hj){
				i++;
			}else{
				j--;
			}
		}
		return res;
	}
	private static int getArea(int i, int j, int hi, int hj) {
		int area = (j - i) * Math.min(hi, hj);
		return area;
	}
}
