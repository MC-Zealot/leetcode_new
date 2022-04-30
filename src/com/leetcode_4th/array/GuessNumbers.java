package com.leetcode_4th.array;
/**
 * 
 * @author zealot
 * Created on: Mar 2, 2020 1:41:18 AM
 */
public class GuessNumbers {
	public int game(int[] guess, int[] answer) {
        int ret = 0;
        for(int i = 0; i < 3; i++){
            if(guess[i]==answer[i]){
                ret++;
            }
        }
        return ret;
    }
}
