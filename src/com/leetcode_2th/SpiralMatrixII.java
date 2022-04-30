package com.leetcode_2th;
/**
 * 
 * 
 * @author Zealot
 * @date 2016年7月19日 下午10:17:31 
 *
 */
public class SpiralMatrixII {
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
}
