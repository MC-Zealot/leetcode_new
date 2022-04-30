package com.WebTest.booking.test;

public class Staircase {

	static void StairCase(int n) {
		if(n<=0){
			return;
		}
		for(int i = 1; i <= n; i++) {
			for(int j = n - i; j >0; j--) {
				System.out.print(" ");
			}
			for(int j = 0; j < i; j++) {
				System.out.print("#");
			}
			System.out.println();
		}
    }
	public static void main(String[] args) {
		Staircase.StairCase(6);
	}
}
