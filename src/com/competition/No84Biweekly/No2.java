package com.competition.No84Biweekly;

import java.util.HashMap;
import java.util.Map;

/**
 * 统计坏数对的数目
 *坏数对: i < j 且 j - i != nums[j] - nums[i]
 */
public class No2 {

    public long countBadPairs(int[] nums) {
        HashMap<Integer, Long> cnt = new HashMap<>();
        long ans = 0;
        for(int i = 0; i < nums.length; i++) {
            long val = cnt.getOrDefault(i - nums[i], 0L);
            ans += val;
            cnt.put(i - nums[i], val + 1);
        }
        return (1L + nums.length - 1) * (nums.length - 1) / 2 - ans;
    }

    /**
     * 越界
     * @param nums
     * @return
     */
    public long countBadPairs2(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length; i++){
            int x = nums[i] - i;
            if(map.containsKey(x)){
                map.put(x, map.get(x) + 1);
            }else{
                map.put(x, 1);
            }
        }
        long diff = 0;
        for(Integer i: map.keySet()){
            int count = map.get(i);
            diff += count * (count - 1)/ 2;
        }
        int n = nums.length;

        return (1L + n - 1) * (n - 1) / 2 - diff;
    }


    public static void main(String[] args) {
        No2 n = new No2();
        int[] a  ={4,1,3,3};
        long ret = n.countBadPairs(a);
        System.out.println(ret);
    }
}
