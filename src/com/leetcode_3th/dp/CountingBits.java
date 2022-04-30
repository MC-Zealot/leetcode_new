package com.leetcode_3th.dp;

/**
 * 给定一个非负整数 num。对于 0 ≤ i ≤ num 范围中的每个数字 i ，计算其二进制数中的 1 的数目并将它们作为数组返回。

示例 1:

输入: 2
输出: [0,1,1]
示例 2:

输入: 5
输出: [0,1,1,2,1,2]
进阶:
1
10
11
100
101
110
111
给出时间复杂度为O(n*sizeof(integer))的解答非常容易。但你可以在线性时间O(n)内用一趟扫描做到吗？
要求算法的空间复杂度为O(n)。
你能进一步完善解法吗？要求在C++或任何其他语言中不使用任何内置函数（如 C++ 中的 __builtin_popcount）来执行此操作。
 * 
 * @author Zealot
 * @date Jul 30, 2019 10:32:08 PM 
 *
 */
public class CountingBits {
	public int[] countBits(int num) {
		int[] res = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			int tmp = i;
			int len_1 = 0;
			while (tmp > 0) {
				if ((tmp & 1) == 1) {
					len_1++;
				}
				tmp = tmp >> 1;
			}
			res[i] = len_1;
		}
		return res;
	}
	
	/**
	 * 想一想，当一个数为2的整数幂的时候，1的个数为1，比如2（10) 和4(100)，8(1000)

在这之后就是前一个序列的数+1 比如 9(1001) = 1(1) + 8 (1) = 2

就是把一个数分解为小于它的最大2的整数幂 + x
	 * @date Jul 31, 2019 10:36:17 AM
	 * @param num
	 * @return
	 */
	public int[] countBits2(int num) {
		int[] res = new int[num + 1];
		int pow2 = 1, before = 1;
		for (int i = 1; i <= num; i++) {
			if (i == pow2) {
				before = res[i] = 1;
				pow2 <<= 1;
			} else {
				res[i] = res[before] + 1;
				before += 1;
			}
		}
		return res;
	}
	public static void main(String[] args) {
		CountingBits c = new CountingBits();
		System.out.println(c.countBits2(10));
	}
}
