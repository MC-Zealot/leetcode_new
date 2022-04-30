package com.leetcode_2th;
/**
 * The set [1,2,3,…,n] contains a total of n! unique permutations.

By listing and labeling all of the permutations in order,
We get the following sequence (ie, for n = 3):

"123"
"132"
"213"
"231"
"312"
"321"
Given n and k, return the kth permutation sequence.
 * 
 * @author Zealot
 * @date 2016年8月3日 上午10:35:39 
 *
 */
public class PermutationSequence {
	
	public String getPermutation(int n, int k) {
		 
		 String str = "123456789".substring(0, n);
		 char[] res =new char[n];
		 for(int i = 0; i < n; i++) {
//			 res[i] = help(str,k);
		 }
		 return String.valueOf(res);
    }
	//求正整数n的阶乘
	int factorial(int n) {
		int res = 1;
		for (int i = 2; i <= n; i++)
			res *= i;
		return res;
	}
	public static void main(String[] args) {
		PermutationSequence p = new PermutationSequence();
		System.out.println(p.getPermutation(3, 2));
	}
}
