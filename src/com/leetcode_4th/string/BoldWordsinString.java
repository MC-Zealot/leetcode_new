package com.leetcode_4th.string;

public class BoldWordsinString {
	public String boldWords(String[] words, String S) {
		// 1、遍历所有words，
		// 2、遍历S，看当前字符串S，是否包含word，如果包含则加粗，遍历到lenth(S) - length(word) + 1
		// 合并所有加粗符号，当有两个<b>或者</b>只间隔一个字符的时候，进行合并，当</b>与<b>相邻的时候合并
		// 还需要注意S='ababab',word为bab
		if (S == null || words.length == 0) {
			return S;
		}
		// 记录加粗符号的list，起始符号，或者终止符号。从0开始，第零位为S的第零位的左边，第一位为S的第一位的左边，依次类推
		int[] list = new int[S.length() + 1];
		for (int i = 0; i < words.length; i++) {
			String word = words[i];
			int word_len = word.length();
			for (int j = 0; j < S.length() - word_len + 1; j++) {
				// 判断是否包含word
				String tmp = S.substring(j, j + word_len);
				if (word.equals(tmp)) {
					// 加粗起始位置<b>
					list[j] = 1;
					// 加粗结束位置</b>
					list[j + word_len] = 2;
				}
			}
		}
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		System.out.println();
		// 开始遍历加粗符号的list，进行合并
		// pre,curr
		// 如果pre==curr，如果list[pre_idx]==1，那么list[curr_idx]=0。
		// list[pre_idx]==2，list[pre_idx]==0
		int pre_idx = 0;
		while (list[pre_idx] == 0 && pre_idx < list.length) {
			pre_idx++;
		}
		for (int i = pre_idx + 1; i < list.length; i++) {
			if (list[i] != 0) {
				if (list[pre_idx] == list[i]) {
					if (list[pre_idx] == 1) {
						list[i] = 0;
					} else if (list[pre_idx] == 2) {
						list[pre_idx] = 0;
						pre_idx = i;
					}
				} else {
					pre_idx = i;
				}
			}
		}
		for (int i = 0; i < list.length; i++) {
			System.out.print(list[i] + " ");
		}
		// 开始重新定义返回字符串ret
		StringBuffer sb = new StringBuffer();
		int i = 0;
		for (; i < S.length(); i++) {
			if (list[i] == 1) {
				sb.append("<b>");
			}

			if (list[i] == 2) {
				sb.append("</b>");
			}
			sb.append(S.charAt(i));
		}
		if (list[i] == 2) {
			sb.append("</b>");
		}
		return sb.toString();
	}

	public String boldWords2(String[] words, String S) {
		if (S.length() == 0 || words.length == 0) {
			return S;
		}

		int l = S.length();
		int[] match = new int[l];

		for (String word : words) {
			int idx = 0;
			while (idx < l) {
				int startIdx = S.indexOf(word, idx);
				if (startIdx != -1) {
					for (int i = startIdx; i < startIdx + word.length(); i++) {
						match[i] = 1;
					}

					idx = startIdx + 1;
				} else {
					break;
				}
			}
		}

		String startTag = "<b>";
		String endTag = "</b>";

		StringBuilder sb = new StringBuilder();
		for (int i = 0; i < l; i++) {
			if ((i == 0 || match[i - 1] == 0) && match[i] == 1) {
				sb.append(startTag);
			}
			sb.append(S.charAt(i));
			if ((i == l - 1 || match[i + 1] == 0) && match[i] == 1) {
				sb.append(endTag);
			}
		}

		return sb.toString();
	}
	public static void main(String[] args) {
		BoldWordsinString bws = new BoldWordsinString();
		String[] words = { "ab", "bc" };
		String S = "aabcd";
		String ret = bws.boldWords(words, S);
		System.out.println(ret);
	}
}
