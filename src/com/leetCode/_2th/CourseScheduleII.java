package com.leetCode._2th;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * 
 * Some courses may have prerequisites, for example to take course 0 you have to
 * first take course 1, which is expressed as a pair: [0,1]
 * 
 * Given the total number of courses and a list of prerequisite pairs, return
 * the ordering of courses you should take to finish all courses.
 * 
 * There may be multiple correct orders, you just need to return one of them. If
 * it is impossible to finish all courses, return an empty array.
 * 
 * For example:
 * 
 * 2, [[1,0]] There are a total of 2 courses to take. To take course 1 you
 * should have finished course 0. So the correct course order is [0,1]
 * 
 * 4, [[1,0],[2,0],[3,1],[3,2]] There are a total of 4 courses to take. To take
 * course 3 you should have finished both courses 1 and 2. Both courses 1 and 2
 * should be taken after you finished course 0. So one correct course order is
 * [0,1,2,3]. Another correct ordering is[0,2,1,3].
 * 
 * @author Zealot
 * @date 2016年4月5日 下午10:07:18
 *
 */
public class CourseScheduleII {
	public int[] findOrder(int numCourses, int[][] prerequisites) {  
        List<Set<Integer>> adjLists = new ArrayList<Set<Integer>>();  
        for (int i = 0; i < numCourses; i++) {  
            adjLists.add(new HashSet<Integer>());  
        }  
          
        for (int i = 0; i < prerequisites.length; i++) {  
            adjLists.get(prerequisites[i][1]).add(prerequisites[i][0]);  
        }  
          
        int[] indegrees = new int[numCourses];  
        for (int i = 0; i < numCourses; i++) {  
            for (int x : adjLists.get(i)) {  
                indegrees[x]++;  
            }  
        }  
          
        Queue<Integer> queue = new LinkedList<Integer>();  
        for (int i = 0; i < numCourses; i++) {  
            if (indegrees[i] == 0) {  
                queue.offer(i);  
            }  
        }  
          
        int[] res = new int[numCourses];  
        int count = 0;  
        while (!queue.isEmpty()) {  
            int cur = queue.poll();  
            for (int x : adjLists.get(cur)) {  
                indegrees[x]--;  
                if (indegrees[x] == 0) {  
                    queue.offer(x);  
                }  
            }  
            res[count++] = cur;  
        }  
          
        if (count == numCourses) return res;  
        return new int[0];  
    }  
}
