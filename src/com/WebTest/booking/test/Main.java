package com.WebTest.booking.test;

import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		/*Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        for(int i = 0 ; i < n; i++){
            for(int j = 0; j < n; j++) {
                if(j <= n - i - 1 - 1){
                    System.out.print(" ");
                }else{
                    System.out.print("#");
                }
            }
            System.out.println();
        }
        in.close();*/
		savethePrisoner();
        
	}
	private static void savethePrisoner() {
		Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        int[][] a = new int[t][3];
        for(int i = 0; i < t; i++) {
        	for(int j = 0; j < 3; j++){
        		a[i][j] = in.nextInt();
        	}
        }
        for(int i = 0; i < t; i++) {
			int n = a[i][0], m = a[i][1], s = a[i][2];
				int tmp = (m % n + s - 1) % n;
				System.out.println(tmp==0?n:tmp);
        }
        in.close();
	}
}
