package com.competition.No305Weekly;

import java.util.*;

/**
 * 6139. 受限条件下可到达节点的数目 显示英文描述
 * 通过的用户数455
 * 尝试过的用户数489
 * 用户总通过次数455
 * 用户总提交次数500
 * 题目难度Medium
 * 现有一棵由 n 个节点组成的无向树，节点编号从 0 到 n - 1 ，共有 n - 1 条边。
 *
 * 给你一个二维整数数组 edges ，长度为 n - 1 ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。另给你一个整数数组 restricted 表示 受限 节点。
 *
 * 在不访问受限节点的前提下，返回你可以从节点 0 到达的 最多 节点数目。
 *
 * 注意，节点 0 不 会标记为受限节点。
 *
 *
 *
 * 示例 1：
 *
 *
 * 输入：n = 7, edges = [[0,1],[1,2],[3,1],[4,0],[0,5],[5,6]], restricted = [4,5]
 * 输出：4
 * 解释：上图所示正是这棵树。
 * 在不访问受限节点的前提下，只有节点 [0,1,2,3] 可以从节点 0 到达。
 * 示例 2：
 *
 *
 * 输入：n = 7, edges = [[0,1],[0,2],[0,5],[0,4],[3,2],[6,5]], restricted = [4,2,1]
 * 输出：3
 * 解释：上图所示正是这棵树。
 * 在不访问受限节点的前提下，只有节点 [0,5,6] 可以从节点 0 到达。
 *
 *
 * 提示：
 *
 * 2 <= n <= 105
 * edges.length == n - 1
 * edges[i].length == 2
 * 0 <= ai, bi < n
 * ai != bi
 * edges 表示一棵有效的树
 * 1 <= restricted.length < n
 * 1 <= restricted[i] < n
 * restricted 中的所有值 互不相同
 */
public class No2 {
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        int[][] graph = new int[n][];
        Map<Integer, List<Integer>> map = new HashMap<>();
        for(int[] edge: edges){
            int vec1 = edge[0];
            int vec2 = edge[1];
            if(vec1==vec2){
                continue;
            }
            if(map.containsKey(vec1)){
                List<Integer> tmp = map.get(vec1);
                tmp.add(vec2);
                map.put(vec1, new ArrayList<>(tmp));
            }else{
                List<Integer> list = new ArrayList<>();
                list.add(vec2);
                map.put(vec1, new ArrayList<>(list));
            }
            if(map.containsKey(vec2)){
                List<Integer> tmp2 =map.get(vec2);
                tmp2.add(vec1);
                map.put(vec2, new ArrayList<>(tmp2));
            }else{
                List<Integer> list2 = new ArrayList<>();
                list2.add(vec1);
                map.put(vec2, new ArrayList<>(list2));
            }
        }
        for(int from: map.keySet()){
            List<Integer> to = map.get(from);
            graph[from] =  to.stream().mapToInt(i -> i).toArray();
        }
        Set<Integer> restrictedSet = new HashSet<>();
        for(int i = 0; i < restricted.length; i++){
            restrictedSet.add(restricted[i]);
        }
        boolean[] flags = new boolean[n];
        flags[0] = true;
        Set<Integer> list = new HashSet<>();
        list.add(0);
        dfs(graph, restrictedSet, flags, 0, list);
        System.out.println(list);
        return list.size();
    }
    public void dfs(int[][] graph, Set<Integer> restrictedSet, boolean[] flags, int index,  Set<Integer> list ){
        if( restrictedSet.contains(index)){
            return;
        }
        list.add(index);
//        int trueNum = 0;
//        for(int i = 0; i < flags.length; i++){
//            if(flags[i]){
//                trueNum++;
//            }
//        }
//        if(trueNum == graph.length - restrictedSet.size()){
//            return;
//        }
        int[] outPath = graph[index];
        for(int i = 0; i < outPath.length; i++){
            int out = outPath[i];
            if(flags[out] || restrictedSet.contains(out)){
                continue;
            }
            flags[outPath[i]] = true;
            dfs(graph, restrictedSet, flags, outPath[i],list);
            flags[outPath[i]] = false;
        }
    }

    public static void main(String[] args) {
        No2 n = new No2();
//        int[][] edges = {{0,1},{1,2},{3,1},{4,0},{0,5},{5,6}};
//        int[][] edges = {{0,1},{0,2},{0,5},{0,4},{3,2},{6,5}};
        int[][] edges = {{17,0},{0,4},{17,3},{2,0},{13,4},{11,4},{14,17},{8,13},{15,11},{13,9},{13,1},{4,6},{8,5},{12,1},{6,16},{11,10},{12,7}};
        int[] restricted = {2,13,9,12,5};
        int ret = n.reachableNodes(18, edges, restricted);
        System.out.println(ret);
    }
}
