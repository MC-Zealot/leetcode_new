package com.leetcode_2th;

import java.util.HashSet;
import java.util.Iterator;

/**
 * Given an unsorted array of integers, find the length of the longest consecutive elements sequence.

For example,
Given [100, 4, 200, 1, 3, 2],
The longest consecutive elements sequence is [1, 2, 3, 4]. Return its length: 4.

Your algorithm should run in O(n) complexity.
 * 
 * @author Zealot
 * @date 2016年6月17日 下午6:30:23 
 *
 */
public class LongestConsecutiveSequence {
	public int longestConsecutive(int[] num) {
		if (num == null || num.length == 0)
			return 0;
		HashSet<Integer> set = new HashSet<Integer>();
		int res = 1;
		for (int i = 0; i < num.length; i++) {
			set.add(num[i]);
		}
		while (!set.isEmpty()) {
			Iterator iter = set.iterator();
			int item = (Integer) iter.next();
			set.remove(item);
			int len = 1;
			int i = item - 1;
			while (set.contains(i)) {
				set.remove(i--);
				len++;
			}
			i = item + 1;
			while (set.contains(i)) {
				set.remove(i++);
				len++;
			}
			if (len > res)
				res = len;
		}
		return res;
	} 
}
