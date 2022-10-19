package com.WebTest.meta;

import com.leetCode.CommonStructure.TreeNode;
import javafx.util.Pair;

import java.util.*;

public class BinaryTreeVerticalOrderTraversal {
    //深度优先遍历树
    //map<序号，List<val>>

    public List<List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Pair<Integer, Integer>>> map = new HashMap<Integer, List<Pair<Integer, Integer>>>();
        dfs(root, map, 0, 0);
        List<Integer> keys = new ArrayList<Integer>(map.keySet());
        Collections.sort(keys);
        List<List<Integer>> ret =new ArrayList<List<Integer>>();
        for(int i = 0; i < keys.size(); i++){
            int k = keys.get(i);
            List<Pair<Integer, Integer>> list = map.get(k);
            Collections.sort(list, Comparator.comparingInt(o->o.getKey()));
            List<Integer> tmp = new ArrayList<Integer>();
            for(int j = 0; j < list.size(); j++){
                tmp.add(list.get(j).getValue());
            }
            ret.add(new ArrayList<Integer>(tmp));
        }
        return ret;
    }
    public void dfs(TreeNode node, Map<Integer, List<Pair<Integer, Integer>>> map, int key, int depth){
        if(node == null){
            return;
        }

        if(map.containsKey(key)){
            map.get(key).add(new Pair(depth, node.val));
        }else{
            List<Pair<Integer, Integer>> list = new ArrayList<Pair<Integer, Integer>>();
            list.add(new Pair<Integer, Integer>(depth, node.val));
            map.put(key, list);
        }
        dfs(node.left, map, key-1, depth + 1);
        dfs(node.right, map, key + 1, depth + 1);
    }
}
