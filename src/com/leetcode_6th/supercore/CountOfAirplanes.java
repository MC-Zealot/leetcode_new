package com.leetcode_6th.supercore;


import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CountOfAirplanes {
    public static class Interval {
        int start, end;
        Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }
    int max;
    int min;
    /**
     * @param airplanes: An interval array
     * @return: Count of airplanes are in the sky.
     */
    public int countOfAirplanes(List<Interval> airplanes) {
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        // write your code here
        getX(airplanes);
        int[] times = new int[max - min];
        int ret = 0;
        for(int i = 0;i < airplanes.size(); i++){
            Interval interval = airplanes.get(i);
            int start = interval.start;
            int end = interval.end;
            for(int j = start - min; j < end - min; j++){
                times[j] += 1;
                ret = Math.max(ret, times[j]);
            }
        }
        return ret;
    }
    public void getX(List<Interval> airplanes){
        for(int i = 0;i < airplanes.size(); i++){
            Interval interval = airplanes.get(i);
            int start = interval.start;
            int end = interval.end;
            max = Math.max(max, start);
            max = Math.max(max, end);
            min = Math.min(min, start);
            min = Math.min(min, end);
        }
    }

    /**
     * 扫描线
     * @param airplanes
     * @return
     */
    public int countOfAirplanes2(List<Interval> airplanes) {
        // write your code here
        List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();
        for(int i = 0; i < airplanes.size(); i++){
            list.add(new Pair<Integer, Integer>(airplanes.get(i).start, 1));
            list.add(new Pair<Integer, Integer>(airplanes.get(i).end, -1));
        }
        Collections.sort(list, Comparator.comparingInt(o -> o.getKey()));
        int max = Integer.MIN_VALUE;
        int tmp = 0;
        for(int i = 0; i < list.size(); i++){
            tmp = tmp + list.get(i).getValue();
            max = Math.max(max, tmp);
        }
        return max;
    }


    /**
     * 前缀和
     * 时间复杂度：O(n)
     * 起飞时间，降落时间，都记录在数组上
     * 从头开始遍历，遇到起飞，天上的飞机数+1
     * 遇到降落，飞机数-1
     */
    public int countOfAirplanes3(List<Interval> airplanes) {
        max = Integer.MIN_VALUE;
        min = Integer.MAX_VALUE;
        // write your code here
        getX(airplanes);
        int[] times = new int[max - min + 1];
        for(int i =0;i < airplanes.size(); i++){
            Interval interval = airplanes.get(i);
            int start = interval.start;
            int end = interval.end;
            times[start - min] += 1;
            times[end - min] -= 1;
        }
        int ret = 0;
        int tmp = 0;
        for(int i = 0; i < times.length; i++){
            if(times[i] != 0){
                tmp+= times[i];
                ret = Math.max(ret, tmp);
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        CountOfAirplanes coa = new CountOfAirplanes();
        List<Interval> airplanes = new ArrayList<>();
        airplanes.add(new Interval(1,10));
        airplanes.add(new Interval(2,3));
        airplanes.add(new Interval(5,8));
        airplanes.add(new Interval(4,7));
        int ret = coa.countOfAirplanes3(airplanes);
        System.out.println(ret);
    }
}
