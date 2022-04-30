//数字 n 代表生成括号的对数，请你设计一个函数，用于能够生成所有可能的并且 有效的 括号组合。 
//
// 
//
// 示例 1： 
//
// 
//输入：n = 3
//输出：["((()))","(()())","(())()","()(())","()()()"]
// 
//
// 示例 2： 
//
// 
//输入：n = 1
//输出：["()"]
// 
//
// 
//
// 提示： 
//
// 
// 1 <= n <= 8 
// 
// Related Topics 字符串 动态规划 回溯 
// 👍 1942 👎 0


package com.oj_5th.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/*
*   [22] generate-parentheses
*   2021-08-03 22:17:11
*/
public class P22GenerateParentheses{
    public static void main(String[] args) {
        Solution solution = new P22GenerateParentheses().new Solution();
        // TO TEST
        System.out.println(solution.generateParenthesis(3));
    }
    //[22] generate-parentheses
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        dfs(n, new StringBuffer(), res, 0, 0);
        return res;
    }
    public void dfs(int n, StringBuffer sb, List<String> res, int l, int r){
        if(l<r){
            return;
        }
        if(sb.length()== n * 2){
            res.add(sb.toString());
            return;
        }
        if(l < n){
            dfs(n, sb.append("("), res, l+1,r);
            sb.deleteCharAt(sb.length()-1);
        }
        if(r < n){
            dfs(n, sb.append(")"), res, l, r + 1);
            sb.deleteCharAt(sb.length()-1);
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}