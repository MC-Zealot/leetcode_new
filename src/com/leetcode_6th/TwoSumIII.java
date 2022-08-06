package com.leetcode_6th;

import java.util.*;

public class TwoSumIII {
    Map<Integer, Integer> map = null;
    List<Integer> list = null;
    int index = 0;
    public TwoSumIII(){
        map = new HashMap<>();
        list = new ArrayList<Integer>();
    }

    public void add(int number) {
        list.add(number);
        map.put(index, number);
        index++;
    }

    public boolean find(int value) {
//        map = new HashMap<>();
        for(int i = 0; i < list.size(); i++){
            int tmp = list.get(i);
            int tmp2 = value - tmp;
//            if(map.containsValue(tmp2) && ){
//                return true;
//            }
        }
        return false;
    }

    public static void main(String[] args) {
        TwoSumIII t = new TwoSumIII();
        t.add(1);
        t.add(3);
        t.add(5);
        System.out.println(t.find(4));
        PriorityQueue<Integer> pq = new PriorityQueue<>(5, (a,b)->b-a);
    }
}
