package com.leetcode_3th.dfs;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 现在你总共有 n 门课需要选，记为 0 到 n-1。

在选修某些课程之前需要一些先修课程。 例如，想要学习课程 0 ，你需要先完成课程 1 ，我们用一个匹配来表示他们: [0,1]

给定课程总量以及它们的先决条件，判断是否可能完成所有课程的学习？

示例 1:

输入: 2, [[1,0]] 
输出: true
解释: 总共有 2 门课程。学习课程 1 之前，你需要完成课程 0。所以这是可能的。
示例 2:

输入: 2, [[1,0],[0,1]]
输出: false
解释: 总共有 2 门课程。学习课程 1 之前，你需要先完成​课程 0；并且学习课程 0 之前，你还应先完成课程 1。这是不可能的。
说明:

输入的先决条件是由边缘列表表示的图形，而不是邻接矩阵。详情请参见图的表示法。
你可以假定输入的先决条件中没有重复的边。
提示:

这个问题相当于查找一个循环是否存在于有向图中。如果存在循环，则不存在拓扑排序，因此不可能选取所有课程进行学习。
通过 DFS 进行拓扑排序 - 一个关于Coursera的精彩视频教程（21分钟），介绍拓扑排序的基本概念。
拓扑排序也可以通过 BFS 完成。

 * 
 * @author Zealot
 * @date Aug 1, 2019 2:05:26 PM 
 *
 */
public class CourseSchedule {
	/**
	 * 看到给的第二个测试用例立马就明白了，就是判断这些课程能否构成有向无环图（DAG）。而任何时候判断DAG的方法要立刻想到拓扑排序。

拓扑排序是对有向无环图（DAG）而言的，对图进行拓扑排序即求其中节点的一个拓扑序列，对于所有的有向边（U, V）（由U指向V），
在该序列中节点U都排在节点V之前。

方法是每次选择入度为0的节点，作为序列的下一个节点，然后移除该节点和以从节点出发的所有边。

那这个方法比较简单粗暴了：要循环N次，这个循环次数并不是遍历节点的意思，而是我们如果正常取点的话，N次就能把所有的节点都取完了，
如果N次操作结束还没判断出来，那么就不是DAG.在这N次中，每次都找一个入度为0的点，并把它的入度变为-1，作为已经取过的点不再使用，

同时把从这个点指向的点的入度都-1.

这个过程中，如果找不到入度为0的点，那么说明存在环。如果N次操作，每次都操作成功的去除了一个入度为0的点，那么说明这个图是DAG.

时间复杂度是O(N ^ 2)，空间复杂度是O(N)。
	 * @date Aug 1, 2019 2:36:34 PM
	 * @param numCourses
	 * @param prerequisites
	 * @return
	 */
	public boolean canFinish(int numCourses, int[][] prerequisites) {
		int[][] matrix = new int[numCourses][numCourses]; // i -> j
		int[] indegree = new int[numCourses];

		for (int i = 0; i < prerequisites.length; i++) {
			int ready = prerequisites[i][0];
			int pre = prerequisites[i][1];
			if (matrix[pre][ready] == 0){
				indegree[ready]++; // duplicate case
			}
			matrix[pre][ready] = 1;
		}

		int count = 0;
		Queue<Integer> queue = new LinkedList<Integer>();
		for (int i = 0; i < indegree.length; i++) {
			if (indegree[i] == 0)
				queue.offer(i);
		}
		while (!queue.isEmpty()) {
			int course = queue.poll();
			count++;
			for (int i = 0; i < numCourses; i++) {
				if (matrix[course][i] != 0) {
					if (--indegree[i] == 0)
						queue.offer(i);
				}
			}
		}
		return count == numCourses;
	}
}
