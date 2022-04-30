package com.leetcode_2th;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月5日 下午2:39:32 
 *
 */
public class Powxn {
	/**
	 * time: O(n)
	 * @date 2016年6月5日 下午2:46:53
	 * @param x
	 * @param n
	 * @return
	 */
	public double myPow(double x, int n) {
		double flag = 1;
		double res = 1;
		if(n==0){
			return 1;
		}
		if(n<0){
			n = -n;
			flag = -1;
		}
		while(n!=0){
			res = res * x;
			n--;
		}
		if(flag == -1){
			return 1.0/res;
		}
		return res;
    }
	public double power(double x, int n) {
        if (n == 0)
            return 1;
 
        double v = power(x, n / 2);
 
        if (n % 2 == 0) {
            return v * v;
        } else {
            return v * v * x;
        }
    }
	/**
	 * O(logn)
	 * 二分法
	 * @date 2016年6月5日 下午2:56:41
	 * @param x
	 * @param n
	 * @return
	 */
    public double myPow2(double x, int n) {
        if (n < 0) {
            return 1 / power(x, -n);
        } else {
            return power(x, n);
        }
    }
	public static void main(String[] args) {
		int a = 3;
		int b = 6;
		System.out.println(Math.pow(a, b));
		Powxn p = new Powxn();
		System.out.println(p.myPow(a, b));
	}
}
