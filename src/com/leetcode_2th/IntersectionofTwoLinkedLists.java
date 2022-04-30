package com.leetcode_2th;

import com.leetCode.CommonStructure.ListNode;

/**
 * 
 * 
 * @author Zealot
 * @date 2016年6月5日 下午2:59:48 
 *
 */
public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null||headB==null){
			return null;
		}
		int sizeA = 0, sizeB = 0;
		
		ListNode tmpA = headA, tmpB = headB;
		while (tmpA != null) {
			sizeA++;
			tmpA = tmpA.next;
		}
		while(tmpB != null){
			sizeB++;
			tmpB = tmpB.next;
		}
		
		int d = Math.abs(sizeA-sizeB);
		int index = 0;
		if(sizeA>sizeB){
			while(index < d){
				index++;
				headA= headA.next;
			}
		}else if(sizeA<sizeB){
			while(index < d){
				index++;
				headB= headB.next;
			}
		}
		
		while(headA!=headB){
			headA = headA.next;
			headB = headB.next;
		}
		
		return headA;
    }
}
