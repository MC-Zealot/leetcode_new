package com.leetCode._1th;

/**
 * Given an array and a value, remove all instances of that value in place and
 * return the new length.
 * 
 * The order of elements can be changed. It doesn't matter what you leave beyond
 * the new length.
 * 
 * @author Zealot
 * @date 2015年8月29日 下午12:06:04
 */
public class RemoveElement {
	public int removeElement(int[] nums, int val) {

		int valNum = 0;
		for(int i = 0; i < nums.length; i++) {
			if(val==nums[i]){
				valNum++;
			}else if(valNum>0){
				nums[i-valNum] = nums[i];
			}
		}
		return nums.length-valNum;
	}
	public static void main(String[] args) {
		RemoveElement r = new RemoveElement();
		int[] a = {4,5};
		System.out.println(r.removeElement(a, 4));
	}
}
