package com.leetCode._2th;

import com.leetCode.CommonStructure.TreeNode;

/**
 * Given a complete binary tree, count the number of nodes.
 * 
 * Definition of a complete binary tree from Wikipedia: In a complete binary
 * tree every level, except possibly the last, is completely filled, and all
 * nodes in the last level are as far left as possible. It can have between 1
 * and 2h nodes inclusive at the last level h.
 * 
 * @author Zealot
 * @date 2016年4月6日 下午8:31:59
 *
 */
public class CountCompleteTreeNodes {
	public int countNodes(TreeNode root) {
		if(root==null){
			return 0;
		}
		
		return preTrace(root);
    }
	private int preTrace(TreeNode node) {
		int sum = 1;
		if(node.left!=null){
			sum+=preTrace(node.left);
		}
		if(node.right!=null){
			sum+=preTrace(node.right);
		}
		return sum;
	}
	
	public int countNodes2(TreeNode root) {  
        if(root==null) return 0;  
          
        int l = getLeft(root) + 1;  
        int r = getRight(root) + 1;  
          
        if(l==r) {  
            return (2<<(l-1)) - 1;  
        } else {  
            return countNodes(root.left) + countNodes(root.right) + 1;  
        }  
    }  
      
    private int getLeft(TreeNode root) {  
        int count = 0;  
        while(root.left!=null) {  
            root = root.left;  
            ++count;  
        }  
        return count;  
    }  
      
    private int getRight(TreeNode root) {  
        int count = 0;  
        while(root.right!=null) {  
            root = root.right;  
            ++count;  
        }  
        return count;  
    } 
	public static void main(String[] args) {
		TreeNode t =new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 =new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(5);
		t.left=t2;
		t.right=t3;
		t2.left = t4;
		t2.right = t5;
		t3.left = t6;
		
		CountCompleteTreeNodes c = new CountCompleteTreeNodes();
		System.out.println(c.countNodes(t));
	}
}
