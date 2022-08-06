package com.leetcode_6th;

import java.util.HashSet;
import java.util.Set;

public class HappyNum {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n!=1){
            if(set.contains(n)){
                return false;
            }
            set.add(n);
            int sum = 0;
            while(n > 0){
                int digit = n % 10;
                n = n/ 10;
                sum += digit * digit;
            }
            n = sum;
        }

        return true;
    }

    public static void main(String[] args) {
        HappyNum h = new HappyNum();
        System.out.println(h.isHappy(2));
    }
}
