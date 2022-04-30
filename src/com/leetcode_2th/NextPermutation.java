package com.leetcode_2th;
/**
 * Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1



步骤比较简单：假设数组大小为 n
1.从后往前，找到第一个 A[i-1] < A[i]的。也就是第一个排列中的  6那个位置，可以看到A[i]到A[n-1]这些都是单调递减序列。
2.从 A[n-1]到A[i]中找到一个比A[i-1]大的值（也就是说在A[n-1]到A[i]的值中找到比A[i-1]大的集合中的最小的一个值）
3.交换 这两个值，并且把A[n-1]到A[i]排序，从小到大。
 * 
 * @author Zealot
 * @date 2016年6月27日 下午5:24:48 
 *
 */
public class NextPermutation {
	public void nextPermutation(int[] nums) {
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
		int temp=nums[p];
		nums[p]=nums[q];
		nums[q]=temp;

		if(p<nums.length-1){
			reverse(nums, p+1, nums.length-1);
		}
	}
	public void nextPermutation2(int[] nums) {
        int length = nums.length;
        int firstDecreaseIndexFromBack = length - 1;
        while (firstDecreaseIndexFromBack > 0 && nums[firstDecreaseIndexFromBack - 1] >= nums[firstDecreaseIndexFromBack]) {
            firstDecreaseIndexFromBack--;
        }
        firstDecreaseIndexFromBack--;
        if (firstDecreaseIndexFromBack >= 0) {
            int firstLargerPartitionIndexFromBack = length - 1;

            while (firstLargerPartitionIndexFromBack > firstDecreaseIndexFromBack && nums[firstLargerPartitionIndexFromBack] <= nums[firstDecreaseIndexFromBack]) {
                firstLargerPartitionIndexFromBack--;
            }

            int temp = nums[firstDecreaseIndexFromBack];
            nums[firstDecreaseIndexFromBack] = nums[firstLargerPartitionIndexFromBack];
            nums[firstLargerPartitionIndexFromBack] = temp;
        }

        int loop = (length - firstDecreaseIndexFromBack - 1) / 2;
        int base = firstDecreaseIndexFromBack + 1;
        for (int i = 0; i < loop; i++) {
            int temp = nums[base + i];
            nums[base + i] = nums[length - i - 1];
            nums[length - i - 1] = temp;
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
}
