package com.leetcode_6th;

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangleII {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> ret = new ArrayList<Integer>();

        ret.add(1);
        if(rowIndex==0){

            return ret;
        }
        ret.add(1);
        if(rowIndex==1){
            return ret;
        }

        for(int i = 2; i <= rowIndex; i++){
            List<Integer> tmp = new ArrayList<Integer>();
            tmp.add(1);
            for(int j = 0; j + 1 < ret.size(); j++){
                int num = ret.get(j) + ret.get(j + 1);
                tmp.add(num);
            }
            tmp.add(1);
            ret = new ArrayList<Integer>(tmp);
        }
        return ret;
    }
}
