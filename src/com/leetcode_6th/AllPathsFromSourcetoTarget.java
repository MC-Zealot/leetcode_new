package com.leetcode_6th;

import java.util.*;

public class AllPathsFromSourcetoTarget {
    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {
        List<List<Integer>> ret = new ArrayList<List<Integer>>();
        boolean[] flags = new boolean[graph.length];
        List<Integer> tmp = new ArrayList<Integer>();
        tmp.add(0);
        dfs(graph, flags, 0, tmp, ret);
        return ret;
    }
    public void dfs(int[][] graph, boolean[] flags, int index, List<Integer> tmp, List<List<Integer>> ret){
        if(index == graph.length - 1){
            ret.add(new ArrayList<Integer>(tmp));
            return;
        }
        int[] outPath = graph[index];
        for(int i = 0;i < outPath.length; i++){
            int out = outPath[i];
            tmp.add(out);
            dfs(graph, flags, out, tmp, ret);
            tmp.remove(tmp.size() - 1);
        }
    }
    public List<Integer> arrayToList(int[] array){
        List<Integer> tmp = new ArrayList<>();
        for(int i = 0; i < array.length; i++){
            tmp.add(array[i]);
        }
        return tmp;
    }
    public List<List<Integer>> allPathsSourceTarget2(int[][] graph) {
        List<List<Integer>> ret = new ArrayList<>();
        Queue<List<Integer>> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();
        list.add(0);
        q.add(list);
        while(q.size() > 0){
            List<Integer> tmp = q.poll();
            int last = tmp.get(tmp.size() - 1);
            if(last == graph.length - 1){
                ret.add(new ArrayList(tmp));
            }else{
                int[] lastOut = graph[last];
                for(int i = 0; i < lastOut.length; i++){
                    tmp.add(lastOut[i]);
                    q.add(new ArrayList<Integer>(tmp));
                    tmp.remove(tmp.size() - 1);
                }
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        AllPathsFromSourcetoTarget a = new AllPathsFromSourcetoTarget();
        int[][] input = {{1,2},{3},{3},{}};
        List<List<Integer>> ret = a.allPathsSourceTarget(input);
        System.out.println(ret);
    }
}
