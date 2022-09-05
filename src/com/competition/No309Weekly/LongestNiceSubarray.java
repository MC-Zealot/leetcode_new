package com.competition.No309Weekly;

import java.util.HashMap;
import java.util.Map;

public class LongestNiceSubarray {
    public int longestNiceSubarray(int[] nums) {
        int max = 1;
        for(int start = 0; start < nums.length; start++){
            for(int i = start + 1; i < nums.length; i++){
                int flag = 1;
                for(int j = start; j <= i; j++){
                    int a = nums[start];
                    int b = nums[i];
                    if(getAnd(a, b) != 0){
                        start = i - 1;
                        flag = 0;
                        break;
                    }
                }
                if(flag == 0){
                    break;
                }else{
                    max = Math.max(max, i - start + 1);
                }
            }
        }

        return max;
    }
//    public boolean isNice(int[] nums){
//        for(int i = 0; i < nums.length; i++){
//            for(int j = i + 1; j < nums.length; j++){
//                int a = nums[i];
//                int b = nums[j];
//                if(getAnd(a, b) != 0){
//                    return false;
//                }
//            }
//        }
//    }
    public int getAnd(int a, int b){
        return a&b;
    }

    public static void main(String[] args) {
        LongestNiceSubarray l = new LongestNiceSubarray();
        int[] nums = {744437702,379056602,145555074,392756761,560864007,934981918,113312475,1090,16384,33,217313281,117883195,978927664};
        System.out.println(l.longestNiceSubarray(nums));
    }
}
