package com.util;


public class Utils {
	private static int stringToNumber(String a) {
		if(a==null){
			return 0;
		}
		int n = a.hashCode() & 0x7FFFFF;
		return n;
	}
	private static void foo(int f) {
		System.out.println("=====");
		System.out.println(f >> 31);
		System.out.println((f >> 23) & 0xFF);
		System.out.println(f & 0x7FFFFF);;
		
	}
	public static void main(String[] args) {
		System.out.println(stringToNumber("appleappleappleappleappleapple"));
		System.out.println(Integer.MAX_VALUE);
		System.out.println(Integer.MAX_VALUE & 0x7FFFFF);
		System.out.println("=====1".hashCode());
	}
	
}