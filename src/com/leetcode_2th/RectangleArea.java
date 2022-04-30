package com.leetcode_2th;

import java.util.Arrays;

/**
 * Find the total area covered by two rectilinear rectangles in a 2D plane.
 * 
 * Each rectangle is defined by its bottom left corner and top right corner as
 * shown in the figure. Assume that the total area is never beyond the maximum
 * possible value of int.
 * 如果两个矩形没有重叠部分，则直接计算两个矩形面积之和就行了。如果两个矩形有重叠部分，则要将重叠部分减去。如何判断两个矩形没有重叠部分呢
 * ，如果一个矩形右上角的横坐标比另一个矩形左下角的横坐标要小
 * ，或者一个矩形右上角的纵坐标比另一个矩形左下角的纵坐标要小，则两个矩形是不重叠的。因为两个矩形的坐标都可能比对方小
 * ，所以我们一共有四种可能情况是不重叠的。如果重叠的话，计算重叠部分面积就是四个横坐标中中间那两个和四个纵坐标中间那两个。
 * 
 * @author Zealot
 * @date 2016年6月26日 下午12:07:12
 *
 */
public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G,	int H) {
		int dup = 0;
		if (C < E || G < A || D < F || H < B) {
			dup = 0;
		} else {
			int[] x = { A, C, E, G };
			int[] y = { B, D, F, H };
			Arrays.sort(x);
			Arrays.sort(y);
			dup = (x[2] - x[1]) * (y[2] - y[1]);
		}
		return (C - A) * (D - B) + (G - E) * (H - F) - dup;
	}
}
