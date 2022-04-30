package com.leetcode_2th;

import com.leetCode.CommonStructure.ListNode;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年5月11日 下午5:12:07 
 *
 */
public class SwapNodesinPairs {
	public ListNode swapPairs(ListNode head) {
		if(head!=null){
			ListNode cur = head;
			while(cur!=null&&cur.next!=null){
				int t = cur.val;
				cur.val = cur.next.val;
				cur.next.val = t;
				cur = cur.next.next;
			}
		}
		return head;
    }
}
