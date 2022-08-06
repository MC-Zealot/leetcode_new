package com.leetcode_6th;

public class KthSymbolinGrammar {
    public int kthGrammar(int n, int k) {
        if(n == 1){
            return 0;
        }
        int newK = 0;
        int flag = 0;
        if(k %2 == 0){
            newK = k / 2;
        }else{
            flag = 1;
            newK = k / 2 + 1;
        }
        int lastNum = kthGrammar(n - 1, newK);
        int left = 0;
        int right = 0;
        if(lastNum == 1){
            left = 1;
            right = 0;
        }
        if(lastNum == 0){
            left = 0;
            right = 1;
        }
        int ret = 0;
        if(flag == 0){
            ret = right;
        }else{
            ret = left;
        }
        return ret;
    }
}
