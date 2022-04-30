package com.leetCode._1th;

import com.leetCode.CommonStructure.TreeNode;

public class SameTree_100 {
	boolean result = false;
	public boolean isSameTree(TreeNode p, TreeNode q) {
		if(p==null&&q==null){//2个节点都为空
			return true;
		}else if((p!=null&&q==null) || (p==null&&q!=null)){//有任意一个节点为空
			return false;
		}else if(p.val==q.val){ //都为非空，并且val为非空
			result = isSameTree(p.left, q.left);
			if(result==false){
				return false;
			}
			result = isSameTree(p.right, q.right);
			return result;
		}
		return false;
	}
	public static void main(String[] args) {
		SameTree_100 m = new SameTree_100();
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
		boolean d = m.isSameTree(t,t1);
		System.out.println(d);
		
	}
}
