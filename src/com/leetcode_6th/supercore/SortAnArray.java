package com.leetcode_6th.supercore;

public class SortAnArray {
    /**
     * qs
     * @param nums
     * @return
     */
    public int[] sortArray(int[] nums) {
        qs(nums, 0, nums.length - 1);
        return nums;
    }
    public void qs(int[] nums, int left, int right){
        if(left < right){
            int p = partition(nums, left, right);
            qs(nums, left, p - 1);
            qs(nums, p + 1, right);
        }
    }

    /**
     * 双指针
     * @param nums
     * @param left
     * @param right
     * @return
     */
    public int partition(int[] nums, int left, int right){
        int p = nums[right];
        int i = left;
        for(int j = left; j < right; j++){
            if(p > nums[j]){
                int tmp = nums[i];
                nums[i] = nums[j];
                nums[j] = tmp;
                i++;
            }
        }
        int tmp = nums[i];
        nums[i] = nums[right];
        nums[right] = tmp;
        return i;
    }
}
