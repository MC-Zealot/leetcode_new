package com.leetcode_6th.core;

import java.util.*;

/**
 * 给定一个有向图，图节点的拓扑排序定义如下:
 *
 * 对于图中的每一条有向边 A -> B , 在拓扑排序中A一定在B之前.
 * 拓扑排序中的第一个节点可以是图中的任何一个没有其他节点指向它的节点.
 * 针对给定的有向图找到任意一种拓扑排序的顺序.
 *
 * 你可以假设图中至少存在一种拓扑排序
 * 有关图的表示详情请看这里
 *
 * 图结点的个数 <= 5000
 * 样例
 * 样例 1：
 *
 * 输入：
 *
 * graph = {0,1,2,3#1,4#2,4,5#3,4,5#4#5}
 * 输出：
 *
 * [0, 1, 2, 3, 4, 5]
 * 解释：
 *
 * 图如下所示:
 *
 * picture
 *
 * 拓扑排序可以为:
 * [0, 1, 2, 3, 4, 5]
 * [0, 2, 3, 1, 5, 4]
 * ...
 * 您只需要返回给定图的任何一种拓扑顺序。
 *
 * 挑战
 * 能否分别用BFS和DFS完成？
 */
class DirectedGraphNode {
    int label;
    List<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}
public class TopologySort {


    /**
     * @param graph: A list of Directed graph node
     * @return: Any topological order for the given graph.
     */
    public ArrayList<DirectedGraphNode> topSort(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> ret = new ArrayList<>();
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        Map<DirectedGraphNode, Set<DirectedGraphNode>> map = new HashMap<>();//label, input count
        for(int i = 0;i < graph.size();i++){
            DirectedGraphNode node = graph.get(i);
            map.put(node, new HashSet<>());
        }
        for(int i = 0;i < graph.size();i++){
            DirectedGraphNode from = graph.get(i);
            for(int j = 0; j < from.neighbors.size(); j++){
                map.get(from.neighbors.get(j)).add(from);
            }
        }
        getAllZeroNode(map, queue);
        while(queue.size() > 0){
            DirectedGraphNode node = queue.poll();
            ret.add(new DirectedGraphNode(node.label));
            for(DirectedGraphNode from: map.keySet()){
                Set<DirectedGraphNode> set = map.get(from);
                set.remove(node);
            }
            map.remove(node);
            if(queue.size() == 0){
                getAllZeroNode(map, queue);
            }
        }
        return ret;
    }
    public void getAllZeroNode(Map<DirectedGraphNode, Set<DirectedGraphNode>> map, Queue<DirectedGraphNode> queue){
        for(DirectedGraphNode node: map.keySet()){
            Set<DirectedGraphNode> toSet = map.get(node);
            if(toSet.size() == 0){
                queue.add(node);
            }
        }
    }

    public static void main(String[] args) {

        DirectedGraphNode n0 = new DirectedGraphNode(0);
        DirectedGraphNode n1 = new DirectedGraphNode(1);
        DirectedGraphNode n2 = new DirectedGraphNode(2);
        DirectedGraphNode n3 = new DirectedGraphNode(3);
        DirectedGraphNode n4 = new DirectedGraphNode(4);
        DirectedGraphNode n5 = new DirectedGraphNode(5);
        n0.neighbors.add(n1);
        n0.neighbors.add(n2);
        n0.neighbors.add(n3);
        n1.neighbors.add(n4);
        n2.neighbors.add(n4);
        n2.neighbors.add(n5);
        n3.neighbors.add(n4);
        n3.neighbors.add(n5);
        ArrayList<DirectedGraphNode> graph = new ArrayList<>();
        graph.add(n0);
        graph.add(n1);
        graph.add(n2);
        graph.add(n3);
        graph.add(n4);
        graph.add(n5);
        TopologySort ts = new TopologySort();
        ArrayList<DirectedGraphNode> sorted = ts.topSort(graph);
        for(DirectedGraphNode node: sorted){
            System.out.println(node.label);
        }

    }
}
