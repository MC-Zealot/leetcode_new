package com.leetcode_2th;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月5日 下午6:33:12 
 *
 */
public class RemoveElement {
	public int removeElement(int[] nums, int val) {
		int place = 0, size = nums.length;
		for(int i = 0; i < size; i++){
			if(nums[i] == val) {
				continue;
			}else{
				nums[place++] = nums[i];
			}
		}
		return place;
    }
	public static void main(String[] args) {
		RemoveElement r = new RemoveElement();
		int[] nums = {3,2,2,3,4,6,7,3,3,2,5,6};
		int val = 3;
		r.removeElement(nums, val);
	}
}
