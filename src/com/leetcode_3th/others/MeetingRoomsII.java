package com.leetcode_3th.others;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

import com.leetCode.CommonStructure.Interval;

/**
 * 
 * 给定一个会议时间安排的数组，每个会议时间都会包括开始和结束的时间 [[s1,e1],[s2,e2],...] (si < ei)，为避免会议冲突，
 * 
 * 同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。

示例 1:

输入: [[0, 30],[5, 10],[15, 20]]
输出: 2
示例 2:

输入: [[7,10],[2,4]]
输出: 1

 * @author Zealot
 * @date Aug 2, 2019 2:24:14 PM
 *
 */
public class MeetingRoomsII {
	public int minMeetingRooms(int[][] intervals) {
		int res = 0;
		if (intervals.length == 0) {
			return res;
		}
		int max_len = 0;
		for (int i = 0; i < intervals.length; i++) {
			if(intervals[i].length==2) {
				max_len = Math.max(max_len, intervals[i][1]);
			}
		}
		int[] flags = new int[max_len + 1];
		
		for (int i = 0; i < intervals.length; i++) {
			for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
				flags[j] += 1;
			}
		}

		for (int i = 0; i < flags.length; i++) {
			res = Math.max(res, flags[i]);
		}
		return res;
	}
	
	public static void main(String[] args) {
		
		PriorityQueue<Integer> p = new PriorityQueue<Integer>();
		StComp stComp = new StComp();
		PriorityQueue<Interval> p2 = new PriorityQueue<Interval>(10,new StComp());
		p.add(1);
		p.add(3);
		p.add(2);
//		p.add(1);
		System.out.println(p.peek());
	}
}
class StComp implements Comparator<Interval> {
    @Override
    public int compare(Interval st1, Interval st2) {
            return st1.end - st2.end;
    }
}
