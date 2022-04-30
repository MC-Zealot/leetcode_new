package com.leetCode._2th;
/**
 * Rotate an array of n elements to the right by k steps.

For example, with n = 7 and k = 3, the array [1,2,3,4,5,6,7] is rotated to [5,6,7,1,2,3,4].

Note:
Try to come up as many solutions as you can, there are at least 3 different ways to solve this problem.
 * 
 * @author Zealot
 * @date 2016年3月30日 下午10:21:51 
 *
 */
public class RotateArray {
	/**
	 * WA
	 * @date 2016年6月7日 下午12:15:00
	 * @param nums
	 * @param k
	 */
	@Deprecated
	public void rotate(int[] nums, int k) {
		if(nums.length<k){
			return;
		}
        int[] a = new int[nums.length]; 
        int index = 0;
        for(int i = nums.length - k; i < nums.length; i++) {
        	a[index++] = nums[i];
        }
        for(int i = 0; i <nums.length - k; i++) {
        	a[index++] = nums[i];
        }
        for(int i = 0; i < a.length;i++) {
        	System.out.print(a[i]+"\t");
        }
    }
	/**
	 * WA
	 * @date 2016年6月7日 下午12:15:00
	 * @param nums
	 * @param k
	 */
	@Deprecated
	public void rotate2(int[] nums, int k) {
		if(nums.length<k){
			return;
		}
		int size = nums.length;
		for(int i = 0; i < k; i++) {
			int tmp = nums[i];
			int tmp2 = nums[k + i];
			nums[i] = nums[size - k +i];
			nums[k + i] = tmp;
			nums[size - k + i] = tmp2;
		}
		for(int i = 0; i < nums.length;i++) {
        	System.out.print(nums[i]+"\t");
        }
    }
	public void rotate3(int[] nums, int k) {
	    k %= nums.length;
	    reverse(nums, 0, nums.length - 1);
	    reverse(nums, 0, k - 1);
	    reverse(nums, k, nums.length - 1);
	}

	public void reverse(int[] nums, int start, int end) {
	    while (start < end) {
	        int temp = nums[start];
	        nums[start] = nums[end];
	        nums[end] = temp;
	        start++;
	        end--;
	    }
	}
	public static void main(String[] args) {
		RotateArray r = new RotateArray();
		int[] a = {1,2};
		r.rotate(a, 1);
	}
}

