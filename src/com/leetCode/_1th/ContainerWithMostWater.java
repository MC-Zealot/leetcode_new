package com.leetCode._1th;

/**
 * Given n non-negative integers a1, a2, ..., an, where each represents a point
 * at coordinate (i, ai). n vertical lines are drawn such that the two endpoints
 * of line i is at (i, ai) and (i, 0). Find two lines, which together with
 * x-axis forms a container, such that the container contains the most water.
 * 
 * Note: You may not slant the container.
 * 
 * @author Zealot
 * @date 2015年8月29日 下午1:18:34
 */
public class ContainerWithMostWater {
	int max = 0;
	public int maxArea(int[] height) {
		if(height.length==0||height.length==1) {
			return 0;
		}
		for(int i = 0; i < height.length-1; i++){
			for(int j = i+1; j < height.length; j++) {
				int area = calArea(i, j, height[i], height[j]);
				if(area > max){
					max = area;
				}
			}
		}
		return max;
	}
	//计算容积
	private int calArea(int x1,int x2, int y1, int y2) {
		int len = x2 - x1;
		int height = Math.min(y1, y2);
		int area = len * height;
		return area>0?area:-area;
	}
	public int maxArea2(int[] height) {
		int maxArea = 0;
		int lp = 0;
		int rp = height.length - 1;
		while (lp < rp) {
			maxArea = Math.max(maxArea, Math.min(height[lp], height[rp]) * (rp - lp));
			if (height[lp] < height[rp]) {
				lp++;
			} else {
				rp--;
			}
		}
		return maxArea;
	}
	public static void main(String[] args) {
		ContainerWithMostWater c = new ContainerWithMostWater();
		System.out.println(c.calArea(0, 1, 1, 2));
	}
}
