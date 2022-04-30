package com.leetCode.CommonStructure;
/**
 * Definition for singly-linked list with a random pointer.
 * 
 * @author Zealot
 * @date 2016年5月12日 下午6:33:10 
 *
 */
public class RandomListNode {
	public int label;
	public RandomListNode next, random;

	public RandomListNode(int x) {
		this.label = x;
	}
}
