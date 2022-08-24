package com.leetcode_6th.core;

import com.leetCode.CommonStructure.TreeNode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ret = new ArrayList<>();
        Stack<Pair<Boolean, TreeNode>> stack = new Stack<>();
        stack.add(new Pair(false, root));
        while(stack.size() > 0){
            Pair<Boolean, TreeNode> p = stack.pop();
            boolean flag = p.getKey();
            TreeNode node = p.getValue();
            if(node == null){
                continue;
            }
            if(flag == false){
                stack.add(new Pair<Boolean, TreeNode>(false, node.right));
                stack.add(new Pair<Boolean, TreeNode>(true, node));
                stack.add(new Pair<Boolean, TreeNode>(false, node.left));
            }else{
                ret.add(node.val);
            }
        }
        return ret;
    }
}
