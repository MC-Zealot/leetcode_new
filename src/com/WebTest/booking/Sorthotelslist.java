package com.WebTest.booking;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeMap;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月11日 下午8:05:08
 *
 */
public class Sorthotelslist {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String words = sc.nextLine();
		String[] wordsArray = words.split(" ");
		Set<String> set = new HashSet<String>();
		for(int i = 0; i < wordsArray.length; i++) {
			System.out.println(wordsArray[i]);
			set.add(wordsArray[i]);
		}
		TreeMap<Integer, Integer> map = new TreeMap<Integer, Integer>();
		int num = sc.nextInt();
		for(int i = 0; i <num; i++) {
			int id = sc.nextInt();
			String content = sc.next();
			
			
			
			if(map.containsKey(id)){
				
			}
		}
	}
}
