package com.WebTest.booking.test;

import java.util.Scanner;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月11日 下午7:10:09 
 *
 */
public class SumThemAll {
	public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum = 0;
		for(int i = 0; i < num; i++) {
			sum+=sc.nextInt();
		}
		System.out.println(sum);
		sc.close();
    }
}
