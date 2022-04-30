package com.leetCode._2th;
/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

 If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

 The replacement must be in-place, do not allocate extra memory.

 Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
 1,2,3 → 1,3,2
 3,2,1 → 1,2,3
 1,1,5 → 1,5,1
 From the wikipedia, one classic algorithm to generate next permutation is:

 1. Find the largest index k, such that A[k]<A[k+1]. If not exist, this is the last permutation. (in this problem just sort the vector and return.)

 2. Find the largest index l, such that A[l]>A[k].

 3. Swap A[k] and A[l].

 4. Reverse A[k+1] to the end.
 *
 * @author Zealot
 * @date 2016年3月3日 上午9:51:47
 *
 */
public class NextPermutation {
	public void nextPermutation(int[] nums) {
		if(nums.length==0||nums.length==1){
			return ;
		}
		//Find the largest index k, such that A[k]<A[k+1].
		int k = -1;
		for(int i = nums.length-1; i > 0; i--) {
			if(nums[i]>nums[i-1]){
				k=i-1;
				break;
			}
		}
		if(k==-1){
			//翻转
			for(int i = 0,j = nums.length-1; i < j; i++,j--){
				int tmp2 = nums[i];
				nums[i] = nums[j];
				nums[j] = tmp2;
			}
			return;
		}
		int l = -1;
		for(int i = nums.length-1; i > 0; i--){
			if(nums[i]>nums[k]){
				l = i;
				break;
			}
		}
		int tmp = nums[k];
		nums[k] = nums[l];
		nums[l] = tmp;
		//从l开始翻转
		for(int i = k+1,j = nums.length-1; i < j; i++,j--){
			int tmp2 = nums[i];
			nums[i] = nums[j];
			nums[j] = tmp2;
		}
//        for(int i = 0; i < nums.length;i++) {
//        	System.out.print(" "+nums[i]);
//        }
	}
	public void nextPermutation2(int[] nums) {
		if(nums == null || nums.length<2)
			return;

		int p=0;
		for(int i=nums.length-2; i>=0; i--){
			if(nums[i]<nums[i+1]){
				p=i;
				break;
			}
		}

		int q = 0;
		for(int i=nums.length-1; i>p; i--){
			if(nums[i]> nums[p]){
				q=i;
				break;
			}
		}

		if(p==0 && q==0){
			reverse(nums, 0, nums.length-1);
			return;
		}
		System.out.println(p);
		System.out.println(q);
		int temp=nums[p];
		nums[p]=nums[q];
		nums[q]=temp;

		if(p<nums.length-1){
			reverse(nums, p+1, nums.length-1);
		}
		for(int i = 0; i < nums.length;i++) {
			System.out.print(" "+nums[i]);
		}
	}

	public void reverse(int[] nums, int left, int right){
		while(left<right){
			int temp = nums[left];
			nums[left]=nums[right];
			nums[right]=temp;
			left++;
			right--;
		}
	}
	public static void main(String[] args) {
		NextPermutation n = new NextPermutation();
		int[] a = {1,3,2};
		n.nextPermutation(a);
	}
}
