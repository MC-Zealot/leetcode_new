package com.hackerrank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年7月9日 下午3:16:59 
 *
 */
public class MinimumDistances {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int n = in.nextInt();
		int nums[] = new int[n];
		for (int i = 0; i < n; i++) {
			nums[i] = in.nextInt();
		}
		Map<Integer, List<Integer>> map = new HashMap<Integer, List<Integer>>();
		for(int i = 0; i < n; i++) {
			if(!map.containsKey(nums[i])){
				List<Integer> list = new ArrayList<Integer>();
				list.add(i);
				map.put(nums[i], list);
			}else{
				map.get(nums[i]).add(i);
			}
		}
		int res = Integer.MAX_VALUE;
		boolean flag = true;
		for(Integer num: map.keySet()){
			List<Integer> list = map.get(num);
			if(list.size()>1){
				for(int i = 0; i < list.size(); i++) {
					for(int j = i + 1; j < list.size(); j++) {
						int tmp = Math.abs(list.get(i) - list.get(j));
						res = tmp < res? tmp : res;
						flag = false;
					}
				}
			}
		}
		if(flag ==true){
			System.out.println(-1);
		}else{
			System.out.println(res);
		}
		in.close();
	}
}	
