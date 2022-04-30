package com.leetcode_2th;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月2日 下午10:15:57 
 *
 */
public class NimGame {
	public boolean canWinNim(int n) {
		if(n<=0){
            return false;
        }
        return n%4==0?false:true;
    }
	public static void main(String[] args) {
		NimGame n = new NimGame();
		System.out.println(n.canWinNim(8));
	}
}
