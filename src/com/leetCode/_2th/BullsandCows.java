package com.leetCode._2th;

import java.util.HashMap;
import java.util.Map;

/**
 * You are playing the following Bulls and Cows game with your friend: You write down a number and ask your friend to guess what the number is. Each time your friend makes a guess, you provide a hint that indicates how many digits in said guess match your secret number exactly in both digit and position (called "bulls") and how many digits match the secret number but locate in the wrong position (called "cows"). Your friend will use successive guesses and hints to eventually derive the secret number.

 For example:

 Secret number:  "1807"
 Friend's guess: "7810"
 Hint: 1 bull and 3 cows. (The bull is 8, the cows are 0, 1 and 7.)
 Write a function to return a hint according to the secret number and friend's guess, use A to indicate the bulls and B to indicate the cows. In the above example, your function should return "1A3B".

 Please note that both secret number and friend's guess may contain duplicate digits, for example:

 Secret number:  "1123"
 Friend's guess: "0111"
 In this case, the 1st 1 in friend's guess is a bull, the 2nd or 3rd 1 is a cow, and your function should return "1A1B".
 You may assume that the secret number and your friend's guess only contain digits, and their lengths are always equal.
 *
 * @author Zealot
 * @date 2016年2月17日 下午9:07:33
 *
 */
public class BullsandCows {
	public String getHint(String secret, String guess) {
		if(secret==null||guess==null){
			return "0A0B";
		}
		String reVal = "";
		int bull = 0;
		for(int i = 0; i < secret.length(); ){
			if(secret.charAt(i)==guess.charAt(i)){
				bull++;
				String end = secret.substring(i+1,secret.length());
				secret = secret.substring(0, i)+end;

				String end2 = guess.substring(i+1,guess.length());
				guess = guess.substring(0, i)+end2;
			}else{
				i++;
			}
		}
		Map<Character,Integer> map = new HashMap<Character,Integer>();
		for(int i = 0; i < secret.length(); i++) {
			if(!map.containsKey(secret.charAt(i))){
				map.put(secret.charAt(i), 1);
			}else{
				map.put(secret.charAt(i), map.get(secret.charAt(i))+1);
			}
		}
		int cows = 0;
		for(int i = 0; i < guess.length(); i++) {
			if(map.containsKey(guess.charAt(i))){

				int size = map.get(guess.charAt(i));
				if(size == 1){
					map.remove(guess.charAt(i));
				}else{
					map.put(guess.charAt(i), size-1);
				}
				cows++;

			}
		}

		return bull+"A"+cows+"B";
	}
	public static void main(String[] args) {
		String s = "1";
		String g = "1";
		BullsandCows b = new BullsandCows();
		System.out.println(b.getHint(s, g));
	}
}
