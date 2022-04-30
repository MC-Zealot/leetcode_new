//给定一个字符串数组 arr，字符串 s 是将 arr 某一子序列字符串连接所得的字符串，如果 s 中的每一个字符都只出现过一次，那么它就是一个可行解。 
//
// 请返回所有可行解 s 中最长长度。 
//
// 
//
// 示例 1： 
//
// 输入：arr = ["un","iq","ue"]
//输出：4
//解释：所有可能的串联组合是 "","un","iq","ue","uniq" 和 "ique"，最大长度为 4。
// 
//
// 示例 2： 
//
// 输入：arr = ["cha","r","act","ers"]
//输出：6
//解释：可能的解答有 "chaers" 和 "acters"。
// 
//
// 示例 3： 
//
// 输入：arr = ["abcdefghijklmnopqrstuvwxyz"]
//输出：26
// 
//
// 
//
// 提示： 
//
// 
// 1 <= arr.length <= 16 
// 1 <= arr[i].length <= 26 
// arr[i] 中只含有小写英文字母 
// 
// Related Topics 位运算 数组 字符串 回溯 
// 👍 174 👎 0


package com.oj_5th.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/*
*   [1239] maximum-length-of-a-concatenated-string-with-unique-characters
*   2021-08-08 19:36:48
*/
public class P1239MaximumLengthOfAConcatenatedStringWithUniqueCharacters{
    public static void main(String[] args) {
        Solution solution = new P1239MaximumLengthOfAConcatenatedStringWithUniqueCharacters().new Solution();
        // TO TEST
    }
    //[1239] maximum-length-of-a-concatenated-string-with-unique-characters
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
        public int maxLength(List<String> arr) {
            if(arr==null || arr.size()==0){
                return 0;
            }
            List<String> new_arr = new ArrayList<>();
            for(int i = 0; i < arr.size(); i++){
                if(isValid(arr.get(i))){
                    new_arr.add(arr.get(i));
                }
            }
            if(new_arr.size()==0){
                return 0;
            }
            List<String> res_list = new ArrayList<String>();
            dfs(arr, "", 0, res_list);
            int ret = 0;
            for(int i = 0; i < res_list.size(); i++){
                ret = Math.max(ret, res_list.get(i).length());
            }
            return ret;
        }
        public void dfs(List<String> arr, String s, int index, List<String> res_list){
            if(isValid(s)){
                res_list.add(s);
            }
            for(int i = index; i < arr.size(); i++){
                s=s+arr.get(i);
                dfs(arr,s,i+1,res_list);
                s=s.substring(0, s.length() - arr.get(i).length());
            }
        }

        public boolean isValid(String str){
            Set<String> set = new HashSet<String>();
            for(int i = 0; i < str.length(); i++){
                String tmp = String.valueOf(str.charAt(i));
                if(set.contains(tmp)){
                    return false;
                }
                set.add(tmp);
            }
            return true;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}