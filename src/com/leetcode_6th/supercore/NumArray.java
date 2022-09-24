package com.leetcode_6th.supercore;

/**
 * 树状数组
 */
public class NumArray {
    int[] tree;
    int[] nums;
    public int lowbit(int x){
        return x & -x;
    }
    public void add(int index, int val){
        for(int i = index; i < tree.length; i+=lowbit(i)){
            tree[i] += val;
        }
    }
    public int query(int x){
        int sum = 0;
        for(int i = x; i > 0; i-=lowbit(i)){
            sum+=tree[i];
        }
        return sum;
    }
    public NumArray(int[] nums) {
        this.nums = nums;
        this.tree = new int[nums.length + 1];
        for(int i = 0; i < nums.length; i++){
            add(i + 1, nums[i]);
        }
    }

    public void update(int index, int val) {
        add(index + 1, val - nums[index]);
        nums[index] = val;
    }

    public int sumRange(int left, int right) {
        return query(right + 1) - query(left);
    }
}
