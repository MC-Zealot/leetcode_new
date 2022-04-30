package com.leetCode._2th;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string array words, find the maximum value of length(word[i]) *
 * length(word[j]) where the two words do not share common letters. You may
 * assume that each word will contain only lower case letters. If no such two
 * words exist, return 0.
 * 
 * Example 1: Given ["abcw", "baz", "foo", "bar", "xtfn", "abcdef"] Return 16
 * The two words can be "abcw", "xtfn".
 * 
 * Example 2: Given ["a", "ab", "abc", "d", "cd", "bcd", "abcd"] Return 4 The
 * two words can be "ab", "cd".
 * 
 * Example 3: Given ["a", "aa", "aaa", "aaaa"] Return 0 No such pair of words.
 * 
 * @author Zealot
 * @date 2015年12月27日 下午3:11:40
 */
public class MaximumProductofWordLengths {
	public int maxProduct(String[] words) {
		Set<Character> set1 = new HashSet<Character>();
		Set<Character> set2 = new HashSet<Character>();
		int max = 0;
		for (int i = 0; i < words.length - 1; i++) {
			String s1 = words[i];
			char[] cc = s1.toCharArray();
			set1.clear();
			for (int j = 0; j < cc.length; j++) {
				set1.add(cc[j]);
			}
			for (int k = i + 1; k < words.length; k++) {
				String s2 = words[k];
				char[] cc2 = s2.toCharArray();
				set2.clear();
				for (int l = 0; l < cc2.length; l++) {
					if (set1.contains(cc2[l])) {
						set2.clear();
						break;
					}
					set2.add(cc2[l]);
				}
				max = set2.size() * set1.size() > max ? set2.size()
						* set1.size() : max;
			}

		}
		return max;
	}
	public int maxProduct2(String[] words) {
        int n = words.length;
        int[] elements = new int[n];
        for (int i=0;i<n;i++){
            for(int j=0;j<words[i].length();j++){
                elements[i] |= 1 << (words[i].charAt(j) - 'a');
            }
        }
 
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if ((elements[i] & elements[j]) == 0)
                    ans = Math.max(ans,words[i].length() * words[j].length());
            }
        }
        return ans;
    }
	public static void main(String[] args) {
		String[] ss = { "abcw", "baz", "foo", "bar", "xtfn", "abcdef" };
		// String[] ss = {"a", "ab", "abc", "d", "cd", "bcd", "abcd"};
		// String[] ss = {"a", "aa", "aaa", "aaaa"};

		// String[] ss = {"xtfn", "abcdef"};
		MaximumProductofWordLengths mpwl = new MaximumProductofWordLengths();
		System.out.println(mpwl.maxProduct(ss));
		// System.out.println(ss.length);
	}
}
