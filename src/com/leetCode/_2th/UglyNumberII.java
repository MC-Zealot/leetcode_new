package com.leetCode._2th;

import java.util.ArrayList;
import java.util.List;

/**
 * Write a program to find the n-th ugly number.

Ugly numbers are positive numbers whose prime factors only include 2, 3, 5. 

For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.

Note that 1 is typically treated as an ugly number.
 * 
 * @author Zealot
 * @date 2016年4月7日 下午10:42:35 
 *
 */
public class UglyNumberII {
	public int nthUglyNumber(int n) {
        List<Integer> res = new ArrayList<Integer>();
        res.add(1);
        int i2 = 0, i3 = 0, i5 = 0;
        while(res.size() < n){
            int m2 = res.get(i2) * 2;
            int m3 = res.get(i3) * 3;
            int m5 = res.get(i5) * 5;
            int min = Math.min(m2, Math.min(m3, m5));
            res.add(min);
            if(min == m2) i2++;
            if(min == m3) i3++;
            if(min == m5) i5++;
        }
        return res.get(res.size()-1);
    }
	public int nthUglyNumber2(int n) {
        int[] ugly = new int[n];
        ugly[0] = 1;
        int index2 = 0, index3 = 0, index5 = 0;
        int factor2 = 2, factor3 = 3, factor5 = 5;
        for(int i=1;i<n;i++){
            int min = Math.min(Math.min(factor2,factor3),factor5);
            ugly[i] = min;
            if(factor2 == min)
                factor2 = 2*ugly[++index2];
            if(factor3 == min)
                factor3 = 3*ugly[++index3];
            if(factor5 == min)
                factor5 = 5*ugly[++index5];
        }
        return ugly[n-1];
    }
}
