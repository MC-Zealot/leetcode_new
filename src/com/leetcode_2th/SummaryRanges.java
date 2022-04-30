package com.leetcode_2th;

import java.util.ArrayList;
import java.util.List;
/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * 
 * @author Zealot
 * @date 2016年6月15日 下午2:59:58 
 *
 */
public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
		if(nums.length==0){
			return res;
		}
		int start = 0;
		for(int i = 0; i < nums.length; i++) {
			if(i+1==nums.length){
				String str = makeString(start, i, nums);
				res.add(str);
			}else if(nums[i]+1==nums[i+1]){
				continue;
			}else{
				String str = makeString(start, i, nums);
				res.add(str);
				start = i+1;
			}
		}
		
		return res;
    }
	private String makeString(int start, int end, int[] nums){
		if(start == end){
			return String.valueOf(nums[start]);
		}else{
			return nums[start]+"->"+nums[end];
		}
	}
	public static void main(String[] args) {
		SummaryRanges sr = new SummaryRanges();
		int[] nums = {1,2,3,4,5,7,8,9,10,11,22,33,44,55};
		List<String> res = sr.summaryRanges(nums);
		for(String str: res){
			System.out.println(str);
		}
	}
}
