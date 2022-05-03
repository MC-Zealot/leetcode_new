package com.leetcode_6th;

import java.util.*;

/**
 *
 */
public class DiagonalTraverse {
    public int[] findDiagonalOrder(int[][] mat) {
        Map<Integer, List<String>> map = new HashMap<>();
        List<String> ret = new ArrayList<>();
        for(int i = 0; i < mat.length; i++){
            for(int j = 0; j < mat[0].length; j++){
                int key = i + j;
                if(!map.containsKey(key)){
                    map.put(key, new ArrayList<String>());
                }
                map.get(key).add(i+"_"+j);
            }
        }
        for(Integer key: map.keySet()){
            List<String> list = map.get(key);
            if(key % 2 == 0){
                Collections.sort(list, Comparator.comparing(o->(-1) * Integer.parseInt(o.split("_")[0] +""+o.split("_")[1])));
            }else{

                Collections.sort(list, Comparator.comparing(o->Integer.parseInt(o.split("_")[0] +""+o.split("_")[1])));
            }
            ret.addAll(list);
        }
        int[] r = new int[mat.length * mat[0].length];
        for(int i = 0; i < r.length; i++){
            String val = ret.get(i);
            int x = Integer.parseInt(val.split("_")[0]);
            int y = Integer.parseInt(val.split("_")[1]);
            r[i] = mat[x][y];
        }
        return r;
    }
}
