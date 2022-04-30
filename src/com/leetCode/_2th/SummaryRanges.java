package com.leetCode._2th;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a sorted integer array without duplicates, return the summary of its ranges.

For example, given [0,1,2,4,5,7], return ["0->2","4->5","7"].
 * 
 * @author Zealot
 * @date 2016年4月6日 下午9:31:55 
 *
 */
public class SummaryRanges {
	public List<String> summaryRanges(int[] nums) {
		List<String> res = new ArrayList<String>();
		if(nums.length==0){
			return res;
		}
		List<List<String>> ll = new ArrayList<List<String>>();
		int i = 0;
		while(i < nums.length){
			List<String> l1 = new ArrayList<String>();
			l1.add(String.valueOf(nums[i]));
			boolean flag = true;
			while(i+1 < nums.length && nums[i]+1 ==nums[i+1]){
				i++;
				flag = false;
			}
			if(flag){
				i++;
				ll.add(l1);
				continue;
			}else{
				l1.add(String.valueOf(nums[i]));
				i++;
			}
			
			ll.add(l1);
		}
		for(List<String> _l: ll){
			if(_l.size()==1){
				res.add(_l.get(0));
			}else{
				res.add(_l.get(0)+"->"+_l.get(1));
			}
		}
		return res;
    }
	public static void main(String[] args) {
		SummaryRanges s = new SummaryRanges();
		int[] a = {0,1,2,4,5,7};
		List<String> list = s.summaryRanges(a);
		for(String str: list) {
			System.out.println(str);
		}
	}
}
