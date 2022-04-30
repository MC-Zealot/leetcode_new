package com.leetCode._2th;

/**
 * Given an integer n, return the number of trailing zeroes in n!.

Note: Your solution should be in logarithmic time complexity.
给定一个整数n，返回n!（n的阶乘）数字中的后缀0的个数。

注意：你的解法应该满足多项式时间复杂度。
 * @author Zealot
 * @date 2016年1月11日 下午10:34:48
 */
public class FactorialTrailingZeroes {
	/**
	 * WA
	 * @date 2016年6月10日 下午1:27:22
	 * @param n
	 * @return
	 */
	@Deprecated
	public int trailingZeroes(int n) {
	   if(n<0){
		   return 0;
	   }
	   int num=0;
	   long a = 1;
	   System.out.println(n);
	   for(int i = 1; i <= n;i++){
		   a*=i;
	   }
	   System.out.println(a);
	   String aStr = String.valueOf(a);
	   char[] cc = aStr.toCharArray();
	   for(int i = 0; i < cc.length; i++){
		   if(cc[i]=='0'){
			   num++;
		   }
	   }
	   return num;
	}
	public int trailingZeroes2(int n) {
		int x = 5;
	    int ans = 0;
        while (n >= x){
        	ans += n / x;
        	x *= 5;
        }
	    return ans;
	}
	public int trailingZeroes3(int n) {
		return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
	}
	public static void main(String[] args) {
		 FactorialTrailingZeroes ftz = new FactorialTrailingZeroes();
		 System.out.println(ftz.trailingZeroes(7));
	}
}
