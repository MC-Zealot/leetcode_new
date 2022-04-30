package com.leetCode._2th;
/**
 * Given a sorted positive integer array nums and an integer n, 
 * add/patch elements to the array such that any number in range [1, n] inclusive can be formed by the sum of some elements 
 * in the array. Return the minimum number of patches required.

Example 1:
nums = [1, 3], n = 6
Return 1.

Combinations of nums are [1], [3], [1,3], which form possible sums of: 1, 3, 4.
Now if we add/patch 2 to nums, the combinations are: [1], [2], [3], [1,3], [2,3], [1,2,3].
Possible sums are 1, 2, 3, 4, 5, 6, which now covers the range [1, 6].
So we only need 1 patch.

Example 2:
nums = [1, 5, 10], n = 20
Return 2.
The two patches can be [2, 4].

Example 3:
nums = [1, 2, 2], n = 5
Return 0.

 * 就是用known_sum表示已知的连续和为[1,known_sum)，有了这个表示那就简单了：

nums[i] <= known_sum，更新已知范围为：[1,known_sum + nums[i] )
nums[i] >  known_sum,  添加known_sum进数组才能达到最大的范围，所以已知范围更新为：[1,known_sum *2  )
 * @author Zealot
 * @date 2016年4月14日 下午2:56:16 
 *
 */
public class PatchingArray {
	public int minPatches(int[] nums, int n) {
		long miss = 1; int res = 0, i = 0;
        while (miss <= n) {
            if (i < nums.length && nums[i] <= miss) {
                miss += nums[i++];
            } else {
                miss += miss;
                ++res;
            }
        }
        return res;
    }
	public static void main(String[] args) {
		PatchingArray p  = new PatchingArray();
		int[] nums = {1, 10};
//		int[] nums = {1, 2, 4, 11, 30};
		p.minPatches(nums, 15);
	}
}
