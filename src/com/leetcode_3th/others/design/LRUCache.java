package com.leetcode_3th.others.design;

import java.util.HashMap;

//运用你所掌握的数据结构，设计和实现一个  LRU (最近最少使用) 缓存机制。它应该支持以下操作： 获取数据 get 和 写入数据 put 。
//
//获取数据 get(key) - 如果密钥 (key) 存在于缓存中，则获取密钥的值（总是正数），否则返回 -1。
//写入数据 put(key, value) - 如果密钥不存在，则写入其数据值。当缓存容量达到上限时，它应该在写入新数据之前删除最近最少使用的数据值，从而为新的数据值留出空间。
//
//进阶:
//
//你是否可以在 O(1) 时间复杂度内完成这两种操作？
//
//示例:
//
//LRUCache cache = new LRUCache( 2 /* 缓存容量 */ )
////
////cache.put(1, 1);
////cache.put(2, 2);
////cache.get(1);       // 返回  1
////cache.put(3, 3);    // 该操作会使得密钥 2 作废
////cache.get(2);       // 返回 -1 (未找到)
////cache.put(4, 4);    // 该操作会使得密钥 1 作废
////cache.get(1);       // 返回 -1 (未找到)
////cache.get(3);       // 返回  3
////cache.get(4);       // 返回  4


/**
 * LRU，淘汰的key跟次数没关系，只和最后使用的顺序，与put的顺序有关系
 * @author Zealot
 * @date Aug 1, 2019 9:38:39 PM 
 *
 */
public class LRUCache {
	private HashMap<Integer, DoubleLinkedListNode> map = new HashMap<Integer, DoubleLinkedListNode>();
	private DoubleLinkedListNode head;
	private DoubleLinkedListNode end;
	private int capacity;
	private int len;

	public LRUCache(int capacity) {
		this.capacity = capacity;
		len = 0;
	}

	public int get(int key) {
		if (map.containsKey(key)) {
			DoubleLinkedListNode latest = map.get(key);
			removeNode(latest);
			setHead(latest);
			return latest.val;
		} else {
			return -1;
		}
	}

	public void removeNode(DoubleLinkedListNode node) {
		DoubleLinkedListNode cur = node;
		DoubleLinkedListNode pre = cur.pre;
		DoubleLinkedListNode post = cur.next;

		if (pre != null) {
			pre.next = post;
		} else {
			head = post;
		}

		if (post != null) {
			post.pre = pre;
		} else {
			end = pre;
		}
	}

	public void setHead(DoubleLinkedListNode node) {
		node.next = head;
		node.pre = null;
		if (head != null) {
			head.pre = node;
		}

		head = node;
		if (end == null) {
			end = node;
		}
	}

	public void put(int key, int value) {
		if (map.containsKey(key)) {
			DoubleLinkedListNode oldNode = map.get(key);
			oldNode.val = value;
			removeNode(oldNode);
			setHead(oldNode);
		} else {
			DoubleLinkedListNode newNode = new DoubleLinkedListNode(key, value);
			if (len < capacity) {
				setHead(newNode);
				map.put(key, newNode);
				len++;
			} else {
				map.remove(end.key);
				end = end.pre;
				if (end != null) {
					end.next = null;
				}

				setHead(newNode);
				map.put(key, newNode);
			}
		}
	}
	class DoubleLinkedListNode {
		public int val;
		public int key;
		public DoubleLinkedListNode pre;
		public DoubleLinkedListNode next;

		public DoubleLinkedListNode(int key, int value) {
			val = value;
			this.key = key;
		}
	}
	public static void main(String[] args) {
		LRUCache cache = new LRUCache(3);
		cache.put(1, 1);
		
		cache.put(2, 2);
		System.out.println(cache.get(2));
		System.out.println(cache.get(2));
		System.out.println(cache.get(2));
		System.out.println(cache.get(2));
		System.out.println(cache.get(2));
//		System.out.println(cache.get(1));
		System.out.println(cache.get(1));
		System.out.println(cache.get(1));
		cache.put(3, 3);
		cache.put(4, 4);
		System.out.println(cache.get(1));
		
		System.out.println(cache.get(2));
	}
}


