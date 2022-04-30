package com.leetcode_2th;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Design and implement a TwoSum class. It should support the following operations: add and find.

add - Add the number to an internal data structure.
find - Find if there exists any pair of numbers which sum is equal to the value.

For example,
add(1); add(3); add(5);
find(4) -> true
find(7) -> false
 * 
 * @author Zealot
 * @date 2016年4月18日 上午11:31:03 
 *
 */
public class TwoSumIIIDatastructuredesign {
	List<Integer> list = new ArrayList<Integer>();
	Set<Integer> sumSet = new HashSet<Integer>();
	// Add the number to an internal data structure.
	/**
	 * O(N) RUNTIME
	 * O(N^2) SPACE
	 * @date 2016年4月19日 下午8:54:57
	 * @param number
	 */
	public void add(int number) {
		for(Integer i: list){
			sumSet.add(i + number);
		}
		list.add(number);
	}

    // Find if there exists any pair of numbers which sum is equal to the value.
	/**
	 * O(1) RUNTIME
	 * @date 2016年4月19日 下午8:55:03
	 * @param value
	 * @return
	 */
	public boolean find(int value) {
		return sumSet.contains(value);
	}
	public static void main(String[] args) {
		TwoSumIIIDatastructuredesign t = new TwoSumIIIDatastructuredesign();
	}
	/**
	 * 
	 * 
	 * @author Zealot
	 * @date 2016年4月19日 下午8:54:01 
	 *
	 */
	public class TwoSumIIIDatastructuredesign_2 {
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		// Add the number to an internal data structure.
		public void add(int number) {
			if(!map.containsKey(number)){
				map.put(number, 1);
			}else{
				map.put(number, map.get(number)+1);
			}
		}
		
		// Find if there exists any pair of numbers which sum is equal to the value.
		public boolean find(int value) {
			 for(Integer i: map.keySet()){
				 if(map.containsKey(value - i)){
					 if(value- i!=i){
						 return true;
					 }else if(map.get(i)>1){
						 return true;
					 }
				 }
			 }
			
			return false;
		}
	}
}

