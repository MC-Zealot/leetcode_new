package com.leetcode_6th;

public class MinCount {
    int flag;
    int min;
    public void findMin(int[] nums){
        flag = 0;
        for(int i = 0; i < nums.length; i++){
            if(nums[i] !=0){
                min = nums[i];
                break;
            }
        }
        for(int i = 0; i < nums.length; i++){
            if(nums[i] != 0){
                flag = nums[i];
            }else{
                continue;
            }
            min = Math.min(min, nums[i]);
        }
    }
    public int minimumOperations(int[] nums) {
        int ret = 0;
        this.min = Integer.MAX_VALUE;
        this.flag = nums[0];
        findMin(nums);
        while(flag != 0){
            for(int i = 0; i < nums.length; i++){
                int tmp = nums[i] - min;
                if(tmp<0){
                    tmp = 0;
                }
                nums[i] = tmp;
            }
            findMin(nums);
            ret++;
        }
        if(flag==0){
            return ret;
        }
        return -1;
    }

    public static void main(String[] args) {
        MinCount mc = new MinCount();
        int[] a = {1,5,0,3,5};
        System.out.println(mc.minimumOperations(a));
    }
}
