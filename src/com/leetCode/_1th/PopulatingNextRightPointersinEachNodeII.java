package com.leetCode._1th;

import com.leetCode.CommonStructure.TreeLinkNode;

/**
 * Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL
 * @author Zealot
 * @date 2015年8月18日 上午8:19:23
 */
public class PopulatingNextRightPointersinEachNodeII {
	public TreeLinkNode nextFinder(TreeLinkNode node){
        if(node == null){
        	return null;
        }
        if(node.left != null) {
        	return node.left;
        }
        if(node.right != null) {
        	return node.right;
        }
        return nextFinder(node.next);
    }


    public void connect2(TreeLinkNode root) {
        if(root != null){
    
            if(root.left != null) {
            	root.left.next = root.right;
            }
            if(root.right != null) {
            	root.right.next = null;
            }
        
        
            if(root.next != null && root.right != null){
                root.right.next = nextFinder(root.next);
            }else if(root.next != null && root.left != null){
                root.left.next = nextFinder(root.next);
            }
        
            if(root.right != null)  {
            	connect(root.right);
            }
            if(root.left != null)  {
            	connect(root.left);
            }
        }
    }
	public void connect(TreeLinkNode root) {
		if(root!=null){
			if(root.left!=null&&root.right!=null){
				root.left.next = root.right;
			}
			while(root.next!=null){
				
				if(root.left!=null&&root.right==null&&root.next.left!=null){
					root.left.next=root.next.left;
					root=root.next;
				}else if(root.left!=null&&root.right==null&&root.next.left==null&&root.next.right!=null){
					root.left.next=root.next.right;
					root=root.next;
				}else if(root.right!=null&&root.next.left!=null){
					root.right.next=root.next.left;
					root=root.next;
				}else if(root.right!=null&&root.next.left==null&&root.next.right!=null){
					root.right.next=root.next.right;
					root=root.next;
				}else if((root.next.left==null&&root.next.right==null)||(root.left==null&&root.right==null)){
					root=root.next;
				}else{
					root=root.next;
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
//		t2.left = t4;
//		t2.right = t5;
		t3.left = t6;
		t3.right = t7;
		PopulatingNextRightPointersinEachNodeII p = new PopulatingNextRightPointersinEachNodeII();
		p.connect(t);
		System.out.println(t.next==null?"null":t.next.val);
		System.out.println(t2.next==null?"null":t2.next.val);
		System.out.println(t3.next==null?"null":t3.next.val);
		System.out.println(t4.next==null?"null":t4.next.val);
		System.out.println(t5.next==null?"null":t5.next.val);
		System.out.println(t6.next==null?"null":t6.next.val);
		System.out.println(t7.next==null?"null":t7.next.val);
	}
}
