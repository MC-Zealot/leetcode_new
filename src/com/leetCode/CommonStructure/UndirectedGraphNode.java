package com.leetCode.CommonStructure;

import java.util.ArrayList;
import java.util.List;

/**
 * Definition for undirected graph.
 * 
 * @author Zealot
 * @date 2016年3月20日 下午2:19:42
 *
 */
public class UndirectedGraphNode {
	public int label;
	public List<UndirectedGraphNode> neighbors;

	public UndirectedGraphNode(int x) {
		label = x;
		neighbors = new ArrayList<UndirectedGraphNode>();
	}
}
