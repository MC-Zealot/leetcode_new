package com.leetCode._1th;

import com.leetCode.CommonStructure.ListNode;

/**
 * 
 * Definition for singly-linked list.
 * @author Zealot
 * @date 2015年7月20日 下午6:09:42
 */
public class LinkedListCycle_141 {
    public boolean hasCycle(ListNode head) {
    	if(head==null||head.next==null) {
    		return false;
    	}
    	ListNode p1 = head;
    	ListNode p2 = p1.next.next;//起点是一样的。
    	while(p1!=null&&p2!=null){
    		if(p1.equals(p2)){
    			return true;
    		}
    		p1 = p1.next;
    		if(p2.next==null){
    		    return false;
    		}
    		p2 = p2.next.next;
    	
    	}
    	return false;
    }
    public boolean hasCycle2(ListNode head) {
        if(head==null){
            return false;
        }
        if(head.next==null){
            return false;
        }
        ListNode slow = head;
        ListNode fast = head.next.next;//
        while(fast!=null){//slow的条件去掉，slow肯定比fast慢
            if(slow.equals(fast)){
                return true;
            }
            slow = slow.next;
            if(fast.next==null){
                return false;
            }
            fast = fast.next.next;
        }
        return false;
    }
    public static void main(String[] args) {
    	ListNode l1 =new ListNode(1);
    	ListNode l2 =new ListNode(2);
    	l1.next=l2;
    	LinkedListCycle_141 l = new LinkedListCycle_141();
    	
    	System.out.println(l.hasCycle(l1));
    	
	}
}
