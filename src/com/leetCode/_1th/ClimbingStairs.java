package com.leetCode._1th;

public class ClimbingStairs {
	public int climbStairs(int n) {
		if(n<=0){
			return 0;
		}
		if(n==1||n==2){
			return n;
		}
		return climbStairs(n-1) + climbStairs(n-2);
	}
	public int climbStairs2(int n) {
	    if(n == 0 || n == 1 || n == 2){return n;}
	    int[] mem = new int[n];
	    mem[0] = 1;
	    mem[1] = 2;
	    for(int i = 2; i < n; i++){
	        mem[i] = mem[i-1] + mem[i-2];
	    }
	    return mem[n-1];
	}
	public static void main(String[] args) {
		ClimbingStairs c = new ClimbingStairs();
		System.out.println(c.climbStairs2(44));
	}
}
