package com.leetcode_2th;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

import com.leetCode.CommonStructure.ListNode;
/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 * 
 * @author Zealot
 * @date 2016年5月11日 下午5:55:48 
 *
 */
public class MergekSortedLists {
	/**
	 * TIME:O(nk^2)
	 * SPACE:O(1)
	 * @date 2016年5月11日 下午6:17:15
	 * @param lists
	 * @return
	 */
	public ListNode mergeKLists(ListNode[] lists) {
		ListNode dummy = new ListNode(Integer.MIN_VALUE);
		for(int i = 0; i < lists.length; i++){
			dummy = mergeTwoLists(dummy, lists[i]);
		}
		return dummy.next;
    }
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (l1 != null || l2 != null) {
            if (l1 == null || (l2 != null && l2.val < l1.val)) {
                cur.next = l2;
                l2 = l2.next;
            } else {
                cur.next = l1;
                l1 = l1.next;
            }
            cur = cur.next;
        }

        return dummy.next;
	}
	private static final Comparator<ListNode> listComparator =
		      new Comparator<ListNode>() {
		@Override
		public int compare(ListNode x, ListNode y) {
		      return x.val - y.val;
		   }
		};
		public ListNode mergeKLists(List<ListNode> lists) {
			if (lists.isEmpty()) return null;
			Queue<ListNode> queue = new PriorityQueue<>(lists.size(), listComparator); 
			for (ListNode node : lists) {
			      if (node != null) {
			         queue.add(node);
			      } 
			}
			ListNode dummyHead = new ListNode(0);
			ListNode p = dummyHead;
			while (!queue.isEmpty()) {
				ListNode node = queue.poll();
				p.next = node;
				p = p.next;
				if (node.next != null) {
		         queue.add(node.next);
				}
			}
			   return dummyHead.next;
		}
		/**
		 * 使用归并的方法
		 * @date 2016年5月12日 下午3:45:19
		 * @param lists
		 * @return
		 */
		public ListNode mergeKLists2(ListNode[] lists) {

	        return helper(lists, 0, lists.length - 1);

	    }

	    public ListNode helper(ListNode[] lists, int from, int to) {
	        if (from > to) {
	            return null;
	        }
	        if (from == to) {
	            return lists[from];
	        }

	        ListNode l1 = helper(lists, from, (from + to) / 2);
	        ListNode l2 = helper(lists, (from + to) / 2 + 1, to);

	        return mergeTwoLists(l1, l2);
	    }
	public static void main(String[] args) {
		System.out.println("123_".split("_")[1]);
	}
}
