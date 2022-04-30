package com.leetcode_2th;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 * Given a string s and a dictionary of words dict, add spaces in s to construct a sentence 
 * 
 * where each word is a valid dictionary word.

Return all such possible sentences.

For example, given
s = "catsanddog",
dict = ["cat", "cats", "and", "sand", "dog"].

A solution is ["cats and dog", "cat sand dog"].
 * 
 * @author Zealot
 * @date 2016年6月20日 下午4:56:17 
 *
 */
public class WordBreakII {
	public boolean wordBreakcheck(String s, Set<String> dict) {
        if(s==null || s.length()==0){
        	return true;
        }
        boolean[] res = new boolean[s.length()+1];
        res[0] = true;
        for(int i=0;i<s.length();i++){
            StringBuilder str = new StringBuilder(s.substring(0,i+1));
            for(int j=0;j<=i;j++){
                if(res[j] && dict.contains(str.toString())){
                    res[i+1] = true;
                    break;
                }
                str.deleteCharAt(0);
            }
        }
        return res[s.length()];
    }
    
    public ArrayList<String> wordBreak(String s, Set<String> dict) {  
        ArrayList<String> res = new ArrayList<String>();  
        if(s==null || s.length()==0)  
            return res;
        if(wordBreakcheck(s,dict))
            helper(s,dict,0,"",res);  
        return res;  
    }  
    private void helper(String s, Set<String> dict, int start, String item, ArrayList<String> res){  
        if(start>=s.length()){  
            res.add(item);  
            return;  
        }
        
        StringBuilder str = new StringBuilder();  
        for(int i=start;i<s.length();i++){  
            str.append(s.charAt(i));  
            if(dict.contains(str.toString())){  
                String newItem = new String();  
                if(item.length()>0){
                	newItem = item + " " + str.toString();
                } else{
                	newItem = str.toString();
                }
                helper(s,dict,i+1,newItem,res);  
            }  
        }  
    }
    public static void main(String[] args) {
    	WordBreakII w = new WordBreakII();
    	String s = "catsanddog";
    	Set<String> dict = new HashSet<String>();
    	dict.add("cat");
    	dict.add("cats");
    	dict.add("and");
    	dict.add("sand");
    	dict.add("dog");
    	w.wordBreak(s, dict);
	}
}
