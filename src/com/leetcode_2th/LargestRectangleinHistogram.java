package com.leetcode_2th;

import java.util.LinkedList;

/**
 * Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.
 * 
 * @author Zealot
 * @date 2016年6月20日 上午10:50:40 
 *
 */
public class LargestRectangleinHistogram {
	public int largestRectangleArea(int[] heights) {
		if (heights == null || heights.length == 0){
			return 0;
		}
		int max = 0;
		LinkedList<Integer> stack = new LinkedList<Integer>();
		for (int i = 0; i < heights.length; i++) {
			while (!stack.isEmpty() && heights[i] <= heights[stack.peek()]) {
				int index = stack.pop();
				int curArea = stack.isEmpty() ? i * heights[index] : (i - stack.peek() - 1) * heights[index];
				max = Math.max(max, curArea);
			}
			stack.push(i);
		}
		while (!stack.isEmpty()) {
			int index = stack.pop();
			int curArea = stack.isEmpty() ? heights.length * heights[index] : (heights.length - stack.peek() - 1) * heights[index];
			max = Math.max(max, curArea);
		}
		return max;
	}  
}
