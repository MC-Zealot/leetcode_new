package com.leetcode_2th;

import java.util.HashMap;

import com.leetCode.CommonStructure.RandomListNode;

/**
 * A linked list is given such that each node contains an additional random
 * pointer which could point to any node in the list or null.
 * 
 * Return a deep copy of the list.
 * 
 * @author Zealot
 * @date 2016年5月12日 下午6:34:04
 *
 */
public class CopyListwithRandomPointer {
	/**
	 * TIME:O(n)
	 * SPACE:O(n)
	 * @date 2016年5月13日 上午9:51:26
	 * @param head
	 * @return
	 */
	public RandomListNode copyRandomList(RandomListNode head) {
		 if(head == null)  
		        return head;  
		    HashMap<RandomListNode,RandomListNode> map = new HashMap<RandomListNode,RandomListNode>();  
		    RandomListNode newHead = new RandomListNode(head.label);  
		    map.put(head,newHead);  //原始节点，新节点
		    RandomListNode pre = newHead;  
		    RandomListNode node = head.next;  
		    while(node!=null)  
		    {  
		        RandomListNode newNode = new RandomListNode(node.label);  
		        map.put(node,newNode);  
		        pre.next = newNode;  
		        pre = newNode;  
		        node = node.next;  
		    }  
		    node = head;  
		    RandomListNode copyNode = newHead;  
		    while(node!=null)  
		    {  
		        copyNode.random = map.get(node.random);  
		        copyNode = copyNode.next;  
		        node = node.next;  
		    }  
		    return newHead;  
    }
}
