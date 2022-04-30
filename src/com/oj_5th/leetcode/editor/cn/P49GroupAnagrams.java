//给定一个字符串数组，将字母异位词组合在一起。可以按任意顺序返回结果列表。 
//
// 字母异位词指字母相同，但排列不同的字符串。 
//
// 
//
// 示例 1: 
//
// 
//输入: strs = ["eat", "tea", "tan", "ate", "nat", "bat"]
//输出: [["bat"],["nat","tan"],["ate","eat","tea"]] 
//
// 示例 2: 
//
// 
//输入: strs = [""]
//输出: [[""]]
// 
//
// 示例 3: 
//
// 
//输入: strs = ["a"]
//输出: [["a"]] 
//
// 
//
// 提示： 
//
// 
// 1 <= strs.length <= 104 
// 0 <= strs[i].length <= 100 
// strs[i] 仅包含小写字母 
// 
// Related Topics 哈希表 字符串 排序 
// 👍 812 👎 0


package com.oj_5th.leetcode.editor.cn;

import java.util.*;

/*
*   [49] group-anagrams
*   2021-08-08 16:16:41
*/
public class P49GroupAnagrams{
    public static void main(String[] args) {
        Solution solution = new P49GroupAnagrams().new Solution();
        // TO TEST
    }
    //[49] group-anagrams
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ret = new ArrayList<>();
        if(strs.length == 0){
            return ret;
        }
        String[] tmp = new String[strs.length];
        Map<String, List<String>> map = new HashMap<>();
        for(int i = 0; i < strs.length; i++){
            String str = strs[i];
            char[] cc = str.toCharArray();
            Arrays.sort(cc);
            String key = String.valueOf(cc);
            if(map.containsKey(key)){
                map.get(key).add(str);
            }else{
                List<String> list = new ArrayList<>();
                list.add(str);
                map.put(key, list);
            }
        }
        for(String key : map.keySet()){
            ret.add(map.get(key));
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}