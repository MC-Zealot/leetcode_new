package com.leetCode._2th;

import com.leetCode.CommonStructure.ListNode;
/**
 *
 *
 * @author Zealot
 * @date 2016年3月5日 下午3:04:23
 *
 */
public class RemoveDuplicatesfromSortedListII {
	public ListNode deleteDuplicates(ListNode head) {
		ListNode p = head;
		ListNode pre = new ListNode(-1);
		ListNode dummy = pre;
		pre.next = head;
		ListNode tmp = new ListNode(-1);

		while(p!=null){
			if(tmp.val!=p.val){
				pre.next = p;
			}
			p = p.next;
			tmp = p;
		}

		return dummy.next;
	}
	public ListNode deleteDuplicates2(ListNode head) {
		if (head == null){
			return head;
		}
		ListNode helper = new ListNode(0);
		helper.next = head;
		ListNode pre = helper;
		ListNode cur = head;
		while (cur != null) {
			while (cur.next != null && pre.next.val == cur.next.val) {
				cur = cur.next;
			}
//			只是现在要把前驱指针指向上一个不重复的元素中，如果找到不重复元素，则把前驱指针知道该元素，否则删除此元素。
			if (pre.next == cur) {
				pre = pre.next;
			} else {
				pre.next = cur.next;
			}
			cur = cur.next;
		}

		return helper.next;
	}
	/**
	 *
	 * @date 2016年3月6日 上午11:26:31
	 * @param head
	 * @return
	 */
	public ListNode deleteDuplicates3(ListNode head) {
		ListNode p = head;
		ListNode pre = new ListNode(-1);
		pre.next = p;
		ListNode dummy = pre;
		boolean flag = false;
		while(p!=null){
			if(p.next!=null&&p.val == p.next.val){
				while(p.next!=null){
					flag = true;
					if(p.val != p.next.val){//如果p指针与p的下个指针val不相等，则dummy指针p的指向下个指针。
						pre.next = p.next;
						break;
					}
					p = p.next;

				}
				pre.next = p.next;
			}
			if(flag ==false){
				pre= pre.next;
			}
			flag =false;
			p = p.next;
		}

		return dummy.next;
	}
	public static void main(String[] args) {
		ListNode l1 = new ListNode(1);
		ListNode l2 = new ListNode(1);
		ListNode l3 = new ListNode(2);
		ListNode l4 = new ListNode(2);
		ListNode l5 = new ListNode(3);
		ListNode l6 = new ListNode(3);
		ListNode l7 = new ListNode(3);
		ListNode l8 = new ListNode(4);
		l1.next =l2;
		l2.next = l3;
		l3.next = l4;
		l4.next = l5;
		l5.next = l6;
		l6.next = l7;
		l7.next = l8;
		RemoveDuplicatesfromSortedListII r = new RemoveDuplicatesfromSortedListII();
		ListNode p = r.deleteDuplicates3(l1);
		while(p!=null){
			System.out.println(p.val);
			p = p.next;
		}
	}
}
