package com.leetCode._2th;

import java.util.ArrayList;
import java.util.List;

import com.leetCode.CommonStructure.TreeNode;

/**
 Given a binary tree, imagine yourself standing on the right side of it, 
 return the values of the nodes you can see ordered from top to bottom.

For example:
Given the following binary tree,
   1            <---
 /   \
2     3         <---
 \     \
  5     4       <---
You should return [1, 3, 4].
1.Each depth of the tree only select one node.
2. View depth is current size of result list.
 * @author Zealot
 * @date 2016年1月10日 下午6:15:42
 */
public class BinaryTreeRightSideView {
	
	public List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<Integer>();
        rightView(root, result, 0);
        return result;
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth){
        if(curr == null){
            return;
        }
        if(currDepth == result.size()){
            result.add(curr.val);
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);

    }
}
