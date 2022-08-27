package com.leetcode_6th.supercore;

import com.leetCode.CommonStructure.TreeNode;

import java.util.List;
import java.util.Stack;

/**
 * 173. 二叉搜索树迭代器
 * 实现一个二叉搜索树迭代器类BSTIterator ，表示一个按中序遍历二叉搜索树（BST）的迭代器：
 * BSTIterator(TreeNode root) 初始化 BSTIterator 类的一个对象。BST 的根节点 root 会作为构造函数的一部分给出。指针应初始化为一个不存在于 BST 中的数字，且该数字小于 BST 中的任何元素。
 * boolean hasNext() 如果向指针右侧遍历存在数字，则返回 true ；否则返回 false 。
 * int next()将指针向右移动，然后返回指针处的数字。
 * 注意，指针初始化为一个不存在于 BST 中的数字，所以对 next() 的首次调用将返回 BST 中的最小元素。
 * 你可以假设 next() 调用总是有效的，也就是说，当调用 next() 时，BST 的中序遍历中至少存在一个下一个数字。
 *
 * 示例：
 * 输入
 * ["BSTIterator", "next", "next", "hasNext", "next", "hasNext", "next", "hasNext", "next", "hasNext"]
 * [[[7, 3, 15, null, null, 9, 20]], [], [], [], [], [], [], [], [], []]
 * 输出
 * [null, 3, 7, true, 9, true, 15, true, 20, false]
 * 解释
 * BSTIterator bSTIterator = new BSTIterator([7, 3, 15, null, null, 9, 20]);
 * bSTIterator.next();    // 返回 3
 * bSTIterator.next();    // 返回 7
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next();    // 返回 9
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next();    // 返回 15
 * bSTIterator.hasNext(); // 返回 True
 * bSTIterator.next();    // 返回 20
 * bSTIterator.hasNext(); // 返回 False
 *
 *
 * 提示：
 * 树中节点的数目在范围 [1, 105] 内
 * 0 <= Node.val <= 106
 * 最多调用 105 次 hasNext 和 next 操作
 *
 * 进阶：
 * 你可以设计一个满足下述条件的解决方案吗？next() 和 hasNext() 操作均摊时间复杂度为 O(1) ，并使用 O(h) 内存。其中 h 是树的高度。
 */
public class BSTIterator {
    List<Integer> list;
    int index = 0;

    /**
     * 空间复杂度：O(n)
     * @param root
     */
   /* public BSTIterator(TreeNode root) {
        this.list = new ArrayList<>();
        dfs(root);
    }
    public void dfs(TreeNode node){
        if(node == null){
            return;
        }
        dfs(node.left);
        list.add(node.val);
        dfs(node.right);
    }
    public int next() {
        return list.get(index++);
    }

    public boolean hasNext() {
        return index < list.size();
    }*/

    Stack<TreeNode> stack;

    /**
     * 空间复杂度O(h)， h为二叉树的高度
     * 中序遍历的访问顺序是 左子树 -> 根节点 -> 右子树 的顺序，并且对 左子树 和 右子树 也进行递归。
     * 构造方法：一路到底，把根节点和它的所有左节点放到栈中；
     * 调用 next() 方法：弹出栈顶的节点；
     * 如果它有右子树，则对右子树一路到底，把它和它的所有左节点放到栈中。
     * 链接：https://leetcode.cn/problems/binary-search-tree-iterator/solution/fu-xue-ming-zhu-dan-diao-zhan-die-dai-la-dkrm/
     *
     *
     * PS：这道题和二叉搜索树关系不大，换成普通的二叉树也可以
     * @param root
     */
    public BSTIterator(TreeNode root) {
        this.stack = new Stack<>();
        stack.add(root);
        while(root.left != null){
            stack.add(root.left);
            root = root.left;
        }
    }

    public int next() {
        TreeNode node = stack.pop();
        TreeNode right = node.right;
        if(right != null){
            stack.add(right);
            while(right.left != null){
                stack.add(right.left);
                right = right.left;
            }
        }
        return node.val;
    }

    public boolean hasNext() {
        return stack.size() > 0;
    }
}
