package com.leetcode_3th.tree;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 在上次打劫完一条街道之后和一圈房屋后，小偷又发现了一个新的可行窃的地区。这个地区只有一个入口，我们称之为“根”。 
 * 除了“根”之外，每栋房子有且只有一个“父“房子与之相连。一番侦察之后，聪明的小偷意识到“这个地方的所有房屋的排列类似于一棵二叉树”。 
 * 如果两个直接相连的房子在同一天晚上被打劫，房屋将自动报警。

计算在不触动警报的情况下，小偷一晚能够盗取的最高金额。

示例 1:

输入: [3,2,3,null,3,null,1]

     3
    / \
   2   3
    \   \ 
     3   1

输出: 7 
解释: 小偷一晚能够盗取的最高金额 = 3 + 3 + 1 = 7.
示例 2:

输入: [3,4,5,1,3,null,1]

     3
    / \
   4   5
  / \   \ 
 1   3   1

输出: 9
解释: 小偷一晚能够盗取的最高金额 = 4 + 5 = 9.
 * 
 * @author Zealot
 * @date Jul 29, 2019 1:43:11 PM 
 *
 */
public class HouseRobberIII {
	public int rob(TreeNode root) {
        return dfs(root)[0];
    }
    /**
     * 这就可以归结为树的递归遍历问题。对于任意一个节点，如下图三角虚线内，该子树的最大值一定是下面两个可能：

root + left_left + left_right + right_left + right_right
left + right
所以对于任意一个节点，只要递归的调用这个关系，就可以得到解。
     * @date Jul 29, 2019 2:07:59 PM
     * @param root
     * @return
     */
    private int[] dfs(TreeNode root) {
        int dp[]={0,0};
        if(root != null){
            int[] dp_L = dfs(root.left);
            int[] dp_R = dfs(root.right);
            dp[1] = dp_L[0] + dp_R[0];
            dp[0] = Math.max(dp[1] ,dp_L[1] + dp_R[1] + root.val);
        }
        return dp;
    }
}
