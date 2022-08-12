package com.leetcode_6th.jianzhiOffer;

import com.leetCode.CommonStructure.TreeNode;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class LevelOrder {
    public int[] levelOrder(TreeNode root) {
        if(root == null){
            return null;
        }
        List<Integer> list = new ArrayList<Integer>();
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while(q.size() > 0){
            TreeNode node = q.poll();
            list.add(node.val);
            if(node.left != null){
                q.add(node.left);
            }
            if(node.right != null){
                q.add(node.right);
            }
        }
        return list.stream().mapToInt(i -> i).toArray();
    }
}
