package com.WebTest.booking;

import java.util.Scanner;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月11日 下午7:47:07
 *
 */
public class Polygons {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int squares = 0;
		int rectangles = 0;
		int others = 0;
		while(sc.hasNextLine()){
			int a = 0;
			if(sc.hasNext()){
				a = sc.nextInt();
			}else{
				others++;
				break;
			}
			int b = 0;
			if(sc.hasNext()){
				b = sc.nextInt();
			}else{
				others++;
				break;
			}
			int c = 0;
			if(sc.hasNext()){
				c = sc.nextInt();
			}else{
				others++;
				break;
			}
			int d = 0;
			if(sc.hasNext()){
				d = sc.nextInt();
			}else{
				others++;
				break;
			}
			if(a<=0||b<=0||c<=0||d<=0){
				others++;
			}else{
				if(a==b&&b==c&&c==d){
					squares++;
				}else if(a==c&&b==d){
					rectangles++;
				}else{
					others++;
				}
			}
		}
		System.out.println(squares+" "+rectangles+" "+others);
		sc.close();
	}
}
