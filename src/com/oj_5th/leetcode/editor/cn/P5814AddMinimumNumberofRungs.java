package com.oj_5th.leetcode.editor.cn;

public class P5814AddMinimumNumberofRungs {
//5814 Add Minimum Number of Rungs
    public int addRungs(int[] rungs, int dist) {
        int ret = 0;
        int curr_height = 0;
        for(int i = 0; i < rungs.length; i++){
            if(rungs[i] - curr_height > dist){
                int tmp = (rungs[i] - curr_height) / dist;
                ret+=tmp;
                if(tmp * dist== rungs[i] - curr_height){
                    ret--;
                }
            }
            curr_height= rungs[i];
        }
        return ret;
    }

    public static void main(String[] args) {
        P5814AddMinimumNumberofRungs p = new P5814AddMinimumNumberofRungs();
        int[] a = {1,3,5,10};
        int dist = 2;
        System.out.println(p.addRungs(a, dist));
    }
}
