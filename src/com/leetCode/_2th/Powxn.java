package com.leetCode._2th;
/**
 * Implement pow(x, n).
 * 
 * 
 * pow(x,n)就是求x的n次方。x的N次方可以看做：x^n = x^(n/2)*x^(n/2)*x^(n%2)。所以利用递归求解，当n==1的时候，x^n=x。

当然n是可以小于0的，2^(-3) = 1/(2^3)。按照上面那个规律就可以解决了。
 * @author Zealot
 * @date 2016年2月22日 上午9:34:54 
 *
 */
public class Powxn {
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
 
    public double myPow(double x, int n) {
        if (n < 0) {
            return 1 / power(x, -n);
        } else {
            return power(x, n);
        }
    }
	public static void main(String[] args) {
		Powxn p = new Powxn();
		System.out.println(Math.pow(0.00001, 2147483647));
		System.out.println(p.myPow(0.00001, 2147483647));
	}
}
