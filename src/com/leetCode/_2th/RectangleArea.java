package com.leetCode._2th;
/**
 *
 * @Description:
 * Find the total area covered by two rectilinear rectangles in a 2D plane.

Each rectangle is defined by its bottom left corner and top right corner as shown in the figure.

Rectangle Area
Assume that the total area is never beyond the maximum possible value of int.
 * @author Zealot
 * @date 2016年2月14日 上午11:32:57
 *
 */
public class RectangleArea {
	public int computeArea(int A, int B, int C, int D, int E, int F, int G, int H) {
		int area = 0;
		area = (C - A) * (D - B) + (G - E) * (H - F);
		long areaLong = Math.max((long)Math.min(G, C)-(long)Math.max(A, E), 0L);
		int areaHeight = Math.max(Math.min(H, D)-Math.max(B, F), 0);
		return area-Integer.parseInt(String.valueOf(areaLong))*areaHeight;
	}
	public static void main(String[] args) {
		int A = -1500000001;
		int B = 0;
		int C = -1500000000;
		int D = 1;
		int E = 1500000000;
		int F = 0;
		int G = 1500000001;
		int H = 1;
		RectangleArea r = new RectangleArea();
		System.out.println(r.computeArea(A, B, C, D, E, F, G, H));
	}
}
