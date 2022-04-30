package com.leetcode_3th.dfs;

import java.util.Stack;

/**
 * 给定一个经过编码的字符串，返回它解码后的字符串。

编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。

你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。

此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。

示例:

s = "3[a]2[bc]", 返回 "aaabcbc".
s = "3[a2[c]]", 返回 "accaccacc".
s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
 * 
 * @author Zealot
 * @date Aug 1, 2019 2:40:27 PM 
 *
 */
public class DecodeString {
	/**
	 * 用栈来解决，每次遇到“[”就把“[”之前的res塞进stack里，遇到数字就把数字塞进numStack里，
	 * 每次遇到“]”就把stack.pop()和numStack.pop()个res连起来，然后作为新的res，等待下一次被塞进stack里
	 * ，或者被和stack里的元素连接起来，最后返回res即可。

	 * @date Aug 1, 2019 3:24:56 PM
	 * @param s
	 * @return
	 */
	public String decodeString(String s) {
		//special case
        int len = s.length();
        if (len == 0) return "";
        //general case
        Stack<String> strStack = new Stack<>();
        Stack<Integer> numStack = new Stack<>();
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < len; i++) {
            char c = s.charAt(i);
            if (c == '[') {
                strStack.push(res.toString());
                res = new StringBuilder();
            } else if (c == ']') {
                int num = numStack.pop();
                StringBuilder temp = new StringBuilder(strStack.pop());
                for (int j = 0; j < num; j++) {
                    temp.append(res);
                }
                res = temp;
            } else if (Character.isDigit(c)) {
                int num = 0;
                while (i < len && Character.isDigit(s.charAt(i))) {
                    num = num * 10 + s.charAt(i) - '0';
                    i++;
                }
                i--;
                numStack.push(num);
            } else {
                res.append(c);
            }
        }
        return res.toString();
	}
	public static void main(String[] args) {
		String s = "3[a2[c]]";
		DecodeString d = new DecodeString();
		System.out.println(d.decodeString(s));
	}
}
