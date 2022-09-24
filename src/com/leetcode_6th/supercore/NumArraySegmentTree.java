package com.leetcode_6th.supercore;

/**
 * 线段树
 * 每个树节点，代表数组区间, val为区间和，亦左右子树sum和
 * 节点的左子树：[left, mid] 区间和
 * 节点右子树： [mid, right] 区间和
 *
 * 构造树：递归构造
 *
 *
 * 查询（范围查询）：递归
 *  1.范围在左子树
 *  2.范围在右子树
 *  3.范围包含了左右子树
 *
 * 更新节点value：递归更新value，以及父节点的sum
 *
 */
public class NumArraySegmentTree {
    TreeNode root;
    private class TreeNode{
        int start,end;
        TreeNode left, right;
        int sum;
        public TreeNode(int start, int end){
            this.start = start;
            this.end = end;
        }
    }

    private TreeNode buildTree(int[] nums, int start, int end){
        if(start > end){
            return null;
        }else if(start == end){
            TreeNode node = new TreeNode(start, end);
            node.sum = nums[start];
            return node;
        }else{
            int mid = start + (end - start) / 2;
            TreeNode node = new TreeNode(start, end);
            node.left = buildTree(nums, start, mid);
            node.right = buildTree(nums, mid + 1, end);
            node.sum = node.left.sum + node.right.sum;
            return node;
        }
    }

    private void update(TreeNode node, int index, int val){
        if(node.start == node.end){
            node.sum = val;
            return;
        }
        int mid = node.start + (node.end - node.start) / 2;
        if(index <= mid){
            update(node.left, index, val);
        }else{
            update(node.right, index, val);
        }
        node.sum = node.left.sum + node.right.sum;
    }

    private int query(TreeNode node, int start, int end){
        if(node.start == start && node.end == end){
            return node.sum;
        }
        int mid = node.start + (node.end - node.start) / 2;
        if(end <= mid){
            return query(node.left, start, end);
        }else if(start > mid){
            return query(node.right, start, end);
        }else{
            return query(node.left, start, mid) + query(node.right, mid + 1, end);
        }
    }

    public NumArraySegmentTree(int[] nums) {
        this.root = buildTree(nums, 0, nums.length - 1);
    }

    public void update(int index, int val) {
        update(root, index, val);
    }

    public int sumRange(int left, int right) {
        return query(root, left, right);
    }
}
