package com.leetcode_2th;

import com.leetCode.CommonStructure.ListNode;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月3日 上午10:22:43 
 *
 */
public class LinkedListCycle {
	public boolean hasCycle(ListNode head) {
		
		ListNode slow = head;
		ListNode fast = head;
		while(fast!=null && slow !=null) {
			slow = slow.next;
			if(fast.next==null){
				return false;
			}
			fast = fast.next.next;
			if(slow.equals(fast)){
				return true;
			}
		}
		
		return false;
    }
}
