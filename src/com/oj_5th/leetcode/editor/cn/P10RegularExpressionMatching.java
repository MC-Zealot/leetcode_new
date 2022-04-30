//给你一个字符串 s 和一个字符规律 p，请你来实现一个支持 '.' 和 '*' 的正则表达式匹配。 
//
// 
// '.' 匹配任意单个字符 
// '*' 匹配零个或多个前面的那一个元素 
// 
//
// 所谓匹配，是要涵盖 整个 字符串 s的，而不是部分字符串。 
// 
//
// 示例 1： 
//
// 
//输入：s = "aa" p = "a"
//输出：false
//解释："a" 无法匹配 "aa" 整个字符串。
// 
//
// 示例 2: 
//
// 
//输入：s = "aa" p = "a*"
//输出：true
//解释：因为 '*' 代表可以匹配零个或多个前面的那一个元素, 在这里前面的元素就是 'a'。因此，字符串 "aa" 可被视为 'a' 重复了一次。
// 
//
// 示例 3： 
//
// 
//输入：s = "ab" p = ".*"
//输出：true
//解释：".*" 表示可匹配零个或多个（'*'）任意字符（'.'）。
// 
//
// 示例 4： 
//
// 
//输入：s = "aab" p = "c*a*b"
//输出：true
//解释：因为 '*' 表示零个或多个，这里 'c' 为 0 个, 'a' 被重复一次。因此可以匹配字符串 "aab"。
// 
//
// 示例 5： 
//
// 
//输入：s = "mississippi" p = "mis*is*p*."
//输出：false 
//
// 
//
// 提示： 
//
// 
// 0 <= s.length <= 20 
// 0 <= p.length <= 30 
// s 可能为空，且只包含从 a-z 的小写字母。 
// p 可能为空，且只包含从 a-z 的小写字母，以及字符 . 和 *。 
// 保证每次出现字符 * 时，前面都匹配到有效的字符 
// 
// Related Topics 递归 字符串 动态规划 
// 👍 2261 👎 0


package com.oj_5th.leetcode.editor.cn;
/*
*   [10] regular-expression-matching
*   2021-07-25 12:08:38
*/
public class P10RegularExpressionMatching{
    public static void main(String[] args) {
        Solution solution = new P10RegularExpressionMatching().new Solution();
        // TO TEST
        System.out.println(solution.isMatch("aaa","a*a"));
    }
    //[10] regular-expression-matching
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public boolean isMatch(String s,String p){
            if (s == null || p == null) {
                return false;
            }
            boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];
            dp[0][0] = true;//dp[i][j] 表示 s 的前 i 个是否能被 p 的前 j 个匹配
            for (int i = 0; i < p.length(); i++) { // here's the p's length, not s's
                if (p.charAt(i) == '*' && dp[0][i - 1]) {
                    dp[0][i + 1] = true; // here's y axis should be i+1
                }
            }
            for (int i = 0; i < s.length(); i++) {
                for (int j = 0; j < p.length(); j++) {
                    if (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i)) {//如果是任意元素 或者是对于元素匹配
                        dp[i + 1][j + 1] = dp[i][j];
                    }
                    if (p.charAt(j) == '*') {
                        if (p.charAt(j - 1) != s.charAt(i) && p.charAt(j - 1) != '.') {//如果前一个元素不匹配 且不为任意元素
                            dp[i + 1][j + 1] = dp[i + 1][j - 1];
                        } else {
                            dp[i + 1][j + 1] = (dp[i + 1][j] || dp[i][j + 1] || dp[i + 1][j - 1]);
                            /*
                            dp[i][j] = dp[i-1][j] // 多个字符匹配的情况
                            or dp[i][j] = dp[i][j-1] // 单个字符匹配的情况
                            or dp[i][j] = dp[i][j-2] // 没有匹配的情况
                             */

                        }
                    }
                }
            }
            return dp[s.length()][p.length()];
        }
    public boolean isMatch2(String s, String p) {
        //while循环，两个指针，sp,pp。根据pp情况遍历sp
        //pp++规则： 如果是字符则比较是否完全相等。 sp++
        //          如果是.则pp和sp都各自进一位。 sp++
        //          如果是*，则看sp上一位字符和当前字符是否一样。如果一样则返回true，如果不同则返回false;如果sp是第一位也返回false。 sp++
        int sp = 0;
        int pp = 0;
        while (pp < p.length() && sp<s.length()) {
            char pchar = p.charAt(pp);
            char schar = s.charAt(sp);
            if(pchar=='.'){
                pp++;
                sp++;
                continue;
            }
            if(pchar=='*' && pp>0){
                char pchar_pre = p.charAt(pp-1);
                if(pchar_pre=='.'||pchar_pre == schar){
                    sp++;
                }
                else {
                    pp++;
                }
                continue;
            }else if (pchar == '*' && pp == 0) {
                return false;
            }
            if(schar==pchar){
                pp++;
                sp++;
                continue;
            }else{
                if(pp+1 < p.length() && p.charAt(pp+1)=='*'){
                    pp++;
                    continue;
                }
                return false;
            }
        }
        if(sp<s.length() || (pp<p.length() && p.charAt(pp)!='*')||(pp<p.length()-1 && p.charAt(pp)=='*')){
            return false;
        }
        return true;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}