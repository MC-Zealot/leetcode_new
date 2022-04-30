package com.leetCode._1th;

import java.util.HashMap;
import java.util.Map;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?

 For example,
 Given n = 3, there are a total of 5 unique BST's.

 1         3     3      2      1
 \       /     /      / \      \
 3     2     1      1   3      2
 /     /       \                 \
 2     1         2                 3
 * @author Zealot
 * @date 2015年7月22日 下午6:24:54
 */
public class UniqueBinarySearchTrees {



	static Map<Integer, Boolean> map = new HashMap<Integer, Boolean>();

	int N;//已经放置节点的个数
	int sum = 0;//当前已找到的可行方案数
	TreeNode now = new TreeNode(1);

	/**
	 * 对于任意以i为根节点的二叉树，它的左子树的值一定小于i，也就是[0, i - 1]区间，而右子树的值一定大于i，也就是[i + 1, n]。
	 * 假设左子树有m种排列方式，而右子树有n种，则对于i为根节点的二叉树总的排列方式就是m x n。
	 *
	 *  F(i, N) = G(i-1) * G(N-i)
	 *  G(n) = F(1, n) + F(2, n) + ... + F(n, n).
	 * @param n
	 * @return
	 */
	public int numTrees(int n) {
		int [] G = new int[n+1];
		G[0] = G[1] = 1;

		for(int i=2; i<=n; ++i) {
			for(int j=1; j<=i; ++j) {
				G[i] += G[j-1] * G[i-j];
			}
		}

		return G[n];
	}
	public int numTrees2(int n) {
		if(n<1){
			return 0;
		}
		N=n;
		for(int i = 1; i <= n; i++) {
			map.put(i, true);
		}
		System.out.println(map.toString());
		makeBST(1);
		return sum;
	}
	private int findBig(int a,TreeNode root) {
		int reVal = 0;
		for(Integer i: map.keySet()){
			if(i>a){
				reVal = i;
				root.right=new TreeNode(reVal);
				map.put(i, false);
				now=root.right;
				break;
			}
		}
		return reVal;
	}
	private int findSmall(int a,TreeNode root) {
		int reVal = 0;
		for(Integer i: map.keySet()){
			if(i>a){
				reVal = i;
				root.left=new TreeNode(reVal);
				map.put(i, false);
				now=root.left;
				break;
			}
		}
		return reVal;
	}
	private void makeBST(int t) {
		if(t>N){
			sum++;
		}else{
			for(int i = 0; i < N; i++) {
				if(place(t,now)){
					map.remove(t);
					makeBST(t+1);
				}
			}
		}

	}
	private boolean place(int a,TreeNode root){
		return findSmall(a,root)!=0||findBig(a,root)!=0;
	}
	public static void main(String[] args) {
		UniqueBinarySearchTrees u = new UniqueBinarySearchTrees();
		System.out.println(u.numTrees(3));
//		 System.out.println(u.findBig(2));
//		 System.out.println(u.findSmall(2));
//		 System.out.println(list.toString());

	}
}
