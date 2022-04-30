package com.leetcode_2th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月13日 上午10:35:44
 *
 */
public class ValidateBinarySearchTree {
	/**
	 * 暴力破解
	 * TIME: O(n^2)
	 * SPACE: O()
	 * @date 2016年5月13日 下午1:58:12
	 * @param root
	 * @return
	 */
	public boolean isValidBST(TreeNode root) {
		if (root == null)
			return true;
		return isSubtreeLessThan(root.left, root.val) && isSubtreeGreaterThan(root.right, root.val) && isValidBST(root.left) && isValidBST(root.right);
	}

	private boolean isSubtreeLessThan(TreeNode p, int val) {
		if (p == null)
			return true;
		return p.val < val && isSubtreeLessThan(p.left, val) && isSubtreeLessThan(p.right, val);
	}

	private boolean isSubtreeGreaterThan(TreeNode p, int val) {
		if (p == null)
			return true;
		return p.val > val && isSubtreeGreaterThan(p.left, val) && isSubtreeGreaterThan(p.right, val);
	}

}
