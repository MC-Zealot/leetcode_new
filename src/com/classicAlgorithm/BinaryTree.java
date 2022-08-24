package com.classicAlgorithm;


import java.util.*;

import apple.laf.JRSUIUtils;
import com.leetCode.CommonStructure.TreeNode;
import javafx.util.Pair;

public class BinaryTree {
	protected TreeNode root;

	public BinaryTree(TreeNode root) {
		this.root = root;
	}

	public TreeNode getRoot() {
		return root;
	}


	/** 访问节点 */
	public static void visit(TreeNode p) {
		System.out.print(p.val + " ");
	}

	/** 递归实现前序遍历 */
	protected static void preorder(TreeNode p) {
		if (p != null) {
			visit(p);
			preorder(p.left);
			preorder(p.right);
		}
	}

	/** 递归实现中序遍历 */
	protected static void inorder(TreeNode p) {
		if (p != null) {
			inorder(p.left);
			visit(p);
			inorder(p.right);
		}
	}

	/** 递归实现后序遍历 */
	protected static void postorder(TreeNode p) {
		if (p != null) {
			postorder(p.left);
			postorder(p.right);
			visit(p);
		}
	}

	/** 非递归实现前序遍历 */
	protected static void iterativePreorder(TreeNode p) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		if (p != null) {
			stack.push(p);
			while (!stack.empty()) {
				p = stack.pop();
				visit(p);
				if (p.right != null)
					stack.push(p.right);
				if (p.left != null)
					stack.push(p.left);
			}
		}
	}

	/** 非递归实现前序遍历2 */
	protected static void iterativePreorder2(TreeNode p) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {//压入所有的左节点，压入前访问它
				visit(node);
				stack.push(node);
				node = node.left;
			}
			if (stack.size() > 0) {//
				node = stack.pop();
				node = node.right;
			}
		}
	}

	/** 非递归实现后序遍历 */
	protected static void iterativePostorder(TreeNode p) {
		TreeNode q = p;
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (p != null) {
			// 左子树入栈
			for (; p.left != null; p = p.left)
				stack.push(p);
			// 当前节点无右子或右子已经输出
			while (p != null && (p.right == null || p.right == q)) {
				visit(p);
				q = p;// 记录上一个已输出节点
				if (stack.empty())
					return;
				p = stack.pop();
			}
			// 处理右子
			stack.push(p);
			p = p.right;
		}
	}

	/** 非递归实现后序遍历 双栈法 */
	protected static void iterativePostorder2(TreeNode p) {
		Stack<TreeNode> lstack = new Stack<TreeNode>();
		Stack<TreeNode> rstack = new Stack<TreeNode>();
		TreeNode node = p, right;
		do {
			while (node != null) {
				right = node.right;
				lstack.push(node);
				rstack.push(right);
				node = node.left;
			}
			node = lstack.pop();
			right = rstack.pop();
			if (right == null) {
				visit(node);
			} else {
				lstack.push(node);
				rstack.push(null);
			}
			node = right;
		} while (lstack.size() > 0 || rstack.size() > 0);
	}

	/** 非递归实现后序遍历 单栈法*/
	protected static void iterativePostorder3(TreeNode p) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = p, prev = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			if (stack.size() > 0) {
				TreeNode temp = stack.peek().right;
				if (temp == null || temp == prev) {
					node = stack.pop();
					visit(node);
					prev = node;
					node = null;
				} else {
					node = temp;
				}
			}

		}
	}

	/** 非递归实现后序遍历4 双栈法*/
	protected static void iterativePostorder4(TreeNode p) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		Stack<TreeNode> temp = new Stack<TreeNode>();
		TreeNode node = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				temp.push(node);
				stack.push(node);
				node = node.right;
			}
			if (stack.size() > 0) {
				node = stack.pop();
				node = node.left;
			}
		}
		while (temp.size() > 0) {
			node = temp.pop();
			visit(node);
		}
	}

	/** 非递归实现中序遍历 */
	protected static void iterativeInorder(TreeNode p) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		while (p != null) {
			while (p != null) {
				if (p.right != null)
					stack.push(p.right);// 当前节点右子入栈
				stack.push(p);// 当前节点入栈
				p = p.left;
			}
			p = stack.pop();
			while (!stack.empty() && p.right == null) {
				visit(p);
				p = stack.pop();
			}
			visit(p);
			if (!stack.empty())
				p = stack.pop();
			else
				p = null;
		}
	}

	/** 非递归实现中序遍历2 */
	protected static void iterativeInorder2(TreeNode p) {
		Stack<TreeNode> stack = new Stack<TreeNode>();
		TreeNode node = p;
		while (node != null || stack.size() > 0) {
			while (node != null) {
				stack.push(node);
				node = node.left;
			}
			if (stack.size() > 0) {
				node = stack.pop();
				visit(node);
				node = node.right;
			}
		}
	}
	public static List<Integer>  inorderTraversal(TreeNode root) {
	    Stack<TreeNode> stack = new Stack<TreeNode>();
		List<Integer> res = new ArrayList<Integer>();

		while(root != null || !stack.isEmpty()){
			while(root!=null){       // 不断地向左结点深入，直至叶子结点
				stack.push(root);
				root = root.left;
			}
			TreeNode top = stack.pop();
			res.add(top.val);
			root = top.right;
		}
		return res;
	}

	/**
	 * 前序遍历：中，左，右
	 * 中序遍历：左，中，右
	 * 后序遍历：左，右，中
	 *
	 * 本题需要中序遍历。
	 *
	 * 栈是一种 先进后出的结构，出栈顺序为左，中，右
	 * 那么入栈顺序必须调整为倒序，也就是右，中，左
	 *
	 * 同理，如果是前序遍历，入栈顺序为 右，左，中；后序遍历，入栈顺序中，右，左
	 */
	public static List<Integer> inorderTraversalNew(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		if (root == null) {
			return ret;
		}
		int white = 0;
		int grey = 1;
		Stack<Pair<Integer, TreeNode>> s = new Stack<>();
		s.add(new Pair(white, root));
		while (s.size() > 0) {
			Pair<Integer, TreeNode> p = s.pop();
			int color = p.getKey();
			TreeNode node = p.getValue();
			if (node == null) {
				continue;
			}
			if (color == white) {
				s.add(new Pair<>(white, node.right));
				s.add(new Pair<>(grey, node));
				s.add(new Pair<>(white, node.left));
			} else {
				ret.add(node.val);
			}
		}
		return ret;
	}

	/**
	 * 中序遍历顺序： 左 中 右
	 * 前序遍历顺序： 中 左 右
	 * 后续遍历顺序： 左 右 中
	 * 把节点放到栈里边
	 * 每个节点有是否被遍历的属性
	 * 如果没有被遍历到，则add其右，中，左
	 * @param root
	 * @return
	 */
	public static List<Integer> inorderTraversalNew2(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		if (root == null) {
			return ret;
		}
		Stack<Pair<Boolean, TreeNode>> s = new Stack<>();
		s.add(new Pair(false, root));
		while (s.size() > 0) {
			Pair<Boolean, TreeNode> p = s.pop();
			Boolean flag = p.getKey();
			TreeNode node = p.getValue();
			if (node == null) {
				continue;
			}
			if (flag == false) {
				s.add(new Pair<>(false, node.right));
				s.add(new Pair<>(true, node));
				s.add(new Pair<>(false, node.left));
			} else {
				ret.add(node.val);
			}
		}
		return ret;
	}
	public List<Integer> preorderTraversal(TreeNode root) {
		List<Integer> ret = new ArrayList<>();
		preOrder(root, ret);
		return ret;
	}
	public static void preOrder(TreeNode root, List<Integer> ret){
		if(root==null){
			return;
		}
		ret.add(root.val);
		preOrder(root.left, ret);
		preOrder(root.right, ret);
	}

	private static  TreeNode init() {
		TreeNode root = new TreeNode(1);
		TreeNode node2 = new TreeNode(2);
		TreeNode node3 = new TreeNode(5);
		TreeNode node4 = new TreeNode(3);
		TreeNode node5 = new TreeNode(4);
		root.left = node2;
		root.right = node3;
		node2.left = node4;
		node2.right = node5;
		return root;
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		BinaryTree tree = new BinaryTree(init());
		System.out.print(" Pre-Order:");
		preorder(tree.getRoot());
		System.out.println();
		System.out.print("  In-Order:");
		inorder(tree.getRoot());
		System.out.println();
		System.out.print("Post-Order:");
		postorder(tree.getRoot());
		System.out.println();
		System.out.print(" Pre-Order:");
		iterativePreorder(tree.getRoot());
		System.out.println();
		System.out.print("Pre-Order2:");
		iterativePreorder2(tree.getRoot());
		System.out.println();
		System.out.print("  In-Order:");
		iterativeInorder(tree.getRoot());
		System.out.println();
		System.out.print(" In-Order2:");
		iterativeInorder2(tree.getRoot());
		System.out.println();
		System.out.print(" In-Order3:");
		inorderTraversal(tree.getRoot());
		System.out.println();
		System.out.print(" Post-Order:");
		iterativePostorder(tree.getRoot());
		System.out.println();
		System.out.print("Post-Order2:");
		iterativePostorder2(tree.getRoot());
		System.out.println();
		System.out.print("Post-Order3:");
		iterativePostorder3(tree.getRoot());
		System.out.println();
		System.out.print("Post-Order4:");
		iterativePostorder4(tree.getRoot());
		System.out.println();
		System.out.print("In-Order New:");
		List<Integer> ret = inorderTraversalNew(tree.getRoot());
		System.out.println(ret);
		System.out.println();

	}

}

