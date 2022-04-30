package com.leetCode._2th;
/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 1, 11, 21, 1211, 111221, ...

 1 is read off as "one 1" or 11.
 11 is read off as "two 1s" or 21.
 21 is read off as "one 2, then one 1" or 1211.
 Given an integer n, generate the nth sequence.

 Note: The sequence of integers will be represented as a string.
 *
 * @author Zealot
 * @date 2016年2月19日 下午8:30:05
 *
 */
public class CountandSay {
	public String countAndSay(int n) {
		if(n< 0){
			return null;
		}
		if(n==1){
			return "1";
		}
		String s = "";
		String a = "1";
		for(int i = 2;i <= n; i++) {
			s = helper(a);
			a = s;

		}

		return s;
	}
	private static String helper(String str) {
//		String str = String.valueOf(n);
		String reVal ="";
		if(str.length()==1){
			return ""+1+str;
		}
		int count =1;
		for(int i = 0; i < str.length() - 1; i++) {
			if(str.charAt(i) == str.charAt(i + 1)){
				count++;
				if (i == str.length() - 2) {
					reVal = reVal + count+ str.charAt(i);
				}
			}else{

				reVal = reVal + count+ str.charAt(i);
				if (i == str.length() - 2) {
					reVal = reVal + 1+ str.charAt(i+1);
				}
				count = 1;
			}
		}
		return reVal;
	}
	public static void main(String[] args) {
		CountandSay c = new CountandSay();
		System.out.println(c.countAndSay(10));

	}

}
