//给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。 
//
// 你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。 
//
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4]
//输出：[2,1,4,3]
// 
//
// 示例 2： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：head = [1]
//输出：[1]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目在范围 [0, 100] 内 
// 0 <= Node.val <= 100 
// 
//
// 
//
// 进阶：你能在不修改链表节点值的情况下解决这个问题吗?（也就是说，仅修改节点本身。） 
// Related Topics 递归 链表 
// 👍 997 👎 0


package com.oj_5th.leetcode.editor.cn;

import com.oj_5th.leetcode.editor.cn.ListNode;

import java.util.ArrayList;
import java.util.List;

/*
*   [24] swap-nodes-in-pairs
*   2021-08-08 20:01:21
*/
public class P24SwapNodesInPairs{
    public static void main(String[] args) {
        Solution solution = new P24SwapNodesInPairs().new Solution();
        // TO TEST
    }
    //[24] swap-nodes-in-pairs
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode swapPairs(ListNode head) {
        if (head==null || head.next==null) return head;
        ListNode one = head;
        ListNode two = one.next;
        ListNode three = two.next;

        two.next = one;
        one.next = swapPairs(three);

        return two;
    }
    public ListNode swapPairs2(ListNode head) {
        if(head==null){
            return null;
        }
        List<Integer> list = new ArrayList<Integer>();
        ListNode p = head;
        while(p!=null){
            list.add(p.val);
            p = p.next;
        }
        p = head;
        int i = 0;
        while(p!=null){
            if(i%2 ==0 && i+1 < list.size()){
                int p_val = p.val;
                p.val = p.next.val;
                p.next.val = p_val;
            }
            p = p.next;
            i++;
        }
        return head;
    }
//leetcode submit region end(Prohibit modification and deletion)

}}