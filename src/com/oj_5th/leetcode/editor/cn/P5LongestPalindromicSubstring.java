//给你一个字符串 s，找到 s 中最长的回文子串。 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "babad"
//输出："bab"
//解释："aba" 同样是符合题意的答案。
// 
//
// 示例 2： 
//
// 
//输入：s = "cbbd"
//输出："bb"
// 
//
// 示例 3： 
//
// 
//输入：s = "a"
//输出："a"
// 
//
// 示例 4： 
//
// 
//输入：s = "ac"
//输出："a"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 1000 
// s 仅由数字和英文字母（大写和/或小写）组成 
// 
// Related Topics 字符串 动态规划 
// 👍 3801 👎 0


package com.oj_5th.leetcode.editor.cn;
/*
*   [5] longest-palindromic-substring
*   2021-07-08 22:13:28
*/
public class P5LongestPalindromicSubstring{
    public static void main(String[] args) {
        Solution solution = new P5LongestPalindromicSubstring().new Solution();
        // TO TEST
    }
    //[5] longest-palindromic-substring
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String longestPalindrome(String s) {

        String ret = "";
        if (s == null || s.length() == 0) {
            return ret;
        }

        for (int center = 0; center < s.length(); center++) {
            //中心是1位/2位
            String tmp = "";
            if (center + 1 < s.length() && s.charAt(center) == s.charAt(center + 1)) {//2位
                tmp = String.valueOf(s.charAt(center)) + s.charAt(center + 1);
                for (int j = 1; center - j >= 0 && center + j + 1 < s.length(); j++) {
                    if (s.charAt(center - j) == s.charAt(center + j + 1)) {
                        tmp = s.charAt(center - j) + tmp + s.charAt(center + 1 + j);
                    } else {
                        break;
                    }
                }
            }
            ret = tmp.length() > ret.length() ? tmp : ret;
            //1位
            tmp = String.valueOf(s.charAt(center));
            for (int width = 1; center - width >= 0 && center + width < s.length(); width++) {
                if (s.charAt(center - width) == s.charAt(center + width)) {
                    tmp = s.charAt(center - width) + tmp + s.charAt(center + width);
                } else {
                    break;
                }
            }
            ret = tmp.length() > ret.length() ? tmp : ret;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}