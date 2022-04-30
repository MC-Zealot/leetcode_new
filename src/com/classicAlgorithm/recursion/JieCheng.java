package com.classicAlgorithm.recursion;
/**
 * 计算阶乘
 * 
 * @author Zealot
 * @date 2016年7月12日 下午9:13:16 
 *
 */
public class JieCheng {
	private int cal(int n ) {
		if(n==1){
			return 1;
		}
		return n * cal(n - 1);
	}

	private String _10To2(int a) {
		StringBuffer sb = new StringBuffer();
		while (a > 0) {
			sb.append(a % 2);
			a = a / 2;
		}
		return sb.reverse().toString();
	}
	private String _10To2_2(int a) {
		StringBuffer res = new StringBuffer();
		help(a, res);
		return res.reverse().toString();
	}
	private int help(int a, StringBuffer res) {
		if(a==0){
			return 0;
		}
		res.append(a % 2);
		return help(a/2, res);
	}
	public static void main(String[] args) {
		JieCheng j = new JieCheng();
		System.out.println(j._10To2_2(4));
	}
}
