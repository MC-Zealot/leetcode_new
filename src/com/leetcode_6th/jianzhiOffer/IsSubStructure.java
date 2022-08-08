package com.leetcode_6th.jianzhiOffer;

import com.leetCode.CommonStructure.ListNode;
import com.leetCode.CommonStructure.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 剑指 Offer 26. 树的子结构
 * 输入两棵二叉树A和B，判断B是不是A的子结构。(约定空树不是任意一个树的子结构)
 *
 * B是A的子结构， 即 A中有出现和B相同的结构和节点值。
 *
 * 例如:
 * 给定的树 A:
 *
 *      3
 *     / \
 *    4   5
 *   / \
 *  1   2
 * 给定的树 B：
 *
 *    4
 *   /
 *  1
 * 返回 true，因为 B 与 A 的一个子树拥有相同的结构和节点值。
 *
 * 示例 1：
 *
 * 输入：A = [1,2,3], B = [3,1]
 * 输出：false
 * 示例 2：
 *
 * 输入：A = [3,4,5,1,2], B = [4,1]
 * 输出：true
 * 限制：
 *
 * 0 <= 节点个数 <= 10000
 */
public class IsSubStructure {
    List<TreeNode> list;
    int bVal;
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        if(B == null || A == null){
            return false;
        }
        list = new ArrayList<>();
        this.bVal = B.val;
        boolean ret = false;
        findBvalFromA(A);
        for(int i = 0; i < list.size(); i++){
            TreeNode a = list.get(i);
            ret = isSubTree(a, B);
            if(ret){
                return ret;
            }
        }
        return false;
    }
    public void findBvalFromA(TreeNode A){
        if(A == null){
            return;
        }
        if(A.val == bVal){
            list.add(A);
        }
        findBvalFromA(A.left);
        findBvalFromA(A.right);
    }
    public boolean isSubTree(TreeNode A, TreeNode B){
        if(A == null && B != null){
            return false;
        }
        if(A != null && B == null){
            return false;
        }
        if(A.val != B.val){
            return false;
        }
        boolean left = true;
        boolean right = true;
        if(B.left!= null){
            left = isSubTree(A.left, B.left);
        }
        if(B.right != null){
            right = isSubTree(A.right, B.right);
        }
        return  left && right;
    }

    public static void main(String[] args) {
        TreeNode n1 = new TreeNode(4);
        TreeNode n2 = new TreeNode(2);
        TreeNode n3 = new TreeNode(3);
        TreeNode n4 = new TreeNode(4);
        TreeNode n5 = new TreeNode(5);
        TreeNode n6 = new TreeNode(6);
        TreeNode n7 = new TreeNode(7);
        TreeNode n8 = new TreeNode(8);
        TreeNode n9 = new TreeNode(9);
        n1.left = n2;
        n1.right = n3;
        n2.left = n4;
        n2.right = n5;
        n3.left = n6;
        n3.right = n7;
        n4.left = n8;
        n4.right = n9;

        TreeNode nb1 = new TreeNode(4);
        TreeNode nb2 = new TreeNode(8);
        TreeNode nb3 = new TreeNode(9);
        nb1.left = nb2;
        nb1.right = nb3;
        IsSubStructure is = new IsSubStructure();
        boolean ret = is.isSubStructure(n1, nb1);
        System.out.println(ret);

    }
}
