package com.leetcode_2th;
/**
 * Given an integer n, return the number of trailing zeroes in n!.
n!得到的数当中，从后边数，连续有几个0
Note: Your solution should be in logarithmic time complexity.
 * 
 * @author Zealot
 * @date 2016年6月10日 下午1:00:27 
 *
 */
public class FactorialTrailingZeroes {
	public int trailingZeroes(int n) {
		int n5 = 0;
		for(int i = 1; i <= n; i++){
			int a = i;
			
			while(a!=0 && a % 5 ==0){
				n5++;
				a = a / 5;
			}
		}
		
        return n5;
    }
	/**
	 * TLE
	 * @date 2016年6月10日 下午1:45:37
	 * @param n
	 * @return
	 */
	public int trailingZeroes2(int n) {
		int x = 5;
	    int ans = 0;
        while (n >= x){
        	ans += n / x;
        	x *= 5;
        }
	    return ans;
	}
	/**
	 * AC
	 * @date 2016年6月10日 下午1:45:58
	 * @param n
	 * @return
	 */
	public int trailingZeroes3(int n) {
		int r = 0;
	    while (n > 0) {
	        n /= 5;
	        r += n;
	    }
	    return r;
    }
	public static void main(String[] args) {
		FactorialTrailingZeroes f = new FactorialTrailingZeroes();
		System.out.println(f.trailingZeroes(7));
	}
}
