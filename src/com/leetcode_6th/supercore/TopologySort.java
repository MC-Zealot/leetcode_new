package com.leetcode_6th.supercore;

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


    public ArrayList<DirectedGraphNode> topSort2(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        //1.在队列中，存放入度为0的节点。
        //2.从队列中取1个，当做返回的顺序
        //3.并且更新其他的节点的入度,返回1
        Map<DirectedGraphNode, Set<DirectedGraphNode>> map = new HashMap<>();//<节点， 入点>
        Queue<DirectedGraphNode> queue = new LinkedList<>();
        genMap(map, graph);
        // System.out.println(map.size());
        updateQueue(map, queue);
        ArrayList<DirectedGraphNode> ret = new ArrayList<>();
        while(queue.size() > 0){
//            System.out.println(queue.size());
            DirectedGraphNode node = queue.poll();
            ret.add(node);
            updateMap(map, node);
            map.remove(node);
            if(queue.size() == 0){
                updateQueue(map, queue);
            }
        }
        return ret;
    }
    public void genMap(Map<DirectedGraphNode, Set<DirectedGraphNode>> map, ArrayList<DirectedGraphNode> graph){
        for(int i = 0; i < graph.size(); i++){
            DirectedGraphNode node = graph.get(i);
            List<DirectedGraphNode> neighbors = node.neighbors;
            if(!map.containsKey(node)){
                map.put(node, new HashSet<DirectedGraphNode>());
            }
            for(int j = 0; j < neighbors.size(); j++){
                DirectedGraphNode neighbor = neighbors.get(j);
                if(map.containsKey(neighbor)){
                    map.get(neighbor).add(node);
                }else{
                    Set<DirectedGraphNode> set = new HashSet<>();
                    set.add(node);
                    map.put(neighbor, set);
                }
            }
        }
    }
    public void updateQueue(Map<DirectedGraphNode, Set<DirectedGraphNode>> map, Queue<DirectedGraphNode> queue){
        for(DirectedGraphNode node: map.keySet()){
            if(map.get(node).size() == 0){
                queue.add(node);
            }
        }
    }
    public void updateMap(Map<DirectedGraphNode, Set<DirectedGraphNode>> map, DirectedGraphNode delNode){
        for(DirectedGraphNode node: map.keySet()){
            Set<DirectedGraphNode> set = map.get(node);
            set.remove(delNode);
        }
    }

    /**
     * BFS
     * 比较精简
     * @param graph
     * @return
     */
    public ArrayList<DirectedGraphNode> topSort3(ArrayList<DirectedGraphNode> graph) {
        ArrayList<DirectedGraphNode> res = new ArrayList();
        Map<DirectedGraphNode, Integer> indegree = new HashMap();
        Queue<DirectedGraphNode> q = new LinkedList();
        for(DirectedGraphNode node : graph){
            indegree.putIfAbsent(node, 0); // note: need to add node itself to start
            for(DirectedGraphNode nei : node.neighbors) {
                indegree.put(nei, indegree.getOrDefault(nei, 0) + 1);
            }
        }
        for(DirectedGraphNode key : indegree.keySet()) {
            if(indegree.get(key) == 0) q.add(key);
        }
        while(q.size() > 0) {
            DirectedGraphNode node = q.poll();
            res.add(node);
            for(DirectedGraphNode nei : node.neighbors) {
                indegree.put(nei, indegree.get(nei) - 1);
                if(indegree.get(nei) == 0) q.add(nei);
            }
        }
        return res;
    }

    /**
     * map保存节点与入度
     * 通过入度是否为0，是否加入到结果，
     * 加入结果后，更新map
     *
     * @param graph
     * @return
     */
    public ArrayList<DirectedGraphNode> topSort4(ArrayList<DirectedGraphNode> graph) {
        // write your code here
        ArrayList<DirectedGraphNode> ret = new ArrayList<DirectedGraphNode>();
        Map<DirectedGraphNode, Integer> map = new HashMap<DirectedGraphNode, Integer>();
        for(DirectedGraphNode node: graph){
            map.put(node, 0);
        }
        for(DirectedGraphNode node: graph){
            List<DirectedGraphNode> neighbors  = node.neighbors;
            for(int j = 0; j < neighbors.size(); j++){
                DirectedGraphNode neighbor = neighbors.get(j);
                map.put(neighbor, map.get(neighbor) + 1);
            }
        }
        Queue<DirectedGraphNode> queue = new LinkedList<DirectedGraphNode>();
        for(DirectedGraphNode node: map.keySet()){
            int inputcnt = map.get(node);
            if(inputcnt == 0){
                queue.add(node);
            }
        }
        while(queue.size() > 0){
            DirectedGraphNode node = queue.poll();
            ret.add(node);
            List<DirectedGraphNode> neighbors  = node.neighbors;
            for(DirectedGraphNode nei: neighbors){
                map.put(nei, map.get(nei) - 1);
                if(map.get(nei) == 0){
                    queue.add(nei);
                }
            }
        }
        return ret;
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
        ArrayList<DirectedGraphNode> sorted = ts.topSort2(graph);
        for(DirectedGraphNode node: sorted){
            System.out.println(node.label);
        }

    }
}
