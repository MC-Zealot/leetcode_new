package com.indeedWebTest.Numbers;

import java.util.Scanner;
public class Main {
	public static void main(String[] args){
//		Scanner sc = new Scanner(System.in);
//		// get a integer
//		String a = sc.next();
		// output
		
		
		
//		String a = "36452412";
		String a = "4325214";
		int len = a.length();
		String m = "20";
		int M = Integer.parseInt(m);
		
		for(int i = 0; i < M; i++) {
			a = changeFirst(a,len);
		}
		
		
		System.out.println(a);
	}
	private static String changeFirst(String str, int len) {
		int pos = str.charAt(0) - '0';
		String pre = str.substring(1, pos) + pos + str.substring(pos, len);
		System.out.println(pre);
		return pre;
	}
}