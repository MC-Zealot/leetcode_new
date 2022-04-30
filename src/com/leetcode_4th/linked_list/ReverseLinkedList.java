package leetcode_4th.linked_list;

import java.util.ArrayList;
import java.util.List;

import com.leetCode.CommonStructure.ListNode;

/**
 * 反转一个单链表。

示例:

输入: 1->2->3->4->5->NULL
输出: 5->4->3->2->1->NULL
进阶:
你可以迭代或递归地反转链表。你能否用两种方法解决这道题？

 * @author zealot
 * Created on: Feb 23, 2020 6:36:41 PM
 */
public class ReverseLinkedList {
	/**
	 * 先用一个最简单的思路，
	 * 空间复杂度：O(n)
	 * @param head
	 * @return
	 * Created on: Feb 23, 2020 6:38:52 PM
	 */
	public ListNode reverseList(ListNode head) {
		if (head == null || head.next == null) {
			return head;
		}
		List<Integer> l = new ArrayList<Integer>();
		ListNode p = head;
		while(p!=null) {
			l.add(p.val);
			p=p.next;
		}
		ListNode ret_dummy = new ListNode(-1);
		p=ret_dummy;
		for(int i = l.size()-1; i >=0; i--) {
			int val = l.get(i);
			ListNode node = new ListNode(val);
			p.next=node;
			p=node;
		}
		
		return ret_dummy.next;
    }
	/**
	 * 空间复杂度：O(1)
	 * @param head
	 * @return
	 * Created on: Feb 23, 2020 9:34:50 PM
	 */
	public ListNode reverseList2(ListNode head) {
	    ListNode prev = null;
	    ListNode curr = head;
	    ListNode next;
	    while (curr != null) {
	      next = curr.next;
	      curr.next = prev;
	      prev = curr;
	      curr = next;
	    }
	    return prev;
	  }
	/**
	 * 尝试用递归翻转链表
	 * @param head
	 * @return
	 * Created on: Feb 23, 2020 7:07:15 PM
	 */
	public ListNode reverseList3(ListNode head) {
		// case1: empty list
        if (head == null) return head;
        // case2: only one element list
        if (head.next == null) return head;
        // case3: reverse from the rest after head
        ListNode newHead = reverseList3(head.next);
        // reverse between head and head->next
        head.next.next = head;
        // unlink list from the rest
        head.next = null;

        return newHead;
	}
	/**
	 * 
	 * @param head
	 * @return
	 * Created on: Feb 28, 2020 1:49:16 AM
	 */
	public ListNode reverseList4(ListNode head) {
        if(head == null) return null;
        ListNode p = head;
        ListNode newHead = head;
        while(p.next != null){
            ListNode tmp = new ListNode(p.next.val);
            p.next = p.next.next;
            tmp.next = newHead;
            newHead = tmp;
        }
        return newHead;
    }
}
