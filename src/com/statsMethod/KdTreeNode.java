package com.statsMethod;


/**
 * kd树节点，目前支持每个节点只保存一条数据
 * 
 * @author Zealot
 * @date 2017年1月19日 下午6:46:48 
 *
 */
public class KdTreeNode {
	public PairWiseNode node;
	public KdTreeNode left;
	public KdTreeNode right;
	@Override
	public String toString() {
		return "KdTreeNode [node=" + node + ", left=" + left + ", right="
				+ right + "]";
	}
	
}
