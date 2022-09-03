package com.leetcode_6th.supercore;

import com.leetCode.CommonStructure.ListNode;

public class MergekSortedLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ret = null;
        for(int i = 0; i < lists.length; i++){
            ret = merge2ListNodes(ret, lists[i]);
        }
        return ret;
    }
    public ListNode merge2ListNodes(ListNode node1, ListNode node2){
        if(node1 == null){
            return node2;
        }else if(node2 == null){
            return node1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        pre.next = node1;
        while(node1 != null && node2 != null){
            if(node1.val <= node2.val){
                node1 = node1.next;
            }else{
                ListNode tmp = node2;
                node2 = node2.next;
                tmp.next = node1;
                pre.next = tmp;
            }
            pre = pre.next;
        }
        if(node2!=null){
            pre.next = node2;
        }
        return dummy.next;
    }
}
