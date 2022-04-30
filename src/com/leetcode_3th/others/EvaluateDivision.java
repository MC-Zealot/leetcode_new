package com.leetcode_3th.others;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;

/**
 * 给出方程式 A / B = k, 其中 A 和 B 均为代表字符串的变量， k 是一个浮点型数字。根据已知方程式求解问题，并返回计算结果。如果结果不存在，则返回 -1.0。

示例 :
给定 a / b = 2.0, b / c = 3.0
问题: a / c = ?, b / a = ?, a / e = ?, a / a = ?, x / x = ? 
返回 [6.0, 0.5, -1.0, 1.0, -1.0 ]

输入为: 
vector<pair<string, string>> equations, vector<double>& values, vector<pair<string, string>> queries(方程式，方程式结果，问题方程式)， 

其中 equations.size() == values.size()，即方程式的长度与方程式结果长度相等（程式与结果一一对应），并且结果值均为正数。以上为方程式的描述。

返回vector<double>类型。

基于上述例子，输入如下：

equations(方程式) = [ ["a", "b"], ["b", "c"] ],
values(方程式结果) = [2.0, 3.0],
queries(问题方程式) = [ ["a", "c"], ["b", "a"], ["a", "e"], ["a", "a"], ["x", "x"] ]. 
输入总是有效的。你可以假设除法运算中不会出现除数为0的情况，且不存在任何矛盾的结果。

 * 
 * @author Zealot
 * @date Aug 4, 2019 4:42:56 PM 
 *
 */
public class EvaluateDivision {
//	给出一系列字符串之间的比率关系，求任意两个字符串之间的比率，若不存在则返回-1.0，若两个字符串相等，则返回1.0。从本质来看是要遍历图，
//	查找是否存在顶点A到另一个顶点的路径，这里我们用邻接表法表示图，然后用一个对应的hashmap保存一个点和其邻接点的比率。然后查找两个字符串之间
//	的比率就变成了求图中一个顶点到一个顶点的路径，然后路径上的值乘积。这里需要注意的是若a/b = c,那么b/a = 1/c;
//	在遍历的时候用一个hashset记录当前被遍历过的点，当当前点已经被遍历过那么这条路径不通，返回0.0。
	public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
		int length = equations.size();
		HashMap<String, ArrayList<String>> neighbors = new HashMap<String, ArrayList<String>>(); // 记录每个点的邻接顶点
		HashMap<String, ArrayList<Double>> neighborsValue = new HashMap<String, ArrayList<Double>>();// 记录个点邻接顶点对应的值

		for (int i = 0; i < length; i++) { // 若a/b = c,那么b/a = 1/c;
			if (!neighbors.containsKey(equations.get(i).get(0))) {
				neighbors.put(equations.get(i).get(0), new ArrayList<String>());
				neighborsValue.put(equations.get(i).get(0), new ArrayList<Double>());
			}
			if (!neighbors.containsKey(equations.get(i).get(1))) {
				neighbors.put(equations.get(i).get(1), new ArrayList<String>());
				neighborsValue.put(equations.get(i).get(1), new ArrayList<Double>());
			}

			neighbors.get(equations.get(i).get(0)).add(equations.get(i).get(1));
			neighborsValue.get(equations.get(i).get(0)).add(values[i]);

			neighbors.get(equations.get(i).get(1)).add(equations.get(i).get(0));
			neighborsValue.get(equations.get(i).get(1)).add(1 / values[i]);
		}

		double[] res = new double[queries.size()];
		for (int i = 0; i < queries.size(); i++) {
			String a = queries.get(i).get(0);
			String b = queries.get(i).get(1);
			res[i] = dfs(1.0, a, b, neighbors, neighborsValue, new HashSet<String>());// hashset用来保存已经遍历过的点
			if (res[i] == 0.0)
				res[i] = -1.0;
		}
		return res;
	}

	public double dfs(double value, String a, String b, HashMap<String, ArrayList<String>> neighbors,
			HashMap<String, ArrayList<Double>> neighborsValue, HashSet<String> hashSet) {
		if (hashSet.contains(a)) // 已经遍历过该点
			return 0.0;
		if (!neighbors.containsKey(a))
			return 0.0; // 不存在该点
		if (a.equals(b))
			return value;
		hashSet.add(a); // 标记为已遍历
		List<String> neigh = neighbors.get(a);
		List<Double> neighValues = neighborsValue.get(a);
		double tmp = 0.0;
		for (int i = 0; i < neigh.size(); i++) {
			String dot = neigh.get(i);
			double dotValue = neighValues.get(i);
			tmp = dfs(value * dotValue, dot, b, neighbors, neighborsValue, hashSet);
			if (tmp != 0.0) // 不为0，那么找到了结果，直接break,不需要继续查找
				break;
		}
		hashSet.remove(a);
		return tmp;
	}

}
