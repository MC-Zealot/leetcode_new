package com.leetCode._2th;

/**
 * Given a string, determine if it is a palindrome, considering only
 * alphanumeric characters and ignoring cases.
 * 
 * For example, "A man, a plan, a canal: Panama" is a palindrome. "race a car"
 * is not a palindrome.
 * 
 * @author Zealot
 * @date 2016年2月1日 上午10:34:33
 */
public class ValidPalindrome {
	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		char[] cc = s.toCharArray();
		int left = 0,right = cc.length-1;
		while(left< right){
//			System.out.println("left: "+cc[left]+", "+(cc[left]-'a'));
			if(cc[left]-'a'>26||cc[left]-'a'<0){
				if(!(cc[left]-'0'>=0&&cc[left]-'0'<=9)){
					left++;
					continue;
				}
			}
			if(cc[right]-'a'>25||cc[right]-'a'<0){//不是字母
				if(!(cc[right]-'0'>=0&&cc[right]-'0'<=9)){//不是数字
					right--;
					continue;
				}
			}
			
			if(cc[left] == cc[right]){
				left++;right--;
			}else{
				return false;
			}
			
		}
		
		return true;
	}
	public static void main(String[] args) {
		ValidPalindrome vp = new ValidPalindrome();
//		System.out.println(vp.isPalindrome("A man, a plan, a canal: Panama"));
		System.out.println(vp.isPalindrome("ab2a"));
//		System.out.println('c'=='c');
		
	}
	
}
