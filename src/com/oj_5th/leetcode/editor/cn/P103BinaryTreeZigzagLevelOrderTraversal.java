//给定一个二叉树，返回其节点值的锯齿形层序遍历。（即先从左往右，再从右往左进行下一层遍历，以此类推，层与层之间交替进行）。 
//
// 例如： 
//给定二叉树 [3,9,20,null,null,15,7], 
//
// 
//    3
//   / \
//  9  20
//    /  \
//   15   7
// 
//
// 返回锯齿形层序遍历如下： 
//
// 
//[
//  [3],
//  [20,9],
//  [15,7]
//]
// 
// Related Topics 树 广度优先搜索 二叉树 
// 👍 467 👎 0


package com.oj_5th.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
*   [103] binary-tree-zigzag-level-order-traversal
*   2021-07-13 00:51:57
*/
public class P103BinaryTreeZigzagLevelOrderTraversal{
    public static void main(String[] args) {
        Solution solution = new P103BinaryTreeZigzagLevelOrderTraversal().new Solution();
        // TO TEST
    }
    //[103] binary-tree-zigzag-level-order-traversal
    //leetcode submit region begin(Prohibit modification and deletion)
//  Definition for a binary tree node.
  public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
    //[103] binary-tree-zigzag-level-order-traversal
class Solution {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root==null){
            return res;
        }
        Queue<TreeNode> q = new LinkedList();
        q.add(root);

        int turn = 0;
        while(q.size() > 0){
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            while(size>0){
                TreeNode t = q.poll();
                l.add(t.val);
                if(t.left!=null){
                    q.add(t.left);
                }
                if(t.right!=null){
                    q.add(t.right);
                }
                size--;
            }
            if (turn % 2 == 1) {
                //turn单数，逆序
                List<Integer> l2 = new ArrayList<>();
                for(int i = l.size() -1; i >=0; i--){
                    l2.add(l.get(i));
                }
                res.add(l2);
                turn++;
            }else{
                res.add(l);
                turn++;
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}