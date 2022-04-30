package com.leetCode._2th;

import java.util.ArrayList;
import java.util.List;

/**
 * Implement a basic calculator to evaluate a simple expression string.

The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . 
The integer division should truncate toward zero.

You may assume that the given expression is always valid.

Some examples:
"3+2*2" = 7
" 3/2 " = 1
" 3+5 / 2 " = 5
遇乘除计算。然后按照顺序计算一次加减的值。
 * 
 * @author Zealot
 * @date 2016年4月6日 下午9:01:31 
 *
 */
public class BasicCalculatorII {
	public int calculate(String s) {  
        if (s == null || "".equals(s.trim())) {  
            return 0;  
        }  
        s = s.replaceAll("\\s", "");  
        List<Long> list1 = new ArrayList<Long>();  
        List<Character> list2 = new ArrayList<Character>();  
        int len = s.length();  
        int i = 0;  
        while (i < len) {  
            char c = s.charAt(i);  
            if (c >= '0' && c <= '9') {  
                long array[] = getNum(s, i);  
                list1.add(array[0]);  
                i = (int) array[1];  
            } else if (c == '+' || c == '-') {  
                list2.add(c);  
            } else if (c == '*' || c == '/') {  
                int size = list1.size();  
                long num1 = list1.get(size - 1);  
                long array[] = getNum(s, i + 1);  
                long num2 = array[0];  
                i = (int) array[1];  
                long num = c == '*' ? num1 * num2 : num1 / num2;  
                list1.set(size - 1, num);  
            }  
            i++;  
        }  
        int size2 = list2.size();  
        long preNum = list1.get(0);  
        for (i = 0; i < size2; i++) {  
            if (list2.get(i) == '+') {  
                preNum += list1.get(i + 1);  
            } else {  
                preNum -= list1.get(i + 1);  
            }  
        }  
        return (int) preNum;  
    }  
  
    private long[] getNum(String s, int curPos) {  
        StringBuffer sb = new StringBuffer();  
        int len = s.length();  
        while (curPos < len && s.charAt(curPos) >= '0' && s.charAt(curPos) <= '9') {  
            sb.append(s.charAt(curPos));  
            curPos++;  
        }  
        String newStr = sb.toString();  
        if (newStr.length() > 0) {  
            return new long[]{Long.parseLong(newStr), curPos - 1};  
        }  
        return new long[]{0, curPos - 1};  
    }  
}
