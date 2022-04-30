package com.leetcode_2th;
/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

For example,
Given n = 3, there are a total of 5 unique BST's.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
 * 
 * @author Zealot
 * @date 2016年6月15日 下午2:17:39 
 *
 */
public class UniqueBinarySearchTrees {
	public int numTrees(int n) {
		if (n <= 0){
			return 0;
		}
		int[] res = new int[n + 1];//含有i个结点的二叉查找树的数量
		res[0] = 1;
		res[1] = 1;
		for (int i = 2; i <= n; i++) {
			for (int j = 0; j < i; j++) {
				res[i] += res[j] * res[i - j - 1];//选取一个结点为根，就把结点切成左右子树，以这个结点为根的可行二叉树数量就是左右子树可行二叉树数量的乘积
			}
		}
		return res[n];
	}
}
