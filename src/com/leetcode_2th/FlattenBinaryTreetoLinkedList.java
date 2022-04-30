package com.leetcode_2th;

import java.util.ArrayList;
import java.util.List;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.
 * 
 * @author Zealot
 * @date 2016年7月7日 上午9:47:16 
 *
 */
public class FlattenBinaryTreetoLinkedList {
	public void flatten(TreeNode root) {
		List<TreeNode> pre = new ArrayList<TreeNode>();
		pre.add(null);
		helper(root, pre);
	}

	private void helper(TreeNode root, List<TreeNode> pre) {
		if (root == null)
			return;
		TreeNode right = root.right;
		if (pre.get(0) != null) {
			pre.get(0).left = null;
			pre.get(0).right = root;
		}
		pre.set(0, root);
		helper(root.left, pre);
		helper(right, pre);
	}
}
