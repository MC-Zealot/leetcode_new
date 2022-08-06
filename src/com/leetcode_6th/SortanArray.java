package com.leetcode_6th;

import java.util.Arrays;

public class SortanArray {
    public int[] sortArray(int[] nums) {
        if(nums.length == 1){
            return nums;
        }
        return mergeSort(nums);
    }
    public int[] mergeSort(int[] nums){
        if(nums.length <= 1){
            return nums;
        }
        int pivot = nums.length / 2;
        int[] left = Arrays.copyOfRange(nums, 0, pivot);
        int[] right = Arrays.copyOfRange(nums, pivot, nums.length);
        int[] leftSorted = mergeSort(left);
        int[] rightSorted = mergeSort(right);

        return mergeArray(leftSorted, rightSorted);
    }
    public int[] mergeArray(int[] leftSorted, int[] rightSorted){
        int[] ret = new int[leftSorted.length + rightSorted.length];
        int leftIndex = 0;
        int rightIndex = 0;
        for(int i = 0 ;i < ret.length; i++){
            if(leftIndex == leftSorted.length){
                ret[i] = rightSorted[rightIndex++];
                continue;
            }else if(rightIndex == rightSorted.length){
                ret[i] = leftSorted[leftIndex++];
                continue;
            }
            if(leftSorted[leftIndex] <= rightSorted[rightIndex]){
                ret[i] = leftSorted[leftIndex++];
            }else{
                ret[i] = rightSorted[rightIndex++];
            }
        }
        return ret;
    }
}
