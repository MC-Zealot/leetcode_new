package com.leetCode._1th;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

import com.leetCode.CommonStructure.TreeNode;

/**
 * 
 * @author Zealot
 * @date 2015年7月19日 下午4:58:00
 */
public class BinaryTreePreorderTraversal_144 {
	List <Integer> list = new ArrayList<Integer>();
	public List<Integer> preorderTraversal(TreeNode root){
		if(root==null) {
			return new ArrayList<Integer>();
		}
		list.add(root.val);
		if(root.left!=null) {
			preorderTraversal(root.left);
		}
		if(root.right!=null) {
			preorderTraversal(root.right);
		}
		return list;
	}
	//非递归前序遍历
	public List<Integer> preorderTraversal2(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        
        stack.push(root);
        
        while(!stack.isEmpty()){
           TreeNode node = stack.pop();
           if(node!=null){
               result.add(node.val);
               if(node.right!=null){
                   stack.push(node.right);
               }
               if(node.left!=null){
                   stack.push(node.left);
               }
           }
        }
        return result;
    }
	//非递归前序遍历
	public List<Integer> preorderTraversal3(TreeNode root) {
        List<Integer> result = new LinkedList<>();
        Deque<TreeNode> stack = new LinkedList<>();
        while(root!=null||!stack.isEmpty()){
        	if(root!=null){
        		result.add(root.val);
        		stack.push(root);
        		root=root.left;
        	}else{
        		root=stack.pop().right;
        	}
        }
        return result;
	}
	public static void main(String[] args) {

		BinaryTreePreorderTraversal_144 m = new BinaryTreePreorderTraversal_144();
		TreeNode t =new TreeNode(1);
		TreeNode t2 = new TreeNode(2);
		TreeNode t3 = new TreeNode(3);
		TreeNode t4 =new TreeNode(4);
		TreeNode t5 = new TreeNode(5);
		TreeNode t6 = new TreeNode(6);
		t.left=t2;
		t.right=t3;
		t3.left = t4;
		t3.right = t5;
		t4.right = t6;
		
		
		TreeNode t1 =new TreeNode(1);
		TreeNode t21 = new TreeNode(2);
		TreeNode t31 = new TreeNode(3);
		TreeNode t41 =new TreeNode(4);
		TreeNode t51 = new TreeNode(5);
		TreeNode t61 = new TreeNode(6);
		t1.left=t21;
		t1.right=t31;
		t31.left = t41;
		t31.right = t51;
		t41.right = t61;
		List<Integer> d = m.preorderTraversal(t1);
		System.out.println(d);
		
	
	}
}
