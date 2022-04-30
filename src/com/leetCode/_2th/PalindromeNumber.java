package com.leetCode._2th;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 * 
 * @author Zealot
 * @date 2016年1月20日 下午10:14:25
 */
public class PalindromeNumber {
	public boolean isPalindrome(int x) {
		char[] cc = String.valueOf(x).toCharArray();
		for(int i = 0, j = cc.length-1; i<j; i++,j--){
			if(cc[i]!=cc[j]){
				return false;
			}
		}
		return true;
	}
	public boolean isPalindrome2(int x) {
	    if (x<0 || (x!=0 && x%10==0)) return false;
	    int rev = 0;
	    while (x>rev){
	        rev = rev*10 + x%10;//从最后一位开始加，倒着加
	        x = x/10;//这样留着前几位
	    }
	    return (x==rev || x==rev/10);
	}
	
	public static void main(String[] args) {
		PalindromeNumber p = new PalindromeNumber();
		System.out.println(p.isPalindrome2(3223));
	}
}
