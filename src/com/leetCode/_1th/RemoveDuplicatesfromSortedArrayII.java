package com.leetCode._1th;

/**
 * Follow up for "Remove Duplicates": What if duplicates are allowed at most
 * twice?
 * 
 * For example, Given sorted array nums = [1,1,1,2,2,3],
 * 
 * Your function should return length = 5, with the first five elements of nums
 * being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new
 * length.
 * 
 * @author Zealot
 * @date 2015年9月5日 下午9:35:40
 */
public class RemoveDuplicatesfromSortedArrayII {
	public int removeDuplicates(int[] nums) {
		if(nums.length<=1){
			return nums.length;
		}
		int num = 0;//一共重复的次数
		int time = 0;//某一个数字，重复的次数
		for(int i = 0; i < nums.length - 1; i++) {
			if(nums[i] == nums[i+1]&&++time>=2){//如果大于等于2次，则计数
				num++;
			}
			if(nums[i]!=nums[i+1]&&time>0){
				time=0;
			}
			nums[i-num+1] = nums[i+1]; 
			for(int j = 0; j < nums.length; j++) {
				System.out.print(nums[j]+" ");
			}
			System.out.println();
		}
		return nums.length-num;
	
	}
	public static void main(String[] args) {
		RemoveDuplicatesfromSortedArrayII r = new RemoveDuplicatesfromSortedArrayII();
		int[] a = {1,1,1,1,2,2,3,3,4};
		
		System.out.println(r.removeDuplicates(a));
	}
}
