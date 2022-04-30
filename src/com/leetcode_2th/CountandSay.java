package com.leetcode_2th;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月4日 下午5:02:33 
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
	/**
	 * 针对输入为整数的计算方式
	 * @date 2016年6月4日 下午5:31:50
	 * @param n
	 * @return
	 */
	public String countAndSay2(int n) {
		if(n< 0){
			return null;
		}
		StringBuffer sb = new StringBuffer();
		int pre = n % 10;
		n = n /10;
		int size = 1;
		while(n!=0){
			int cur = n % 10;
			if(cur==pre){
				size ++;
				if(n/10 == 0){
					sb.append(cur).append(size);
				}
			}else {
				sb.append(pre).append(size);
				size = 1;
			}
			pre = cur;
			n = n / 10;
		}
		sb.append(pre).append(size);
		return sb.reverse().toString();
    }
	
	public static void main(String[] args) {
		CountandSay c = new CountandSay();
		int n = 123;
		System.out.println(c.countAndSay(n));
	}
}
