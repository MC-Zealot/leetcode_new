package com.indeedWebTest._3th._1;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * 
 * There are two strings: S and T. Choose the two letters x and y, which can be
 * the same letter. Then replace all occurrences of x with y in the strings S
 * and T. Output Possible if the letters x and y exist that make the strings S
 * and T the same after this process is done, or Impossible if they do not.
 * 
 * 
 * @author Zealot
 * @date 2016年7月9日 下午6:59:50
 *
 */
public class Main {
	static String res = "Impossible";
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		String s = in.next();
		String t = in.next();
		if(s==null||t==null){
			System.out.println("Impossible");
			System.exit(0);
		}
		if(s.equals(t)){
			System.out.println("Possible");
			System.exit(0);
		}else if(s.length()!=t.length()){
			System.out.println("Impossible");
			System.exit(0);
		}
		
		dfs(s, t, 0, new ArrayList<String>());
		dfs(t, s, 0, new ArrayList<String>());
		
		System.out.println(res);
		in.close();
	}
	private static void dfs(String s, String t, int cur, List<String> list) {
		if(list.size()==2){
			//2个字符串s和t都进行替换，是否相等。
			String x = list.get(0);
			String y = list.get(1);
			String repS = s.replace(x, y);
			String repT = t.replace(x, y);
			if(repS.equals(repT)){
				res = "Possible";
				return;
			}
		}
		for(int i = cur; i < s.length(); i++) {
			list.add(String.valueOf(s.charAt(i)));
			dfs(s, t, i + 1, list);
			list.remove(list.size() -1);
		}
	}
}
