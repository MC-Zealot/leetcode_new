package com.leetcode_2th;
/**
 * Given a string, find the length of the longest substring T that contains at most 2 distinct characters.

For example, Given s = “eceba”,

T is "ece" which its length is 3.
 * 
 * @author Zealot
 * @date 2016年5月3日 下午3:32:35 
 *
 */
public class LongestSubstringwithAtMostTwoDistinctCharacters {
	class Dic {
        int[] counter;
        int kinds;

        public Dic() {
            this.counter = new int[256];
            this.kinds = 0;
        }

        public void add(char c) {
            if (counter[c] == 0) {
                kinds++;
            }
            counter[c]++;
        }

        public void del(char c) {
            counter[c]--;
            if (counter[c] == 0) {
                kinds--;
            }
        }

        public int kinds() {
            return kinds;
        }
    }

    public int lengthOfLongestSubstringTwoDistinct(String s) {
        int length = s.length();
        int left = 0;
        Dic dic = new Dic();
        int res = 0;
        for (int i = 0; i < length; i++) {
            char curC = s.charAt(i);
            dic.add(curC);
            while (dic.kinds > 2) {
                dic.del(s.charAt(left++));
            }
            if (i - left + 1 > res) {
                res = i - left + 1;
            }
        }
        return res;
    }

    public static void main(String[] args) {
    	LongestSubstringwithAtMostTwoDistinctCharacters q = new LongestSubstringwithAtMostTwoDistinctCharacters();
        q.lengthOfLongestSubstringTwoDistinct("eceba");
    }
}
