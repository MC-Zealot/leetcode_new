package com.leetcode_6th;

import java.util.List;

public class WordBreak {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] dp = new boolean[s.length()];
        for(int i = 0;i < s.length(); i++){
            for(int j = 0; j < wordDict.size(); j++){
                String word = wordDict.get(j);
                if(i >= word.length() - 1 && (i == word.length() - 1 || dp[i - word.length()] == true  )){
                    if(s.substring(i - word.length() + 1, i + 1).equals(word)){
                        dp[i] = true;
                        break;
                    }
                }
            }
        }
        return dp[s.length() - 1];
    }
}
