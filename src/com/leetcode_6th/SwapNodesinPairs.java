package com.leetcode_6th;

import com.leetCode.CommonStructure.ListNode;

public class SwapNodesinPairs {
    public ListNode swapPairs(ListNode head) {
        ListNode node = head;

        helper(node);
        return head;
    }
    public static void helper(ListNode node){
        if(node==null || node.next == null){
            return;
        }
        int tmp = node.val;
        node.val = node.next.val;
        node.next.val = tmp;
        helper(node.next.next);
    }
}
