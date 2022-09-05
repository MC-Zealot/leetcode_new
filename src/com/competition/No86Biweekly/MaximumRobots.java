package com.competition.No86Biweekly;

import java.util.ArrayList;
import java.util.List;

public class MaximumRobots {
    int max;
    public int maximumRobots2(int[] chargeTimes, int[] runningCosts, long budget) {
        this.max = 0;
//        dfs(chargeTimes, runningCosts, budget, new ArrayList<>(), 0);
        for(int i = 0; i < chargeTimes.length; i++){
            for(int j = i; j < chargeTimes.length; j++){
                List<Integer> list = new ArrayList<>();
                for(int k = i; k <= j; k++){
                    list.add(k);
                }
                int cost = calCost(chargeTimes, runningCosts, list);
                if(cost <= budget){
                    max = Math.max(max, list.size());
                }else{
                    break;
                }
            }
        }
        return max;
    }
    public int maximumRobots(int[] chargeTimes, int[] runningCosts, long budget) {
        this.max = 0;
        int maxCharge = 0;
        int preSumCost= 0;
        maxCharge = chargeTimes[0];
        preSumCost = runningCosts[0];
        int ret = maxCharge + preSumCost;
        for(int i = 1; i < runningCosts.length; i++){
            maxCharge = Math.max(maxCharge, chargeTimes[i]);
            preSumCost += runningCosts[i];
            int tmp = maxCharge + (i + 1) * preSumCost;
            if(tmp<= budget){
                max = i + 1;
            }else{
                break;
            }
        }
        return max;
    }
//    public void dfs(int[] chargeTimes, int[] runningCosts, long budget, List<Integer> tmp, int index){
//        int cost = calCost(chargeTimes, runningCosts, tmp);
//        if(cost <= budget){
//            max = Math.max(max, tmp.size());
//        }
//        for(int i = index ; i < chargeTimes.length; i++){
//            if(tmp.size() > 0 && tmp.get(tmp.size() - 1) + 1 != i){
//                break;
//            }
//            tmp.add(i);
//            dfs(chargeTimes, runningCosts, budget, tmp, i + 1);
//            tmp.remove(tmp.size() - 1);
//        }
//    }
    public int calCost(int[] chargeTimes, int[] runningCosts, List<Integer> tmp){
        int maxCharge = 0;
        int sumC = 0;
        for(int i = 0; i < tmp.size(); i++){
            int t = chargeTimes[tmp.get(i)];
            int cost = runningCosts[tmp.get(i)];
            maxCharge = Math.max(maxCharge, t);
            sumC+=cost;
        }
        return  tmp.size() * sumC + maxCharge;
    }

    public static void main(String[] args) {
        MaximumRobots m = new MaximumRobots();
        int[] chargeTimes = {11,12,74,67,37,87,42,34,18,90,36,28,34,20};
        int[] runningCosts = {18,98,2,84,7,57,54,65,59,91,7,23,94,20};
        long budget = 937;
        int ret = m.maximumRobots(chargeTimes, runningCosts, budget);
        System.out.println(ret);
    }
}
