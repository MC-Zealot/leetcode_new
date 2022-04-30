package com.leetcode_3th.dp;

import java.util.ArrayList;
import java.util.List;

/**
 * 给定一个只包含正整数的非空数组。是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。

注意:

每个数组中的元素不会超过 100
数组的大小不会超过 200
示例 1:

输入: [1, 5, 11, 5]

输出: true

解释: 数组可以分割成 [1, 5, 5] 和 [11].
 

示例 2:

输入: [1, 2, 3, 5]

输出: false

解释: 数组不能分割成两个元素和相等的子集.

 * 
 * @author Zealot
 * @date Jul 31, 2019 10:37:50 AM 
 *
 */
public class PartitionEqualSubsetSum {
	boolean res = false;
	/**
	 * 超时
	 * @date Jul 31, 2019 1:14:36 PM
	 * @param nums
	 * @return
	 */
	public boolean canPartition(int[] nums) {
		dfs(0, nums, new ArrayList<Integer>(), 0, new boolean[nums.length]);
		return res;
	}

	public void dfs(int curr, int[] nums, List<Integer> list1, int sum, boolean[] flags) {
		if(list1.size()>nums.length) {
			return;
		}
		int another_sum=0;
		for(int i = 0;i < nums.length; i++) {
			if(flags[i]==false) {
				another_sum+=nums[i];
			}
		}
		
		if(another_sum==sum) {
			res=true;
			return;
		}
		
		for (int i = curr; i < nums.length; i++) {
			list1.add(nums[i]);
			flags[i] = true;
			dfs(i + 1, nums, list1, sum + nums[i],flags);
			list1.remove(list1.size() - 1);
			flags[i] = false;
		}
	}
	public static void main(String[] args) {
		PartitionEqualSubsetSum p = new PartitionEqualSubsetSum();
		int[] a = {1, 2, 3, 5};
		System.out.println(p.canPartition(a));
	}
	
	/**
	 * 思路：一个背包的题目，背包容量为数组中元素和的一半＋１，这样只要看是否有元素可以正好填满背包即可．
	 * 
	 * 但是每个元素只能用一次，所以在尝试放一个元素的时候还要避免他对尝试放其他位置时对自己的影响．
	 * 
	 * 所以在尝试放一个元素到背包的时候需要从容量最大的位置开始，如果（当前位置－当前元素大小）位置可以通过放置之前的元素达到，
	 * 
	 * 则当前位置也可以通过放置当前元素正好达到这个位置．
	 * 
	 * 状态转移方程为：dp[i] = dp[i] || dp[i - nums[k]];
	 * @date Jul 31, 2019 1:37:03 PM
	 * @param nums
	 * @return
	 */
	public boolean canPartition2(int[] nums) {

		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
		}
		if ((sum & 1) == 1)
			return false;
		boolean[] dp = new boolean[sum / 2 + 1];
		dp[0] = true;
		for (int i = 0; i < nums.length; i++) {
			for (int j = sum / 2; j >= nums[i]; j--) {
				dp[j] = dp[j] || dp[j - nums[i]];
			}
		}
		return dp[sum / 2];
	}
	

/**
大佬给出的一维数组动态规划有点懵逼。
这里先给出二维数组的动态规划，然后给出转化为一维数组的方法。理解起来相信非常容易。
所以这里会给出三个版本的代码：
二维数组动态规划
一维数组动态规划“二维转为一维的中间过程”
一维数组动态规划“最终版”
**/
 
	/**
	 * 
	 * 
 d(i, s) : 是否存在：nums区间[0, i] 中取一些元素，使其和为s
 d(i, s) = d(i-1, s){不取nums[i]} || d(i-1, s-nums[i]){取nums[i]}
 max(i) = nums.size()-1
 max(s) = sum(nums)/2
刚开始动态规划不太理解，后来发现：
我们求dp第i行的时候dp[i][?]，我们只需要知道dp的i-1行即可dp[i-1][?]。
也就是说，按照这个依赖关系，一直往下递推，只要得到第0行即可。
而第0行非常容易求。dp[0][s] = true当且仅当nums[0]==s
图解：
     s0 s1 s2 ...              ...sum 
 i-1 [  {s-nums[i]}  ...       s    ]
   i [               ...       s    ]
dp[i][s] = dp[i-1][s] || dp[i-1][s-nums[i]]
这里要保证下标i-1>=0，所以第0行可以单独计算。
计算方法：i==0时，s用j遍历[0, sum(nums)]区间
发现nums[0]==s[j]，则dp[0][j]=true;

	 * @date Jul 31, 2019 1:50:42 PM
	 * @param nums
	 * @return
	 */
	public boolean canPartition3(int[] nums) {
		int sum = 0;
		for (int e : nums) {
			sum += e;
		}
		if ((sum & 1) == 1)// 奇数显然不符合条件
			return false;
		boolean[][] d = new boolean[nums.length][sum / 2 + 1];// sum/=2
		for (int i = 0; i < nums.length; i++) {
			for (int s = 0; s <= sum; s++) {// s range [0, sum(nums)>>1]
				if (i == 0) {
					d[i][s] = (nums[i] == s);// i==0要单独求{ nums[0]一个元素和为s }
				}
				else {
					d[i][s] = d[i - 1][s] || (s - nums[i] >= 0 ? d[i - 1][s - nums[i]] : false);
				}
			}
		}
		return d[nums.length - 1][sum];// [0,nums.size()-1]区间和为sum
	  }
}
