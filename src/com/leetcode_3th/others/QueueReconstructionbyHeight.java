package com.leetcode_3th.others;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * 假设有打乱顺序的一群人站成一个队列。 每个人由一个整数对(h, k)表示，其中h是这个人的身高，k是排在这个人前面且身高大于或等于h的人数。 编写一个算法来重建这个队列。

注意：
总人数少于1100人。

示例

输入:
[[7,0], [4,4], [7,1], [5,0], [6,1], [5,2]]

输出:
[[5,0], [7,0], [5,2], [6,1], [4,4], [7,1]]

Suppose you have a random list of people standing in a queue. Each person is described by a pair of integers (h, k), 

where h is the height of the person and k is the number of people in front of this person who have a height greater than or equal to h. 

Write an algorithm to reconstruct the queue.

Note:
The number of people is less than 1,100.


 * 
 * @author Zealot
 * @date Aug 2, 2019 4:38:40 PM 
 *
 */
public class QueueReconstructionbyHeight {
	/**
	 * 1、按身高从小到大排序 [4,4], [5,0], [5,2], [6,1], [7,0], [7,1]
	 * 
	 * 2、从小到大占坑，规则：当前元素放在k的位置，如果前边有x个小于当前元素的元素，则放在x+k，如果x+k被占了，往后+1循环
	 * 
	 * 
	 * The key to solve this problem is finding the start point of reconstruction.
	 * For this problem, we can start adding the largest element first. The basic
	 * idea is to keep adding the largest element each time, until all elements are
	 * in place.
	 * 就是依然按照ｈ降序排序，但是如果ｈ相等则按照ｋ升序排序．然后开一个新数组，因为数组按照降序排序，
	 * 
	 * 所以每次只需要将元素插入到新数组的k的位置即可．两种方法时间复杂度都是O(n*2)，但是第二种更容易理解和实现
	 * 
	 * @date Aug 2, 2019 5:15:03 PM
	 * @param people
	 * @return
	 */
	public int[][] reconstructQueue(int[][] people) {
	    int[][] result = new int[people.length][];
	    Arrays.sort(people, new Comparator<int[]>(){//身高h从高到底排序，如果身高相等，则按照下标k从低到高排序
	        public int compare(int[] a1, int[] a2){
	            if(a1[0]!=a2[0]){
	                return a2[0]-a1[0];
	            }else{
	                return a1[1]-a2[1];
	            }
	        }
	    });
	 
	    List<int[]> list = new ArrayList<int[]>();
	 
	    for(int i=0; i<people.length; i++){
	        int[] p = people[i];
	        System.out.println(p[1]+": "+p[0] +", "+p[1]);//相同下标，身高高的在后边
	        list.add(p[1],p);//如果序号相同，则加在当前序号的前边，有点像，数组，每个元素是一个链表，加到了链表的头结点
	    }
	    //
	 System.out.println(list.toString());
	    for(int i=0; i<result.length; i++){
	        result[i]=list.get(i);
	    }
	 
	    return result;
	}

	public static void main(String[] args) {
//		[[2,4],[3,4],[9,0],[0,6],[7,1],[6,0],[7,3],[2,5],[1,1],[8,0]]
//		排序：[[0, 6], [1, 1], [2, 4], [2, 5], [3, 4], [6, 0], [7, 1], [7, 3], [8, 0], [9, 0]]
//				输出
//				[[6,0],[1,1],[7,1],[8,0],[9,0],[2,4],[2,5],[3,4],[7,3],[0,0]]
//				预期结果
//				[[6,0],[1,1],[8,0],[7,1],[9,0],[2,4],[0,6],[2,5],[3,4],[7,3]]
		QueueReconstructionbyHeight q = new QueueReconstructionbyHeight();
//		int[][] nums = {{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}}; 
//		int[][] nums = {{2,4},{3,4},{9,0},{0,6},{7,1},{6,0},{7,3},{2,5},{1,1},{8,0}}; 
		
//		输入
//		{{8,2},{4,2},{4,5},{2,0},{7,2},{1,4},{9,1},{3,1},{9,0},{1,0}};
//		排序：
//		[[1,4],[1,0],[2,0],[3,1],[4,2],[4,5],[7,2],[8,2],[9,1],[9,0]]
//		输出
//		[[5,0],[7,0],[6,1],[5,2],[4,4],[7,1]]
//		预期结果
//		[[5,0],[7,0],[5,2],[6,1],[4,4],[7,1]]
		int[][] nums = {{8,2},{4,2},{4,5},{2,0},{7,2},{1,4},{9,1},{3,1},{9,0},{1,0}};
//		ArraysCom com = new ArraysCom();
//		Arrays.sort(nums,com);
//		for(int i = 0; i < nums.length; i++) {
//			for(int j = 0; j < nums[0].length; j++) {
//				System.out.print(nums[i][j]+" ");
//			}
//			System.out.println();
//		}
//		nums=q.reconstructQueue(nums);
//		for(int i = 0; i < nums.length; i++) {
//			for(int j = 0; j < nums[0].length; j++) {
//				System.out.print(nums[i][j]+" ");
//			}
//			System.out.println();
//		}
		List<int[]> list = new ArrayList<int[]>();
		int[] p = {1,0};//最高的前边一定是0个比他还高的，所以用k当做下标，是必须从0开始
		int[] p1 = {1,1};
		list.add(p[1], p);
		list.add(p1[1], p1);
		for(int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i)[0]+", "+list.get(i)[1]);
		}
		
	}
}
