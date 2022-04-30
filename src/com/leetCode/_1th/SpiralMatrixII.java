package com.leetCode._1th;
/**
 * Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]
     * -> -> ->
     * ^      |
     * |      |
     * <- <-- V
     * 
     * # # # #
     * %     $
     * %     $
     * & & & $
     *     
     
 * @author Zealot
 * @date 2015年8月24日 下午7:54:43
 */
public class SpiralMatrixII {
	/**
	 * 又做了一遍
	 * 细节
	 * @date 2016年3月20日 下午4:50:34
	 * @param n
	 * @return
	 */
	public int[][] generateMatrix(int n) {
		int[][] res = new int[n][n];
		int num = 1;
        int level = (int) Math.ceil(n / 2.);

        for(int i = 0; i < level; i++) {

            // top left -> right, shown as #
            for(int j = i; j < n - i; j++)
                res[i][j] = num++;

            // top right + 1 -> bot, shown as $
            for(int j = i + 1; j < n - i; j++)
                res[j][n - i - 1] = num++;

            // bot right - 1 -> left, shown as &
            for(int j = n - i - 2; j >= i; j--)
                res[n - i - 1][j] = num++;

            // bot left -1 -> top + 1, shown as %
            for(int j = n - i - 2; j > i; j--)
                res[j][i] = num++;
        }
        return res;
	}
	public static void main(String[] args) {
		int n =9;
		int level = (int) Math.ceil(n / 2.);
		System.out.println(level);
	}
}
