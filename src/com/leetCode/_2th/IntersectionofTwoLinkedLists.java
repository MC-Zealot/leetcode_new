package com.leetCode._2th;

import com.leetCode.CommonStructure.ListNode;

/**
 * Write a program to find the node at which the intersection of two singly
 * linked lists begins.
 * 
 * 
 * For example, the following two linked lists:
 * 
A:          a1 → a2
                   ↘
                     c1 → c2 → c3
                   ↗            
B:     b1 → b2 → b3

 * begin to intersect at node c1.
 * 
 * Notes:
 * 
 * If the two linked lists have no intersection at all, return null. 
 * The linked lists must retain their original structure after the function returns. 
 * You may assume there are no cycles anywhere in the entire linked structure. 
 * Your code should preferably run in O(n) time and use only O(1) memory.
 * 
 * @author Zealot
 * @date 2016年1月23日 下午6:35:06
 */
public class IntersectionofTwoLinkedLists {
	public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
		if(headA==null||headB==null){
			return null;
		}
		ListNode p1 = headA;
		while(p1.next!=null){
			p1 = p1.next;
		}
		ListNode p2 = headB;
		while(p2.next!=null){
			p2 = p2.next;
		}
		if(p1!=p2){
			return null;
		}
		p1 = headA;
		while(p1!=null){
			
			p2 = headB;
			while(p2!=null){
				if(p1==p2){
					return p1;
				}
				
				p2 = p2.next;
			}
			p1 = p1.next;
		}
		
		return null;
	}
	public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
	    //boundary check
	    if(headA == null || headB == null) return null;

	    ListNode a = headA;
	    ListNode b = headB;

	    //if a & b have different len, then we will stop the loop after second iteration
	    while( a != b){
	        //for the end of first iteration, we just reset the pointer to the head of another linkedlist
	        a = a == null? headB : a.next;
	        b = b == null? headA : b.next;    
	    }

	    return a;
	}
	public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {
		if(headA==null||headB==null){
			return null;
		}
		int sizeA = 0;
		int sizeB = 0;
		ListNode p1 = headA;
		while(p1!=null){
			sizeA++;
			p1 = p1.next;
		}
		ListNode p2 = headB;
		while(p2!=null){
			sizeB++;
			p2 = p2.next;
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

	//type:
	//false:降序
	//true:升序
	public void bubSort(int[] a, boolean type){
	    
	    int tmp=0;
	    
	    if(type){
	    }
	    
	    for(int i =0; i < a.length -1; i++){
	        for(int j = 0; j < a.length -1 -i ; j++) {
	            if(a[j+1]> a[j]){
	            
	                tmp = a[j];
	                a[j] = a[j + 1];
	                a[j + 1] = tmp;
	            
	            }
	        }
	    }

	}


	public static void main(String[] args) {
		ListNode headA = new ListNode(1);
		ListNode a2 = new ListNode(2);
		ListNode headB = new ListNode(6);
		ListNode b2 = new ListNode(7);
		ListNode b3 = new ListNode(8);
		ListNode c1 = new ListNode(3);
		ListNode c2 = new ListNode(4);
		ListNode c3 = new ListNode(5);
		headA.next = a2;
		a2.next = c1;
		c1.next = c2;
		c2.next = c3;
		headB.next = b2;
		b2.next = b3;
		b3.next = c1;
		IntersectionofTwoLinkedLists i = new IntersectionofTwoLinkedLists();
		System.out.println(i.getIntersectionNode3(headA, headB).val);
//		ListNode p1 = headA;
//		while(p1.next!=null){
//			p1 = p1.next;
//		}
//		ListNode p2 = headB;
//		while(p2.next!=null){
//			p2 = p2.next;
//		}
//		System.out.println(p1.val);
//		System.out.println(p2.val);
//		System.out.println(p1==p2);
		
	}
}
