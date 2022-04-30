//给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。 
//
// 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（
//一个节点也可以是它自己的祖先）。” 
//
// 
//
// 示例 1： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 1
//输出：3
//解释：节点 5 和节点 1 的最近公共祖先是节点 3 。
// 
//
// 示例 2： 
//
// 
//输入：root = [3,5,1,6,2,0,8,null,null,7,4], p = 5, q = 4
//输出：5
//解释：节点 5 和节点 4 的最近公共祖先是节点 5 。因为根据定义最近公共祖先节点可以为节点本身。
// 
//
// 示例 3： 
//
// 
//输入：root = [1,2], p = 1, q = 2
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 树中节点数目在范围 [2, 105] 内。 
// -109 <= Node.val <= 109 
// 所有 Node.val 互不相同 。 
// p != q 
// p 和 q 均存在于给定的二叉树中。 
// 
// Related Topics 树 深度优先搜索 二叉树 
// 👍 1229 👎 0


package com.oj_5th.leetcode.editor.cn;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
*   [236] lowest-common-ancestor-of-a-binary-tree
*   2021-08-01 22:58:31
*/
public class P236LowestCommonAncestorOfABinaryTree{
    public static void main(String[] args) {
        Solution solution = new P236LowestCommonAncestorOfABinaryTree().new Solution();
        // TO TEST
    }
    //[236] lowest-common-ancestor-of-a-binary-tree
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        //队列保存节点
        //遍历队列，节点中是否包含p和q
        //使用dfs判断
        Queue<TreeNode> queue = new LinkedList();
        queue.add(root);
        TreeNode ret =null;
        while (queue.size()>0){
            TreeNode node = queue.poll();
            boolean flag = isContain(node,p,q);
            if(flag==false){
                continue;
            }
            ret = node;
            queue.add(ret.left);
            queue.add(ret.right);
        }
        return ret;
    }
    public boolean isContain(TreeNode root, TreeNode p, TreeNode q){
        boolean ret= false;
        boolean[] flags = new boolean[2];
        dfs(root,p,q, flags);
        if(flags[0]&& flags[1]){
            ret = true;
        }
        return ret;
    }
    public void dfs(TreeNode root, TreeNode p, TreeNode q, boolean[] flags){
        if(root==null){
            return;
        }
        if(root.val==p.val){
            flags[0]=true;
        }else if(root.val==q.val){
            flags[1]=true;
        }
        dfs(root.left, p, q, flags);
        dfs(root.right, p, q, flags);
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}