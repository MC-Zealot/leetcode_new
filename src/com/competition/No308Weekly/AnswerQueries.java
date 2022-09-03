package com.competition.No308Weekly;

import java.lang.reflect.Array;
import java.util.*;

public class AnswerQueries {
    public int[] answerQueries2(int[] nums, int[] queries) {
        int[] ret = new int[queries.length];
        if(nums.length == 0){
            return ret;
        }
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int i = 0;i < nums.length; i++){
            int num = nums[i];
            if(map.containsKey(num)){
                map.get(num).add(i);
            }else{
                List<Integer> tmp = new ArrayList<>();
                tmp.add(i);
                map.put(num, tmp);
            }
        }
        for(int i = 0;i < queries.length; i++){
            int query = queries[i];
            int[] numsArr = map.keySet().stream().mapToInt(o->o).toArray();
            Arrays.sort(numsArr);
            int sum = 0;
            for(int j = 0; j < numsArr.length; j++){
                int n = numsArr[j];
                sum += n;
                if(sum>query){

//                    ret[] = j;
                }
            }
        }
        return ret;
    }

    public int[] answerQueries(int[] nums, int[] queries) {
        int[] ret = new int[queries.length];
        if(nums==null || nums.length == 0){
            return ret;
        }
        Arrays.sort(nums);
        for(int i = 0;i < queries.length; i++){
            int query = queries[i];
            int sum = 0;
            for(int j = 0; j < nums.length; j++){
                int n = nums[j];
                sum += n;
                if(sum <= query){
                    ret[i] +=1;
                }
            }
        }
        return ret;
    }
//    public int getIndex(Map<Integer, List<Integer>> map, )

    public static void main(String[] args) {
        AnswerQueries aq = new AnswerQueries();
        int[] nums = {4,5,2,1};
        int[] queries = {3,10,21};
        int[] ret = aq.answerQueries(nums, queries);
        for(int i = 0; i < ret.length; i++){
            System.out.println(ret[i]);
        }

    }
}
