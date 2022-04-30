package com.leetcode_4th.string;

public class RepeatedStringMatch {
	public int repeatedStringMatch(String A, String B) {
		for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == B.charAt(0)) {
                int k = i;
                int count = 1;//循环次数
                int j = 0;
                while (A.charAt(k) == B.charAt(j)) {
                    k++;
                    j++;
                    if (j >= B.length()) return count;
                    if (k >= A.length()) {
                        k = 0;
                        count++;
                    }
                }
            }
        }
        return -1;
	}
	/**
	 * "abcd"
"cdabcdab"
	 * @param args
	 * Created on: Mar 16, 2020 9:48:42 PM
	 */
	public static void main(String[] args) {
		RepeatedStringMatch r = new RepeatedStringMatch();
		String A = "abcd";
		String B = "cdabcdab";
		System.out.println(r.repeatedStringMatch(A, B));
	}
}
