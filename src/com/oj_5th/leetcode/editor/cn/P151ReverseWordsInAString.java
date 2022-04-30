//给你一个字符串 s ，逐个翻转字符串中的所有 单词 。 
//
// 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。 
//
// 请你返回一个翻转 s 中单词顺序并用单个空格相连的字符串。 
//
// 说明： 
//
// 
// 输入字符串 s 可以在前面、后面或者单词间包含多余的空格。 
// 翻转后单词间应当仅用一个空格分隔。 
// 翻转后的字符串中不应包含额外的空格。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：s = "the sky is blue"
//输出："blue is sky the"
// 
//
// 示例 2： 
//
// 
//输入：s = "  hello world  "
//输出："world hello"
//解释：输入字符串可以在前面或者后面包含多余的空格，但是翻转后的字符不能包括。
// 
//
// 示例 3： 
//
// 
//输入：s = "a good   example"
//输出："example good a"
//解释：如果两个单词间有多余的空格，将翻转后单词间的空格减少到只含一个。
// 
//
// 示例 4： 
//
// 
//输入：s = "  Bob    Loves  Alice   "
//输出："Alice Loves Bob"
// 
//
// 示例 5： 
//
// 
//输入：s = "Alice does not even like bob"
//输出："bob like even not does Alice"
// 
//
// 
//
// 提示： 
//
// 
// 1 <= s.length <= 104 
// s 包含英文大小写字母、数字和空格 ' ' 
// s 中 至少存在一个 单词 
// 
//
// 
// 
//
// 
//
// 进阶： 
//
// 
// 请尝试使用 O(1) 额外空间复杂度的原地解法。 
// 
// Related Topics 字符串 
// 👍 332 👎 0


package com.oj_5th.leetcode.editor.cn;

import java.util.Stack;

/*
*   151 reverse-words-in-a-string
*   2021-06-20 21:46:16
*/
public class P151ReverseWordsInAString{
    public static void main(String[] args) {
        Solution solution = new P151ReverseWordsInAString().new Solution();
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public String reverseWords(String s) {
        if(s==null){
            return s;
        }
        s = s.trim().replace("    ", " ").replace("   ", " ").replace("  ", " ");
        String[] ss = s.split(" ");
        StringBuffer res = new StringBuffer();
        Stack<String> stack = new Stack<String>();
        for(int i= 0; i < ss.length; i++) {
            stack.push(ss[i]);
        }
        while(!stack.isEmpty()){
            res.append(stack.pop()).append(" ");
        }
        return res.substring(0, res.length()-1).toString();
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}