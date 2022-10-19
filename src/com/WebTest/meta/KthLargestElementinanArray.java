package com.WebTest.meta;

import java.util.PriorityQueue;

public class KthLargestElementinanArray {
    public int findKthLargest2(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<Integer>(k);

        for(int i = 0; i < nums.length; i++){
            pq.add(nums[i]);
        }
        return pq.poll();
    }

    public int findKthLargest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        while(true){
            int p = partition(nums, left, right);
            if(p == nums.length - k){
                return nums[p];
            }else if(p < nums.length - k){
                left = p + 1;
            }else{
                right = p - 1;
            }
        }
    }
    public int partition(int[] nums, int left, int right){
        int i = right;
        int p = nums[right];
        for(int j = left; j < right; j++){
            if(nums[j] >= p){
                swap(nums, j, right - 1);
                right--;
                j--;
            }
        }
        swap(nums, right, i);
        return i;
    }
    public void swap(int[] nums, int i, int j){
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    public static void main(String[] args) {
        KthLargestElementinanArray k = new KthLargestElementinanArray();
        int[] nums = {3,2,1,5,6,4};
        System.out.println(k.findKthLargest(nums, 2));
    }
}
