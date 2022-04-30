package com.leetcode_3th.array;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * 给出一个区间的集合，请合并所有重叠的区间。

示例 1:

输入: [[1,3],[2,6],[8,10],[15,18]]
输出: [[1,6],[8,10],[15,18]]
解释: 区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
示例 2:

输入: [[1,4],[4,5]]
输出: [[1,5]]
解释: 区间 [1,4] 和 [4,5] 可被视为重叠区间。

 * 
 * @author Zealot
 * @date Jul 19, 2019 1:13:50 PM 
 *
 */
public class MergeIntervals {
	public class Interval{
		public Interval() {}
		int start;
		int end;
	}
	public int[][] merge(int[][] intervals) {
		if(intervals.length==0) {
			return new int[0][0];
		}
		List<Interval> list =new ArrayList<Interval>();
		List<Interval> res =new ArrayList<Interval>();
		for(int i = 0; i < intervals.length; i++) {
			Interval interval = new Interval();
			interval.start=intervals[i][0];
			interval.end=intervals[i][1];
			list.add(interval);
		}
		Comparator<Interval> comp = new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				if (i1.start == i2.start)
					return i1.end - i2.end;
				return i1.start - i2.start;
			}
		};
		//先排序
		Collections.sort(list,comp);
		//再合并
		res.add(list.get(0));
		for(int i= 1; i< list.size(); i++) {
			//如果结果与数组相邻2点有交集，则合并
			if(res.get(res.size()-1).end>=list.get(i).start) {
				res.get(res.size()-1).end=Math.max(list.get(i).end, res.get(res.size()-1).end);
			}else {
				res.add(list.get(i));
			}
		}
		
		
		int[][]	res_final = new int[res.size()][2];
		for(int i = 0; i < res.size(); i++) {
			res_final[i][0]=res.get(i).start;
			res_final[i][1]=res.get(i).end;
		}
		return res_final;
	}
}
