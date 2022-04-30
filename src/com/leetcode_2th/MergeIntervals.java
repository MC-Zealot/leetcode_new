package com.leetcode_2th;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import com.leetCode.CommonStructure.Interval;

/**
 * Given a collection of intervals, merge all overlapping intervals.

For example,
Given [1,3],[2,6],[8,10],[15,18],
return [1,6],[8,10],[15,18].
 * 
 * @author Zealot
 * @date 2016年6月13日 下午12:07:22 
 *
 */
public class MergeIntervals {
	public List<Interval> merge(List<Interval> intervals) {
		List<Interval> res = new ArrayList<Interval>();
		if(intervals==null||intervals.size()==0){
			return res;
		}
		int max = Integer.MIN_VALUE;
		int min = Integer.MAX_VALUE;
		for(Interval i: intervals){
			int start = i.start;
			int end = i.end;
			if(end>max){
				max = end;
			}
			if(start<min){
				min = start;
			}
		}
		boolean[] isVisted = new boolean[max - min + 1 + 2];
		for (Interval i : intervals) {
			int start = i.start;
			int end = i.end;
			for (; start <= end; start++) {
				isVisted[start - min + 1] = true;
			}
		}
		int start = 0;
		
		for (int i = 1; i < isVisted.length; i++) {
			if (isVisted[i] == false && isVisted[i - 1] == true) {
				Interval interval = new Interval();
				interval.start = start + min - 1;
				interval.end = i - 1 + min - 1;
				res.add(interval);
			}
			if(isVisted[i] == true && isVisted[i - 1] == false){
				start = i;
			}
		}
		
		return res;
    }

	public ArrayList<Interval> merge2(ArrayList<Interval> intervals) {
		ArrayList<Interval> res = new ArrayList<Interval>();
		if (intervals == null || intervals.size() == 0)
			return intervals;
		Comparator<Interval> comp = new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				if (i1.start == i2.start)
					return i1.end - i2.end;
				return i1.start - i2.start;
			}
		};
		Collections.sort(intervals, comp);

		res.add(intervals.get(0));
		for (int i = 1; i < intervals.size(); i++) {
			if (res.get(res.size() - 1).end >= intervals.get(i).start) {
				res.get(res.size() - 1).end = Math.max(res.get(res.size() - 1).end, intervals.get(i).end);
			} else {
				res.add(intervals.get(i));
			}
		}
		return res;
	}  
	public ArrayList<Interval> merge3(ArrayList<Interval> intervals) {
	        ArrayList<Interval> res = new ArrayList<Interval>();
	        if(intervals == null || intervals.isEmpty()) return res;
	        Comparator<Interval> comparator = new Comparator<Interval>(){
	            public int compare(Interval a, Interval b){
	                if(a.start < b.start) return -1;
	                else if(a.start > b.start) return 1;
	                else {
	                    if(a.end < b.end) return -1;
	                    else if(a.end < b.end) return -1;
	                    else return 0;
	                }
	                
	            }
	        };
	       Collections.sort(intervals,comparator);
	       for(int i=0; i<intervals.size();i++){
	           Interval current = intervals.get(i);
	           if(res.isEmpty()){
	               res.add(current);
	           } else{
	               Interval last = res.get(res.size() - 1);
	                if(last.end >= current.start) {
	                    last.end = Math.max(last.end,current.end);
	                }else{
	                    res.add(current);
	                }
	                }
	               
	           }
	        return res;
	}
	public static void main(String[] args) {
//		Given [1,3],[2,6],[8,10],[15,18],
		/*Interval i = new Interval(1,3);
		Interval i2 = new Interval(2,6);
		Interval i3 = new Interval(8,10);
		Interval i4 = new Interval(15,18);
		List<Interval> l = new ArrayList<Interval>();
		l.add(i);
		
		l.add(i3);
		l.add(i2);
		l.add(i4);
		Comparator<Interval> comp = new Comparator<Interval>() {
			@Override
			public int compare(Interval i1, Interval i2) {
				if (i1.start == i2.start)
					return i1.end - i2.end;
				return i1.start - i2.start;
			}
		};
		Collections.sort(l, comp);
		for(Interval interval: l){
			System.out.println(interval);
		}*/
		
		Integer[] array = 
			{0, 0, 0, 0, 0, 0, 0, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 
			0, 0, 0, 1, 1, 0, 0, 1, 0, 1, 0, 0, 0, 0, 1, 0, 0, 1, 0, 0, 0, 2, 1, 0, 0, 0, 2, 30, 0, 3};

		Arrays.sort(array);
		System.out.println(array);
	}
}
