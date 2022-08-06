package com.leetcode_6th;

import com.leetCode.CommonStructure.ListNode;

public class ReverseLinkedList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode p = reverseList(head.next);//已经翻转好的链表，并且是新的表头
        head.next.next = head;//指向自己
        head.next = null;// 此时head已经是表尾
        return p;
    }
    public ListNode reverseList2(ListNode head) {
        if(head== null || head.next == null){
            return head;
        }
        ListNode node = head;
        ListNode newHead = head;
        while(head.next != null){
            ListNode next = head.next;
            head.next = head.next.next;
            next.next = newHead;
            newHead = next;

        }
        return newHead;
    }
    public ListNode reverseList3(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode newHead = head;
        while(head.next != null){
            ListNode next = head.next;
            head.next = head.next.next;
            next.next = newHead;
            newHead = next;
        }
        return newHead;
    }

    public static void main(String[] args) {
        ReverseLinkedList rll = new ReverseLinkedList();
        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode l3 = new ListNode(3);
        ListNode l4 = new ListNode(4);
        ListNode l5 = new ListNode(5);
        l1.next = l2;
        l2.next = l3;
//        l3.next = l4;
//        l4.next = l5;
        ListNode ret = rll.reverseList(l1);
        while(ret!=null){
            System.out.print(ret.val+" ");
            ret = ret.next;
        }
    }
}
