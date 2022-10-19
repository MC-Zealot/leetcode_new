//给定一个仅包含数字 2-9 的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。 
//
// 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。 
//
// 
//
// 
//
// 示例 1： 
//
// 
//输入：digits = "23"
//输出：["ad","ae","af","bd","be","bf","cd","ce","cf"]
// 
//
// 示例 2： 
//
// 
//输入：digits = ""
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：digits = "2"
//输出：["a","b","c"]
// 
//
// 
//
// 提示： 
//
// 
// 0 <= digits.length <= 4 
// digits[i] 是范围 ['2', '9'] 的一个数字。 
// 
// Related Topics 哈希表 字符串 回溯 
// 👍 1410 👎 0


package com.oj_5th.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
*   [17] letter-combinations-of-a-phone-number
*   2021-07-25 15:57:44
*/
public class P17LetterCombinationsOfAPhoneNumber{
    public static void main(String[] args) {
        Solution solution = new P17LetterCombinationsOfAPhoneNumber().new Solution();
        // TO TEST
        System.out.println(solution.letterCombinations2("23"));
    }
    //[17] letter-combinations-of-a-phone-number
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {

    public List<String> letterCombinations(String digits) {
        List<String> ret = new ArrayList<String>();
        if(digits==null ||digits.length()==0){
            return ret;
        }
        Map<String, String[]> map = new HashMap<String, String[]>();
        String[] two = {"a","b","c"};
        String[] three = {"d", "e", "f"};
        String[] four = {"g", "h", "i"};
        String[] five = {"j", "k", "l"};
        String[] six = {"m", "n", "o"};
        String[] seven = {"p", "q", "r", "s"};
        String[] eight = {"t", "u", "v"};
        String[] nine = {"w", "x", "y", "z"};
        map.put("2",two);
        map.put("3",three);
        map.put("4",four);
        map.put("5",five);
        map.put("6",six);
        map.put("7",seven);
        map.put("8",eight);
        map.put("9",nine);

        dfs(digits,0, ret, new String(), map);
        return ret;
    }

    public void dfs(String digits, int index, List<String> ret, String tmp, Map<String, String[]> map) {
        if(tmp.length() == digits.length()){
            ret.add(tmp);
            return;
        }
        for (int i = 0; i < map.get(String.valueOf(digits.charAt(index))).length; i++) {
            tmp = tmp + map.get(String.valueOf(digits.charAt(index)))[i];
            dfs(digits, index+1, ret, tmp, map);
            tmp = tmp.substring(0, tmp.length() - 1);
        }
    }

        public List<String> letterCombinations2(String digits) {
            String[] ss = new String[10];
            ss[2] = "abc";
            ss[3] = "def";
            ss[4] = "ghi";
            ss[5] = "jkl";
            ss[6] = "mno";
            ss[7] = "pqrs";
            ss[8] = "tuv";
            ss[9] = "wxyz";
            List<String> ret = new ArrayList<String>();
            dfs(digits, ss, ret, "", 0);
            return ret;
        }
        public void dfs(String digits, String[] ss, List<String> ret, String tmp, int index){

            if(tmp.length() == digits.length()){
                ret.add(tmp);
                return;
            }
            if(index >= digits.length()){
                return;
            }
            int digit = Integer.parseInt(String.valueOf(digits.charAt(index)));
            String str = ss[digit];
            for(int i = 0; i < str.length(); i++){
                tmp+= String.valueOf(str.charAt(i));
                dfs(digits, ss, ret, tmp, index + 1);
                tmp = tmp.substring(0, tmp.length() - 1);
            }
        }


}
//leetcode submit region end(Prohibit modification and deletion)

}