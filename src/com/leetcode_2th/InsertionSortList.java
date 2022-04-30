package com.leetcode_2th;

import com.leetCode.CommonStructure.ListNode;

/**
 * Sort a linked list using insertion sort.
 * 
 * @author Zealot
 * @date 2016年6月15日 下午3:28:47 
 *
 */
public class InsertionSortList {
	public ListNode insertionSortList(ListNode head) {

		if (head == null) {
			return null;
		}
		ListNode node = head;
		ListNode dummy = new ListNode(-1);

		while (node != null) {
			int val = node.val;
			ListNode newNodePre = dummy;
			ListNode newNodeCur = newNodePre.next;
			if (newNodeCur == null) {
				ListNode tmp = new ListNode(node.val);
				newNodePre.next = tmp;
			} else {
				while (newNodeCur != null) {
					int newNodeVal = newNodeCur.val;
					if (val <= newNodeVal) {
						ListNode tmp = new ListNode(node.val);
						tmp.next = newNodePre.next;
						newNodePre.next = tmp;
						break;
					}
					newNodeCur = newNodeCur.next;
					newNodePre = newNodePre.next;
				}
				if(newNodeCur==null){
					ListNode tmp = new ListNode(val);
					newNodePre.next = tmp;
				}
			}
			node = node.next;
		}

		return dummy.next;
	}

	public ListNode insertionSortList2(ListNode head) {
		if (head == null) {
			return null;
		}
		ListNode helper = new ListNode(0);
		ListNode pre = helper;
		ListNode cur = head;
		while (cur != null) {
			ListNode next = cur.next;//先把原链表的下一个节点保存。
			pre = helper;
			while (pre.next != null && pre.next.val <= cur.val) {
				pre = pre.next;
			}
			cur.next = pre.next;//这样把当前节点拿出来放到返回链表当中时，就原链表就还有索引了
			pre.next = cur;
			cur = next;
		}
		return helper.next;
	}  
	
	


	 public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
	        if(headA==null || headB==null) return null;
	        ListNode pa = headA, pb = headB;
	        int counta = 0, countb = 0;
	        
	        while(pa!=null){
	            counta++;
	            pa = pa.next;
	        }
	        while(pb!=null){
	            countb++;
	            pb = pb.next;
	        }
	        
	        pa = headA;
	        pb = headB;
	        int dif = Math.abs(counta-countb);
	        if(counta>countb){
	            while(dif!=0){
	                pa = pa.next;
	                dif--;
	            }
	        }else{
	            while(dif!=0){
	                pb = pb.next;
	                dif--;
	            }
	        }
	        while(pa!=pb){
	            pa = pa.next;
	            pb = pb.next;
	        }
	        return pa;
	        
	    }
	 public class ListNode {
			public int val;
			public ListNode next;

			public ListNode(int x) {
				val = x;
				next = null;
			}
		}
	 public boolean isCross(ListNode list1, ListNode list2) {
		 boolean ret = false;
		 if(list1 == null || list2 == null) {
			 return ret;
		 }
		 ListNode p1=list1;
		 ListNode p2=list2;
		 int count1 = 0;//第一个链表长度
		 int count2 = 0;//第二个链表长度
		 while(p1!=null) {
			 count1++;
			 p1=p1.next;
		 }
		 while(p2!=null) {
			 count2++;
			 p2=p2.next;
		 }
		 p1=list1;
		 p2=list2;
		 //计算差值
		 int diff = count1 - count2;
		 if(diff < 0) {
			 diff = -diff;
		 }
		 //根据差值，找到两个指针的同一起始点
		 if(count1>count2) {
			 while(diff!=0) {
				 p1=p1.next;
				 diff--;
			 }
		 }else {
			 while(diff!=0) {
				 p2=p2.next;
				 diff--;
			 }
		 }
		 //双指针同时遍历，判断是否交叉
		 while(p1!=p2) {
			 p1=p1.next;
			 p2=p2.next;
		 }
		 //如果p1不是空，（没有遍历到最后）
		 if(p1!=null) {
			 ret=true;
		 }
		 return ret;
	 }
	public static void main(String[] args) {
//		InsertionSortList is = new InsertionSortList();
//		ListNode l1 = new ListNode(3);
//		ListNode l2 = new ListNode(1);
//		ListNode l3 = new ListNode(2);
//		ListNode l4 = new ListNode(5);
//		ListNode l5 = new ListNode(4);
//		ListNode l6 = new ListNode(9);
//		ListNode l7 = new ListNode(6);
//		l1.next = l2;
//		l2.next =l3;
//		l3.next = l4;
//		l4.next = l5;
//		l5.next = l6;
//		l6.next = l7;
//		ListNode l = is.insertionSortList(l1);
//		while(l!=null){
//			System.out.print(l.val+"\t");
//			l = l.next;
//		}
		/*Set<String> set = new HashSet<String>();
		set.add("count:1");
		set.add("count:aid1");
		set.add("count:isJoinEXO");
		set.add("count:4");
		set.add("count:aid4");
		List<String> list = new ArrayList<String>(set);
		Collections.sort(list);
		for(String str: list){
			System.out.println(str);
		}*/
		
	}
}
