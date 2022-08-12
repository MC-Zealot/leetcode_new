package com.leetcode_6th.jianzhiOffer;

import java.util.Arrays;

public class VerifyPostorder {
    public boolean verifyPostorder(int[] postorder) {
        if(postorder.length <= 1){
            return true;
        }
        int last = postorder[postorder.length - 1];
        int i = 0;
        for(;i < postorder.length - 1; i++){
            if(postorder[i] > last){
                break;
            }
        }
        if(i == postorder.length){
            i = postorder.length - 1;
        }
        int[] subRight = Arrays.copyOfRange(postorder, i, postorder.length - 1);
        int[] subLeft = Arrays.copyOfRange(postorder, 0, i);
        boolean ret = helper(subRight, last);

        if(ret == false){
            return false;
        }
        ret = verifyPostorder(subRight);
        boolean retLeft = verifyPostorder(subLeft);
        if(ret == false || retLeft == false){
            return false;
        }
        return true;
    }
    public boolean helper(int[] nums, int last){
        for(int i = 0 ;i < nums.length ; i++){
            if(nums[i] < last){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        VerifyPostorder vp = new VerifyPostorder();
        int[] nums ={
                5, 2, -17, -11, 25, 76, 62, 98, 92, 61
        };
        boolean ret = vp.verifyPostorder(nums);
        System.out.println(ret);
    }
}
