package com.competition.No309Weekly;

import java.util.HashMap;
import java.util.Map;

public class CheckDistances {
    public boolean checkDistances(String s, int[] distance) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(map.containsKey(c)){
                int index = map.get(c);
                int dist = i -  index  - 1;
                int dist2 = distance[c - 'a'];
                if(dist != dist2){
                    return false;
                }
            }else{
                map.put(c, i);
            }
        }
        return true;
    }
}
