package com.leetcode_6th.core;

import com.leetCode.CommonStructure.ListNode;

public class MergeTwoSortedLists {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null){
            return list2;
        }
        if(list2 == null){
            return list1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        pre.next = list1;
        while(list1!=null && list2!=null){
            if(list1.val <= list2.val){
                list1 = list1.next;
            }else{
                ListNode tmp = list2;
                list2 = list2.next;
                tmp.next = list1;
                pre.next = tmp;
            }
            pre = pre.next;
        }
        if(list2!=null){
            pre.next = list2;
        }
        return dummy.next;
    }
}
