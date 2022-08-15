package com.leetcode_6th.jianzhiOffer;

import java.util.*;

/**
 * 剑指 Offer 57 - II. 和为s的连续正数序列
 * 输入一个正整数 target ，输出所有和为 target 的连续正整数序列（至少含有两个数）。
 *
 * 序列内的数字由小到大排列，不同序列按照首个数字从小到大排列。
 *
 * 示例 1：
 *
 * 输入：target = 9
 * 输出：[[2,3,4],[4,5]]
 * 示例 2：
 *
 * 输入：target = 15
 * 输出：[[1,2,3,4,5],[4,5,6],[7,8]]
 *
 *
 * 限制：
 *
 * 1 <= target <= 10^5
 */
public class FindContinuousSequence {
    /**
     * 超时，题目要求连续子数组，不用dfs也可以，想复杂了
     * @param target
     * @return
     */
    public int[][] findContinuousSequence(int target) {
        List<List<Integer>> ret = new ArrayList<>();
        dfs(0, 0, target, new ArrayList<>(), ret);
        int[][] retArr = new int[ret.size()][];
        for(int i = 0; i < ret.size(); i++){
            int[] tmp = ret.get(i).stream().mapToInt(o ->o).toArray();
            retArr[i] = tmp;
        }
        return retArr;
    }
    public void dfs(int tmpSum, int index, int target, List<Integer> tmpList, List<List<Integer>> ret){
        if(tmpSum == target){
            Collections.sort(tmpList);
            int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
            for(int i = 0;i  < tmpList.size(); i++){
                max = Math.max(max,tmpList.get(i));
                min = Math.min(min,tmpList.get(i));
            }
            if(max - min + 1 != tmpList.size()){
                return;
            }
            ret.add(new ArrayList<>(tmpList));
        }
        for(int i = index + 1; i < target; i++){
            tmpList.add(i);
            if(tmpSum + i > target){
                tmpList.remove(tmpList.size() - 1);
                return;
            }
            dfs(tmpSum + i, i, target, tmpList, ret);
            tmpList.remove(tmpList.size() - 1);
        }
    }

    public static void main(String[] args) {
        FindContinuousSequence f = new FindContinuousSequence();
        int[][] ret = f.findContinuousSequence2(15);
        for(int i = 0;i  < ret.length; i++){
            for(int j = 0; j < ret[i].length; j++){
                System.out.print(ret[i][j]+", ");
            }
            System.out.println();
        }
    }
    public int[][] findContinuousSequence2(int target) {
        List<List<Integer>> ret = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int sum = 0;
        for(int i = 1;i < target; i++){
            sum+=i;
            map.put(i, sum);
        }
        for(int j = 1; j < target; j++){
            List<Integer> tmp = new ArrayList<>();
            for(int i = j + 1; i < target; i++){
                sum = map.get(i) - map.get(j) + j;
                if(sum > target){
                    break;
                }else if(sum == target){
                    for(int k = j; k <=i;k++){
                        tmp.add(k);
                    }
                    ret.add(new ArrayList<>(tmp));
                    break;
                }
            }
        }
        int[][] retArr = new int[ret.size()][];
        for(int i = 0; i < ret.size(); i++){
            int[] tmp1 = ret.get(i).stream().mapToInt(o ->o).toArray();
            retArr[i] = tmp1;
        }
        return retArr;
    }
}
