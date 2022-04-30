package com.indeedWebTest._3th._2;

import java.util.Scanner;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年7月9日 下午7:51:10 
 *
 */
public class Main {
	public static void main(String[] args) {
		Scanner in = new Scanner(System.in);
		int a = in.nextInt();
		int b = in.nextInt();
		int k = in.nextInt();
		double curT = a - 0.5;
		double curA = b;
		int sec = 0, round = 0;
		while(sec<Integer.MAX_VALUE){
			double min = Math.min(curT, curA);
			if(min==0){
				min = Math.max(curT, curA);
			}
			if(curT>0){
				curT = curT - min;
			}else{
				curT = a;
				curT = curT - min;
				round++;
				if(round==k){
					System.out.println("Takahashi");
					System.exit(0);
				}
			}
			if(curA!=0){
				curA = curA - min;
			}else{
				curA = b;
				curA = curA - min;
				round++;
				if(round==k){
					System.out.println("Aoki");
					System.exit(0);
				}

			}
		}
		
		
		in.close();
	}
}
