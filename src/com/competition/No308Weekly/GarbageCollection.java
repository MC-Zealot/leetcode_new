package com.competition.No308Weekly;

public class GarbageCollection {
    public int garbageCollection(String[] garbage, int[] travel) {
        int ret = 0;
        int endM = 0;
        int endG = 0;
        int endP = 0;
        for(int i = 0; i < garbage.length; i++){
            String gar = garbage[i];
            if(isContain(gar, 'M')){
                endM = i;
            }
            if(isContain(gar, 'G')){
                endG = i;
            }
            if(isContain(gar, 'P')){
                endP = i;
            }
        }
        for(int i = 0; i <= endM; i++){
            String gar = garbage[i];
            int cnt = getCnt(gar, 'M');
            int t = 0;
            if(i>0){
                t = travel[i - 1];
            }
            int tmp = cnt + t;
            ret += tmp;
        }
        for(int i = 0; i <=endG; i++){
            String gar = garbage[i];
            int cnt = getCnt(gar, 'G');
            int t = 0;
            if(i>0){
                t = travel[i - 1];
            }
            int tmp = cnt + t;
            ret += tmp;
        }
        for(int i = 0; i <=endP; i++){
            String gar = garbage[i];
            int cnt = getCnt(gar, 'P');
            int t = 0;
            if(i>0){
                t = travel[i - 1];
            }
            int tmp = cnt + t;
            ret += tmp;
        }

        return ret;
    }
    public boolean isContain(String garbage, Character g){
        boolean ret = false;
        for(int i = 0; i < garbage.length(); i++){
            if(garbage.charAt(i) == g){
                return true;
            }
        }
        return ret;
    }
    public int getCnt(String garbage, Character g){
        int ret = 0;
        for(int i = 0; i < garbage.length(); i++){
            if(garbage.charAt(i) == g){
                ret++;
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        GarbageCollection gc = new GarbageCollection();
        String[] garbage = {"MMM","PGM","GP"};
        int[] travel = {3,10};
        int ret = gc.garbageCollection(garbage, travel);
        System.out.println(ret);
    }
}
