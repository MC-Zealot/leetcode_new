package com.leetcode_6th;

import java.util.*;

/**
 * You are given an array points representing integer coordinates of some points on a 2D-plane, where points[i] = [xi, yi].
 *
 * The cost of connecting two points [xi, yi] and [xj, yj] is the manhattan distance between them: |xi - xj| + |yi - yj|, where |val| denotes the absolute value of val.
 *
 * Return the minimum cost to make all points connected. All points are connected if there is exactly one simple path between any two points.
 *
 */
public class MinCosttoConnectAllPoints {
    /**
     * 曼哈顿距离
     */
    public int manhattanDist(int[] a1, int[] a2){
        int a1x = a1[0];
        int a1y = a1[1];
        int a2x = a2[0];
        int a2y = a2[1];
        return Math.abs(a1x - a2x) + Math.abs(a1y - a2y);
    }
    /**
     * 定义边
     */
    public class Edge{
        int point1;
        int point2;
        int cost;
        public Edge(int point1, int point2, int cost){
            this.point1 = point1;
            this.point2 = point2;
            this.cost = cost;
        }

        @Override
        public String toString() {
            return "Edge{" +
                    "point1=" + point1 +
                    ", point2=" + point2 +
                    ", cost=" + cost +
                    '}';
        }
    }

    /**
     * 并查集Class
     */
    public class UnionFind{
        int[] root;
        int[] rank;
        public UnionFind(int size){
            root = new int[size];
            rank = new int[size];
            for(int i = 0; i < size; i++){
                root[i] = i;
                rank[i] = 1;
            }
        }
        public int find(int x){
            if(root[x] == x){
                return x;
            }
            return find(root[x]);
        }
        public void union(int x, int y){
            int rootX = find(x);
            int rootY = find(y);
            if(rootX != rootY){
                if(rank[rootX] > rank[rootY]){
                    root[rootY] = rootX;
                }else if(rank[rootX] < rank[rootY]){
                    root[rootX] = rootY;
                }else{
                    root[rootY] = rootX;
                    rank[rootX] += 1;
                }
            }
        }
        public boolean isConected(int x, int y){
            return find(x) == find(y);
        }
    }
    /**
     * Kruskal 算法
     * 返回最小的花销，可以连接所有的点。
     * 2个点之间，只有一条边
     * 不可以有环(连接之前判断，两点是否连通)
     * 计算所有边的边长
     * 对所有边长从小到大进行排序
     * @param points
     * @return
     */
    public int minCostConnectPoints(int[][] points) {
        //算出所有的边
        List<Edge> list = new ArrayList<>();
        for(int i = 0; i < points.length; i++){
            for(int j = i + 1; j < points.length; j++){
                int[] a1 = points[i];
                int[] a2 = points[j];
                int cost = manhattanDist(a1, a2);
                Edge e = new Edge(i, j, cost);
                list.add(e);
            }
        }
        Collections.sort(list, Comparator.comparingInt(o-> o.cost));
        UnionFind uf = new UnionFind(points.length);
        int ret = 0;
        for(int i = 0; i < list.size(); i++){
            Edge e = list.get(i);
            int x = e.point1;
            int y = e.point2;
            int cost = e.cost;
            if(!uf.isConected(x, y)){
                uf.union(x,y);
                ret+=cost;
            }
        }
        return ret;
    }

    /**
     * prim算法
     * 在未访问的点里，找到一个点，这个点与现有图中的点里，距离是最近的，加入到最小生成树中，并且置该点为已访问
     * @param points
     * @return
     */
    public int minCostConnectPoints2(int[][] points) {
        int ret = 0;
        boolean[] flags = new boolean[points.length];
        List<Integer> list = new ArrayList<>();
        list.add(0);
        flags[0] = true;
        int count = 1;
        int minIndex = -1;
        Map<String, Integer> map = new HashMap<>();
        for(int i = 0; i < points.length; i++){
            for(int j = 0; j < points.length; j++){
                int[] a1 = points[i];
                int[] a2 = points[j];
                int cost = manhattanDist(a1, a2);
                String key = i + "_" + j;
                map.put(key, cost);
            }
        }
        while(count < points.length){
            int min = Integer.MAX_VALUE;
            for(int i = 0; i < list.size(); i++){
                for(int j = 0; j < points.length; j++){
                    if(flags[j] == false){
                        String key = list.get(i) + "_" + j;
                        int cost = map.get(key);
                        if(cost <= min){
                            min = cost;
                            minIndex = j;
                        }
                    }
                }
            }
            list.add(minIndex);
            flags[minIndex] = true;
            count++;
            ret+=min;
        }
        return ret;
    }
    public static void main(String[] args) {
        int[][] a = {{0,0},{2,2},{3,10},{5,2},{7,0}};
        MinCosttoConnectAllPoints m = new MinCosttoConnectAllPoints();
        int ret = m.minCostConnectPoints2(a);
        System.out.println(ret);
    }
}
