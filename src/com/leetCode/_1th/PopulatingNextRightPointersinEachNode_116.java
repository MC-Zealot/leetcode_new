package com.leetCode._1th;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.leetCode.CommonStructure.TreeLinkNode;

/**
 * 
Initially, all next pointers are set to NULL.

Note:

You may only use constant extra space.
You may assume that it is a perfect binary tree (ie, all leaves are at the same level, and every parent has two children).
For example,
Given the following perfect binary tree,
         1
       /  \
      2    3
     / \  / \
    4  5  6  7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \  / \
    4->5->6->7 -> NULL
 * @author Zealot
 * @date 2015年7月21日 下午8:45:52
 */
public class PopulatingNextRightPointersinEachNode_116 {
	static Map<Integer, List<TreeLinkNode>> map = new HashMap<Integer, List<TreeLinkNode>>();
	int now = 0;

	public void connect_des(TreeLinkNode root) {
		connect2(root);
		for (Integer i : map.keySet()) {
			List<TreeLinkNode> list = map.get(i);

			for (int j = 0; j < list.size() - 1; j++) {
				TreeLinkNode tree = list.get(j);
				TreeLinkNode tree2 = list.get(j + 1);
				tree.next = tree2;
			}
		}
	}

	private void connect2(TreeLinkNode root) {
		if (root != null) {
			now++;
			if (map.get(now) == null) {
				List<TreeLinkNode> list = new LinkedList<TreeLinkNode>();
				list.add(root);
				map.put(now, list);
			} else {
				List<TreeLinkNode> list = map.get(now);
				list.add(root);
				map.put(now, list);
			}
			if (root.left != null) {
				connect2(root.left);
			}
			if (root.right != null) {
				connect2(root.right);
			}
			now--;
		}

	}

	public void connect(TreeLinkNode root) {
		if(root!=null) {
			if(root.left!=null){
				root.left.next=root.right;
				if(root.next!=null){
					root.right.next = root.next.left;
				}
			}
			if (root.left != null) {
				connect(root.left);
			}
			if (root.right != null) {
				connect(root.right);
			}
		}

	}
	/**
	 * 广度优先遍历，先用next进行一层遍历，再用root.left进入下一层。
	 * @param root
	 */
	public void connect3(TreeLinkNode root) {
        if(root!=null){
            connect4(root);
        }
    }
    public void connect4(TreeLinkNode root) {
        if(root.left!=null){
            root.left.next=root.right;
            TreeLinkNode n = root;
            while(n.next!=null){
                n.right.next=n.next.left;
                n.next.left.next=n.next.right;
                n=n.next;
            }
            connect2(root.left);
        }
    }
	public static void main(String[] args) {
		TreeLinkNode t = new TreeLinkNode(1);
		TreeLinkNode t2 = new TreeLinkNode(2);
		TreeLinkNode t3 = new TreeLinkNode(3);
		TreeLinkNode t4 = new TreeLinkNode(4);
		TreeLinkNode t5 = new TreeLinkNode(5);
		TreeLinkNode t6 = new TreeLinkNode(6);
		TreeLinkNode t7 = new TreeLinkNode(7);
		t.left = t2;
		t.right = t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		PopulatingNextRightPointersinEachNode_116 p = new PopulatingNextRightPointersinEachNode_116();
		p.connect_des(t);
		// for(Integer i: map.keySet()){
		// List<TreeLinkNode> list = map.get(i);
		// System.out.print(i+":");
		// for(TreeLinkNode tree: list){
		// System.out.print(tree.val);
		// }
		// System.out.println();
		// }
	}
}
