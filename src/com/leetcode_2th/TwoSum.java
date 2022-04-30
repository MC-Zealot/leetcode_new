package com.leetcode_2th;

import java.util.HashMap;
import java.util.Map;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年4月17日 下午2:29:31 
 *
 */
public class TwoSum {
	/**
	 * 时间复杂度：O(n)
	 * 空间复杂度：O(n)
	 * @date 2016年4月17日 下午2:29:37
	 * @param a
	 * @param m
	 * @return
	 */
	public int[] twoSum(int[] a, int m) {
        Map<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] res = new int[2];
        int len = a.length;
        for(int i = 0; i < len; i++) {
            if(map.containsKey(m-a[i])){
                res[0] = map.get(m - a[i]);
                res[1] = i;
                return res;
            }else{
                map.put(a[i], i);
            }
        }
        return res;
    }
}
