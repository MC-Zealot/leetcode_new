package com.leetCode._2th;

import java.util.ArrayList;
import java.util.List;

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
 * @date 2016年3月6日 下午9:00:57
 *
 */
public class PermutationSequence {
	String res = "";
	int index = 0;
	/**
	 * 排列一般从0开始 组合从cur下一个开始
	 * @date 2016年3月6日 下午10:03:53
	 * @param n
	 * @param k
	 * @return
	 */
	public String getPermutation(int n, int k) {
		if(n<=0||k<0){
			return res;
		}
		backtracing(n, k, new boolean[n], 0, new ArrayList<Integer>());
		return res;
	}

	private void backtracing(int n, int k, boolean[] a, int cur, List<Integer> list) {
		if(list.size()==n&&++index==k){
			StringBuffer sb = new StringBuffer();
			for(int i = 0; i < n; i++) {
				sb.append(list.get(i));
			}
			res = sb.toString();
			a = new boolean[n];
			return ;
		}
		for(int i = 0; i < n; i++) {
			if(a[i]==false){
				list.add(i+1);
				a[i]=true;
				backtracing(n, k, a, cur+1, list);
				list.remove(list.size()-1);
				a[i] = false;
			}
		}

	}
	public String getPermutation2(int n, int k) {
		if(n<=0)  {
			return "";
		}
		k--;
		StringBuilder res = new StringBuilder();
		int factorial = 1;
		ArrayList<Integer> nums = new ArrayList<Integer>();
		for (int i = 2; i < n; i++) {
			factorial *= i;
		}
		for (int i = 1; i <= n; i++) {
			nums.add(i);
		}
		int round = n - 1;
		while (round >= 0) {
			int index = k / factorial;
			k %= factorial;
			res.append(nums.get(index));
			nums.remove(index);
			if (round > 0)
				factorial /= round;
			round--;
		}
		return res.toString();
	}
	public static void main(String[] args) {
		PermutationSequence p  = new PermutationSequence();
		System.out.println(p.getPermutation(3, 2));
	}
}
