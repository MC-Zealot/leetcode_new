package com.leetCode._2th;

/**
 * Implement atoi to convert a string to an integer.
 *
 * Hint: Carefully consider all possible input cases. If you want a challenge,
 * please do not see below and ask yourself what are the possible input cases.
 *
 * Notes: It is intended for this problem to be specified vaguely (ie, no given
 * input specs). You are responsible to gather all the input requirements up
 * front.
 *
 * Update (2015-02-10): The signature of the C++ function had been updated. If
 * you still see your function signature accepts a const char * argument, please
 * click the reload button to reset your code definition.
 *
 * @author Zealot
 * @date 2016年3月6日 下午4:52:48
 *
 */
public class StringtoIntegeratoi {
	public int myAtoi(String str) {
		int res = 0;
		if(str==null||str.length()==0){
			return res;
		}
		str = str.trim();
		char c = str.charAt(0);
		String tmp = str;
		if(String.valueOf(c).equals("-")||String.valueOf(c).equals("+")){
			tmp = tmp.substring(1, str.length());
		}
		int lenCommon = 0;
		for(int i = 0; i < tmp.length();i++) {
			if(String.valueOf(tmp.charAt(i)).equals(".")){
				lenCommon++;
				if(lenCommon==2){
					return res;
				}
				continue;
			}
			if(tmp.charAt(i)-'0'>=10||tmp.charAt(i)-'0'<0){
				return res;
			}
		}


		if(str.contains(".")){
			str = str.substring(0,str.indexOf("."));
		}

		if(String.valueOf(c).equals("-")){
			str = str.substring(1, str.length());
			for(int i = 0; i < str.length();i++) {
				int digit = str.charAt(i) - '0';
				res = res * 10 + digit;
			}
			res = -res;
			return res;
		}
		if(String.valueOf(c).equals("+")){
			str = str.substring(1, str.length());
		}

		for(int i = 0; i < str.length();i++) {
			int digit = str.charAt(i) - '0';
			res = res * 10 + digit;
		}

		return res;
	}
	public int atoi2(String str) {
		if(str==null)
		{
			return 0;
		}
		str = str.trim();
		if(str.length()==0)
			return 0;
		boolean isNeg = false;
		int i = 0;
		if(str.charAt(0)=='-' || str.charAt(0)=='+')
		{
			i++;
			if(str.charAt(0)=='-')
				isNeg = true;
		}
		int res = 0;
		while(i<str.length())
		{
			if(str.charAt(i)<'0'||str.charAt(i)>'9')
				break;
			int digit = (int)(str.charAt(i)-'0');
			if(isNeg && res>-((Integer.MIN_VALUE+digit)/10))
				return Integer.MIN_VALUE;
			else if(!isNeg && res>(Integer.MAX_VALUE-digit)/10)
				return Integer.MAX_VALUE;
			res = res*10+digit;
			i++;
		}
		return isNeg?-res:res;
	}
	public static void main(String[] args) {
		StringtoIntegeratoi s = new StringtoIntegeratoi();
		System.out.println(s.myAtoi("  +1234.56"));
	}
}
