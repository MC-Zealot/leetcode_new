package com.leetcode_6th.core;


import java.util.List;

public class CountOfAirplanes {
    public class Interval {
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
}
