package com.leetcode_3th.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 给定一个二叉树，检查它是否是镜像对称的。
 * 
 * 例如，二叉树 [1,2,2,3,4,4,3] 是对称的。 1 / \ 2 2 / \ / \ 3 4 4 3
 * 
 * @author Zealot
 * @date Jul 26, 2019 5:41:33 PM
 *
 */
public class SymmetricTree {
	boolean res = false;

	/**
	 * 前序遍历左子树，保存到list中，为空是，当做是null 前序遍历左子树，保存到list2中，为空是，当做是null 如果list1==list2则为对称
	 * 
	 * @date Jul 26, 2019 5:42:59 PM
	 * @param root
	 * @return
	 */
	public boolean isSymmetric(TreeNode root) {
		if(root==null) {
			return true;
		}
		pre_iter(root);
		return res;
	}

	public void pre_iter(TreeNode root) {
		if (root == null) {
			return;
		}
		Queue<TreeNode> q = new LinkedList<TreeNode>();

		if (root.left != null) {
			q.add(root.left);
		}
		if (root.right != null) {
			q.add(root.right);
		}
		if(root.left == null && root.right == null) {
			res=true;
			return ;
		}
		List<TreeNode> H_list = new ArrayList<TreeNode>();
		while (q.size() > 0) {
			TreeNode node = q.poll();
			H_list.add(node);
			if (q.size() > 0) {
				continue;
			}

			res = isPad(H_list);
			if (res == false) {
				break;
			}
			for (int i = 0; i < H_list.size(); i++) {
				if(H_list.get(i)==null) {
					continue;
				}
				if (H_list.get(i).left != null) {
					q.add(H_list.get(i).left);
				}else {
					q.add(null);
				}
				if (H_list.get(i).right != null) {
					q.add(H_list.get(i).right);
				}else {
					q.add(null);
				}
			}
			H_list = new ArrayList<TreeNode>();
		}
	}

	public boolean isPad(List<TreeNode> list) {
		boolean res = false;
		if (list == null || list.size() == 0 || list.size() % 2 == 1) {
			return res;
		}
		for (int i = 0; i < list.size() / 2; i++) {
			if(list.get(i)==null && list.get(list.size() - i - 1)==null) {
				continue;
			}
			if(list.get(i)==null || list.get(list.size() - i - 1)==null) {
				return false;
			}
			if (list.get(i).val != list.get(list.size() - i - 1).val) {
				return false;
			}
		}
		return true;
	}
	
	public boolean  isSymmetric2(TreeNode root) {
        if (root==null) return true;
        return isSymmetric(root.left, root.right);
    }
	public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left==null && right==null) return true;
        if (left!=null && right==null || left==null && right!=null || left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

	public static void main(String[] args) {
		//[1,2,2,null,3,null,3]
		TreeNode t1 = new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(2);
		TreeNode t4 = new TreeNode(3);
		TreeNode t5 = new TreeNode(4);
		TreeNode t6 = new TreeNode(4);
		TreeNode t7 = new TreeNode(3);

		t1.left = t2;
		t1.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		SymmetricTree s = new SymmetricTree();
		System.out.println(s.isSymmetric2(t1));
//		TreeNode t1 = new TreeNode(1);
//		TreeNode t1 = new TreeNode(1);
	}
}
