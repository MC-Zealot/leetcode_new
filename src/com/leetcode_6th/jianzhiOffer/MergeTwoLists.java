package com.leetcode_6th.jianzhiOffer;


import com.leetCode.CommonStructure.ListNode;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode node = dummy;
        while(l1!=null && l2!=null){
            int val1 = l1.val;
            int val2 = l2.val;
            ListNode n;
            if(val1 <= val2){
                 n = new ListNode(val1);
                 l1 = l1.next;
            }else{
                 n = new ListNode(val2);
                 l2 = l2.next;
            }
            node.next = n;
            node = node.next;
        }
        while (l1 != null){
            ListNode n = new ListNode(l1.val);
            node.next = n;
            l1 = l1.next;
            node = node.next;
        }
        while (l2 != null){
            ListNode n = new ListNode(l2.val);
            node.next = n;
            l2 = l2.next;
            node = node.next;
        }

        return dummy.next;
    }
}
