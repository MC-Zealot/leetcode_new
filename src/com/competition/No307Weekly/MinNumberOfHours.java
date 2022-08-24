package com.competition.No307Weekly;

import javafx.util.Pair;

import java.util.*;

public class MinNumberOfHours {
    public int minNumberOfHours(int initialEnergy, int initialExperience, int[] energy, int[] experience) {
        int needEnergy = 1 - initialEnergy;
        for(int i = 0; i < energy.length; i++){
            needEnergy+=energy[i];
        }
        int needExp = 0;
        Map<Double, List<Integer>> map = new HashMap<>();

        for(int i = 0;i < energy.length; i++){
            int en = energy[i];
            int ex = experience[i];
            double d = ex * 1D / en;
            List<Integer> l = map.getOrDefault(d, new ArrayList<>());
            l.add(i);
            map.put(d, l);
        }
        double[] dd = map.keySet().stream().mapToDouble(o -> o).toArray();
        Arrays.sort(dd);

        for(int i = dd.length - 1; i >= 0; i--){
            double tmp = dd[i];
            List<Integer> l = map.get(tmp);
            while(l.size()> 0)  {
                int exp = findMinEng(experience, l);//TODO：把所有的按照energy从小到大排列
                if(initialExperience > exp){
                    initialExperience += exp;
                }else {
                    needExp += (exp - initialExperience + 1);
                    initialExperience += exp;
                }
            }
        }
        return needEnergy + needExp;
//        Collections.sort(map, Comparator.comparingDouble(o -> ));
    }
    public int findMinEng(int[] enery, List<Integer> l ){
        int min = Integer.MAX_VALUE;
        int delIndex = 0;
        for(int i = 0; i < l.size(); i++){
            int index = l.get(i);
            min = Math.min(min, enery[index]);
            if(min > enery[index]){
                min = enery[index];
                delIndex = index;
            }
        }
        l.remove(delIndex);
        return min;
    }

    public static void main(String[] args) {
        MinNumberOfHours m = new MinNumberOfHours();
        int initialEnergy = 1;
        int initialExperience = 1;
        int[] energy = {1,1,1,1};
        int[] experience = {1,1,1,50};
        int ret = m.minNumberOfHours(initialEnergy, initialExperience, energy, experience);
        System.out.println(ret);
    }
}
