//给定一个只包括 '('，')'，'{'，'}'，'['，']' 的字符串 s ，判断字符串是否有效。 
//
// 有效字符串需满足： 
//
// 
// 左括号必须用相同类型的右括号闭合。 
// 左括号必须以正确的顺序闭合。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "()"
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：s = "()[]{}"
//输出：true
// 
//
// 示例 3： 
//
// 
//输入：s = "(]"
//输出：false
// 
//
// 示例 4： 
//
// 
//输入：s = "([)]"
//输出：false
// 
//
// 示例 5： 
//
// 
//输入：s = "{[]}"
//输出：true 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 仅由括号 '()[]{}' 组成 
// 
// Related Topics 栈 字符串 
// 👍 2527 👎 0


package com.oj_5th.leetcode.editor.cn;

import java.nio.charset.Charset;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/*
*   [20] valid-parentheses
*   2021-08-01 21:28:56
*/
public class P20ValidParentheses{
    public static void main(String[] args) {
        Solution solution = new P20ValidParentheses().new Solution();
        System.out.println(solution.isValid("([)]"));
        // TO TEST
    }
    //[20] valid-parentheses
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean isValid(String s) {
        if (s == null || s.length() == 0 || s.length() % 2 == 1){
            return false;
        }
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            if (stack.size() > 0) {//比较顶部节点与当前字符串的节点是否相等，如果相等，则出栈，如果不等，则压栈
                if(map.containsKey(stack.peek())==false){
                    return false;
                }else if(s.charAt(i)== map.get(stack.peek())){
                    stack.pop();
                }else{
                    stack.add(s.charAt(i));
                }
            } else {
                stack.add(s.charAt(i));
            }
        }
        if(stack.size()>0){
            return false;
        }else{
            return true;
        }
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}