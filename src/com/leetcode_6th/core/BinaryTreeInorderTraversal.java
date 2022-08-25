package com.leetcode_6th.core;

import com.leetCode.CommonStructure.TreeNode;
import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BinaryTreeInorderTraversal {
    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        System.out.println(node.val);//这个是在递归返回的过程中打印的
        dfs(node.right);
    }

    /**
     * 按照中序遍历的逆序，放到stack中，这样出栈的顺序就是正序
     * flag==false时，放入stack中是相对顺序
     * 但是当前的stack中并没有包含完整的节点，可能中间会有缺漏，因为有些节点并没有被遍历到
     *
     * 这个思路并不是先在stack中push所有的节点，
     * 再遍历stack出栈就是最终结果
     * 而是一边入栈，一边输出结果（输出当前节点的值，当有了相对顺序之后（当前节点，左子节点，右子节点），才能输出）
     * @param root
     * @return
     */
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
            if(flag == false){//这个节点之前有没有遍历过，如果没有则继续往深处遍历
                stack.add(new Pair<Boolean, TreeNode>(false, node.right));
                stack.add(new Pair<Boolean, TreeNode>(true, node));
                stack.add(new Pair<Boolean, TreeNode>(false, node.left));
            }else{
                ret.add(node.val);
            }
        }
        return ret;
    }

    public static void main(String[] args) {
        BinaryTreeInorderTraversal btit = new BinaryTreeInorderTraversal();
        TreeNode node1 = new TreeNode(1);
        TreeNode node2 = new TreeNode(2);
        TreeNode node3 = new TreeNode(3);
        TreeNode node4 = new TreeNode(4);
        TreeNode node5 = new TreeNode(5);
        node1.left = node2;
        node1.right = node3;
        node2.left = node4;
        node2.right = node5;
        List<Integer> list = btit.inorderTraversal(node1);
        for(int i: list){
            System.out.println(i);
        }
    }
}
