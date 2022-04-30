package com.leetCode._2th;
/**
 * Implement strStr().

 Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * @author Zealot
 * @date 2016年3月4日 上午9:45:34 
 *
 */
public class ImplementstrStr {
	public int strStr(String haystack, String needle) {
		if(haystack.length()<needle.length()){
			return -1;
		}
		for(int i = 0;i < haystack.length() - needle.length() + 1; i++) {
			int index = 0;
			for(int j = i, k = 0; j < haystack.length() && k < needle.length(); j++, k++){
				if(haystack.charAt(j)!=needle.charAt(k)){
					break;
				}
				index++;
			}
			if(index==needle.length()){
				return i;
			}
		}
		return -1;
	}
	/**
	 * 获取double的n位小数，支持四舍五入
	 * @date 2016年3月5日 上午9:43:30
	 * @param a 要获取小数的double
	 * @param n 取n位小数
	 * @return
	 */
	private String getNWeiXiaoShu(double a, int n) {
		String res = new String();
		StringBuffer pre = new StringBuffer();
		if (n <= 0) {
			return pre.toString();
		}
		if (a < 0) {
			a = -a;
		}
		for (int i = 0; i < n; i++) {
			int digit = (int) (a * 10) % 10;
			a = a * 10;
			pre.append(digit);
		}
		// 获取第n+1位小数
		int post = (int) (a * 10) % 10;
		// 如果后边那位大于4，则四舍五入
		if (post > 4) {
			String resStr = pre.toString();
			int carry = 1;//是否要进位
			for(int i = resStr.length()-1; i >= 0; i--){
				char oldDigit = resStr.charAt(i);
				int newDigit = (int)oldDigit-'0';
				newDigit+=carry;//进位
				if(newDigit>=10){
					newDigit = newDigit % 10;
				}else{
					carry= 0;
				}
				res=newDigit+res;
			}
		}else {
			res = pre.toString();
		}
		return res;
	}
	public static void main(String[] args) {
		ImplementstrStr i = new ImplementstrStr();
//		System.out.println(i.strStr("1", "-1"));
		double a = 0.539959;
		System.out.println(a);
		System.out.println(i.getNWeiXiaoShu(a, 4));
		System.out.println(a);
	}
}
