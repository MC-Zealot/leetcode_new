package com.WebTest.booking;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月11日 下午7:32:40
 *
 */
public class Sumof2numbersinanarray {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int target = sc.nextInt();
		int m = sc.nextInt();
		int[] nums = new int[m];
		for(int i = 0; i < m; i++) {
			nums[i]=sc.nextInt();
		}
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		boolean flag = false;
		for(int i = 0; i < m; i++) {
			if(map.containsKey(target-nums[i])){
				flag = true;
            	System.out.println("1");
            	break;
            }else{
                map.put(nums[i], i);
            }
		}
		if(flag==false){
			System.out.println("0");
		}
		sc.close();
	}
}
