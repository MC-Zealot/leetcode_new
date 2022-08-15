package com.competition.No306Weekly;

import com.leetCode.CommonStructure.Interval;
import javafx.util.Pair;

import java.util.*;

/**
 * 6149. 边积分最高的节点 显示英文描述
 * 通过的用户数960
 * 尝试过的用户数1235
 * 用户总通过次数961
 * 用户总提交次数1932
 * 题目难度Medium
 * 给你一个有向图，图中有 n 个节点，节点编号从 0 到 n - 1 ，其中每个节点都 恰有一条 出边。
 * 图由一个下标从 0 开始、长度为 n 的整数数组 edges 表示，其中 edges[i] 表示存在一条从节点 i 到节点 edges[i] 的 有向 边。
 * 节点 i 的 边积分 定义为：所有存在一条指向节点 i 的边的节点的 编号 总和。
 * 返回 边积分 最高的节点。如果多个节点的 边积分 相同，返回编号 最小 的那个。
 *
 * 示例 1：
 * 输入：edges = [1,0,0,0,0,7,7,5]
 * 输出：7
 * 解释：
 * - 节点 1、2、3 和 4 都有指向节点 0 的边，节点 0 的边积分等于 1 + 2 + 3 + 4 = 10 。
 * - 节点 0 有一条指向节点 1 的边，节点 1 的边积分等于 0 。
 * - 节点 7 有一条指向节点 5 的边，节点 5 的边积分等于 7 。
 * - 节点 5 和 6 都有指向节点 7 的边，节点 7 的边积分等于 5 + 6 = 11 。
 * 节点 7 的边积分最高，所以返回 7 。
 * 示例 2：
 *
 * 输入：edges = [2,0,0,2]
 * 输出：0
 * 解释：
 * - 节点 1 和 2 都有指向节点 0 的边，节点 0 的边积分等于 1 + 2 = 3 。
 * - 节点 0 和 3 都有指向节点 2 的边，节点 2 的边积分等于 0 + 3 = 3 。
 * 节点 0 和 2 的边积分都是 3 。由于节点 0 的编号更小，返回 0 。
 *
 * 提示：
 * n == edges.length
 * 2 <= n <= 105
 * 0 <= edges[i] < n
 * edges[i] != i
 */
public class EdgeScore {
    class StComp implements Comparator<Pair<Integer, Integer>> {
        @Override
        public int compare(Pair<Integer, Integer> st1, Pair<Integer, Integer> st2) {
            return st2.getValue() - st1.getValue();
        }
    }
    public int edgeScore(int[] edges) {
        Map<Integer, Integer> map = new HashMap<>();
        for(int from = 0; from < edges.length; from++){
            int to = edges[from];
            if(map.containsKey(to)){
                map.put(to, map.get(to) + from);
            }else{
                map.put(to, from);
            }
        }
        PriorityQueue<Pair<Integer, Integer>> pq = new PriorityQueue(map.size(), new StComp());
        for(Integer v: map.keySet()){
            int num = map.get(v);
            pq.add(new Pair<>(v, num));
        }
        System.out.println(pq.peek());
        Pair<Integer, Integer> pa = pq.poll();
        int max = pa.getValue();
        List<Integer> list = new ArrayList<>();
        list.add(pa.getKey());
        while(pq.size()>0){
            Pair<Integer, Integer> p = pq.poll();
            int v = p.getKey();
            int num = p.getValue();
            if(num < max){
                break;
            }
            max = Math.max(max, num);
            list.add(v);
        }
        Collections.sort(list);
        return list.get(0);
    }

    /**
     * 注意Integer溢出问题，修改为Long
     * @param edges
     * @return
     */
    public int edgeScore2(int[] edges) {
        Map<Integer, Long> map = new HashMap<>();
        for(int from = 0; from < edges.length; from++){
            int to = edges[from];
            if(map.containsKey(to)){
                map.put(to, map.get(to) + from);
            }else{
                map.put(to, from + 0L);
            }
        }
        long max = Integer.MIN_VALUE;
        for(Integer v: map.keySet()){
            long num = map.get(v);
            max = Math.max(max, num);
        }
        List<Integer> list = new ArrayList<>();
        for(Integer v: map.keySet()){
            long num = map.get(v);
            if(num == max){
                list.add(v);
            }
        }
        Collections.sort(list);
        return list.get(0);
    }

    public static void main(String[] args) {
        EdgeScore e = new EdgeScore();
        int[] edges = {1,0,1,1,1,1};
        int ret = e.edgeScore(edges);
        System.out.println(ret);
    }
}
