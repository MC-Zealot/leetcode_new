package com.leetcode_6th.jianzhiOffer;

/**
 * 剑指 Offer 29. 顺时针打印矩阵
 * 输入一个矩阵，按照从外向里以顺时针的顺序依次打印出每一个数字。
 *
 *
 *
 * 示例 1：
 *
 * 输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
 * 输出：[1,2,3,6,9,8,7,4,5]
 * 示例 2：
 *
 * 输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
 * 输出：[1,2,3,4,8,12,11,10,9,5,6,7]
 *
 *
 * 限制：
 *
 * 0 <= matrix.length <= 100
 * 0 <= matrix[i].length <= 100
 */
public class SpiralOrder {
    boolean[][] flags;
    public int[] spiralOrder(int[][] matrix) {
        int m = matrix.length;
        if(m == 0){
            return new int[0];
        }
        int n = matrix[0].length;
        if(n == 0){
            return new int[0];
        }
        flags = new boolean[m][n];
        int num = m * n;
        int index = 0;
        int i = 0;
        int j = 0;
        int[] ret = new int[num];
        while(index < num){
            while (j < n && flags[i][j] ==false){
                ret[index++] = matrix[i][j];
                flags[i][j] = true;
                j++;
            }
            j--;
            i++;
            while (i < m && flags[i][j] == false){
                ret[index++] = matrix[i][j];
                flags[i][j] = true;
                i++;
            }
            i--;
            j--;
            while (j >=0 && flags[i][j] == false){
                ret[index++] = matrix[i][j];
                flags[i][j] = true;
                j--;
            }
            j++;
            i--;
            while (i>=0 && flags[i][j] == false){
                ret[index++] = matrix[i][j];
                flags[i][j] = true;
                i--;
            }
            i++;
            j++;
        }
        return ret;
    }

    public static void main(String[] args) {
        SpiralOrder so = new SpiralOrder();
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        int[] ret = so.spiralOrder(matrix);
        for(int i = 0; i < ret.length;i++){
            System.out.print(ret[i]+" ");
        }

    }
     
}
