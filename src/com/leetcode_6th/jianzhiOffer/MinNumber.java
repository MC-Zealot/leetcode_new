package com.leetcode_6th.jianzhiOffer;

/**
 * 剑指 Offer 45. 把数组排成最小的数
 * 输入一个非负整数数组，把数组里所有数字拼接起来排成一个数，打印能拼接出的所有数字中最小的一个。
 *
 *
 *
 * 示例 1:
 *
 * 输入: [10,2]
 * 输出: "102"
 * 示例 2:
 *
 * 输入: [3,30,34,5,9]
 * 输出: "3033459"
 *
 *
 * 提示:
 *
 * 0 < nums.length <= 100
 * 说明:
 *
 * 输出结果可能非常大，所以你需要返回一个字符串而不是整数
 * 拼接起来的数字可能会有前导 0，最后结果不需要去掉前导 0
 */
public class MinNumber {
    public int compareTo(int a, int b){
        if(a == b){
            return 0;
        }
        if(b == -1){
            return 1;
        }

        String aStr = String.valueOf(a);
        String bStr = String.valueOf(b);

        if( (aStr+bStr).compareTo(bStr+aStr) > 0){
            return -1;
        }else if((aStr+bStr).compareTo(bStr+aStr) < 0){
            return 1;
        }else{
            return 0;
        }
//        int size = Math.min(aStr.length(), bStr.length());
//        for(int i = 0; i < size; i++){
//            int aDigit = Integer.parseInt(String.valueOf(aStr.charAt(i)));
//            int bDigit = Integer.parseInt(String.valueOf(bStr.charAt(i)));
//            if(aDigit < bDigit){
//                return 1;
//            }else if(aDigit > bDigit){
//                return -1;
//            }
//        }
//        if(aStr.length() == size && size < bStr.length()){
//            int bDigit = Integer.parseInt(String.valueOf(bStr.charAt(size)));
//            int aDigit = Integer.parseInt(String.valueOf(aStr.charAt(0)));
//            if(bDigit > aDigit){
//                return 1;
//            }else{
//                return -1;
//            }
//        }else if(bStr.length() == size && size < aStr.length()){
//            int aDigit = Integer.parseInt(String.valueOf(aStr.charAt(size)));
//            int bDigit = Integer.parseInt(String.valueOf(bStr.charAt(0)));
//            if(bDigit > aDigit){
//                return 1;
//            }else{
//                return -1;
//            }
//        }
//        return 0;
    }

    public int findNoVisitAndMin(boolean[] flags, int[] nums){
        int minIndex = -1;
        int min = -1;
        for(int i = 0; i < flags.length; i++){
            if(flags[i] == false){
                if(compareTo(nums[i], min) == 1){
                    min = nums[i];
                    minIndex = i;
                }
            }
        }
        return minIndex;
    }

    public String minNumber(int[] nums) {
        StringBuffer sb = new StringBuffer();
        int cnt = 0;
        boolean[] flags = new boolean[nums.length];
        while(cnt < nums.length){
            int index1 = findNoVisitAndMin(flags, nums);
            if(index1 == -1){
                break;
            }
            flags[index1] = true;
            sb.append(nums[index1]);
            cnt++;
        }
        return sb.toString();
    }

    public int findNoVisit(boolean[] flags, int f){
        for(int i = 0; i < flags.length; i++){
            if(flags[i] == false && i != f){
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        MinNumber mn = new MinNumber();
        int[] nums = {999999998,999999997,999999999};
        String ret = mn.minNumber(nums);
        System.out.println(ret);
    }
}
