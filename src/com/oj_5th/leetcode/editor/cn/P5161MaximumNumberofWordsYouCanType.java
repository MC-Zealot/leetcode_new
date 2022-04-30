package com.oj_5th.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

public class P5161MaximumNumberofWordsYouCanType {
    //5161. Maximum Number of Words You Can Type
    public int canBeTypedWords(String text, String brokenLetters) {
        int ret = 0;
        if(text==null){
            return ret;
        }
        ret = text.split(" ").length;
        Set<Character> s = new HashSet<>();
        for(int i = 0; i < brokenLetters.length(); i++){
            char c = brokenLetters.charAt(i);
            s.add(c);
        }
        for(int i = 0; i < text.split(" ").length; i++){
            String word = text.split(" ")[i];
            for(int j = 0; j < word.length(); j++){
                if(s.contains(word.charAt(j))){
                    ret--;
                    break;
                }
            }
        }
        return ret;
    }
}
