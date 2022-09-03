package com.competition.No308Weekly;

import java.util.Stack;

public class RemoveStars {
    public String removeStars(String s) {
        if(s == null){
            return s;
        }
        Stack<Character> stack = new Stack<Character>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(c != '*'){
                stack.add(c);
            }else{
                stack.pop();
            }
        }
        Stack<Character> stack2 = new Stack<Character>();
        while(stack.size() > 0){
            stack2.add(stack.pop());
        }
        StringBuffer sb = new StringBuffer();
        while(stack2.size() > 0){
            sb.append(stack2.pop());
        }
        return sb.toString();
    }

}
