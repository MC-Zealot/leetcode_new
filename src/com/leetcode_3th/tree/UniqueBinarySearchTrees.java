package com.leetcode_3th.tree;

/**
 * 
 * 给定一个整数 n，求以 1 ... n 为节点组成的二叉搜索树有多少种？
 * 
 * 示例:
 * 
 * 输入: 3 输出: 5 解释: 给定 n = 3, 一共有 5 种不同结构的二叉搜
 * 
 * @author Zealot
 * @date Jul 26, 2019 10:14:43 AM
 *
 */
public class UniqueBinarySearchTrees {
	/**
	 * 比如，以1为根的树有几个，完全取决于有二个元素的子树有几种。同理，2为根的子树取决于一个元素的子树有几个。以3为根的情况，则与1相同。

定义Count[i] 为以[0,i]能产生的Unique Binary Tree的数目，

如果数组为空，毫无疑问，只有一种BST，即空树，
Count[0] =1

如果数组仅有一个元素{1}，只有一种BST，单个节点
Count[1] = 1

如果数组有两个元素{1,2}， 那么有如下两种可能
1                       2
  \                    /
    2                1
Count[2] = Count[0] * Count[1]   (1为根的情况)
                  + Count[1] * Count[0]  (2为根的情况。

再看一遍三个元素的数组，可以发现BST的取值方式如下：
Count[3] = Count[0]*Count[2]  (1为根的情况)
               + Count[1]*Count[1]  (2为根的情况)
               + Count[2]*Count[0]  (3为根的情况)

所以，由此观察，可以得出Count的递推公式为
Count[i] = ∑ Count[0...k] * [ k+1....i]     0<=k<i-1
问题至此划归为一维动态规划。
	 * @date Jul 26, 2019 11:11:56 AM
	 * @param n
	 * @return
	 */
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
	public static void main(String[] args) {
		UniqueBinarySearchTrees u = new UniqueBinarySearchTrees();
		System.out.println(u.numTrees(3));
	}

}
