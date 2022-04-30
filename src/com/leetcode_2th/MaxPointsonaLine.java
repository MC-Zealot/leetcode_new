package com.leetcode_2th;

import com.leetCode.CommonStructure.Point;

/**
 * Given n points on a 2D plane, find the maximum number of points that lie on
 * the same straight line.
 * 
 * @author Zealot
 * @date 2016年6月4日 下午3:47:46
 *
 */
public class MaxPointsonaLine {
	public int maxPoints(Point[] points) {
		if (points == null || points.length == 0) {
			return 0;
		}
		if (allSamePoints(points))
			return points.length;
		int max = 0;
		for (int i = 0; i < points.length - 1; i++) {
			for (int j = i + 1; j < points.length; j++) {
				if (points[j].y == points[i].y && points[j].x == points[i].x)
					continue;
				int cur = 2;
				for (int k = 0; k < points.length; k++) {
					if (k != i && k != j && (points[k].y - points[i].y) * (points[j].x - points[i].x) == (points[j].y - points[i].y) * (points[k].x - points[i].x)){
						cur++;
					}
				}
				max = Math.max(max, cur);
			}
		}
		return max;
	}

	private boolean allSamePoints(Point[] points) {
		for (int i = 1; i < points.length; i++) {
			if (points[0].y != points[i].y || points[0].x != points[i].x)
				return false;
		}
		return true;
	}
}
