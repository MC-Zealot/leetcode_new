package com.leetcode_6th;

public class RotateMatrix {
    public void rotate(int[][] matrix) {
        int m = matrix.length;
        for(int i = 0; i < matrix.length - 1; i++){
            for(int j= 0;  j < matrix[0].length - i - 1; j++){
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[m - j - 1][m - i - 1];
                matrix[m - j - 1][m-i-1] = tmp;
            }
        }
         for(int i = 0; i < matrix.length/2; i++){
             for(int j = 0; j < matrix[0].length; j++){
                 int tmp = matrix[m - i - 1][j];
                 matrix[m - i - 1][j] = matrix[i][j];
                 matrix[i][j] = tmp;
             }
         }
    }

    public static void main(String[] args) {
        RotateMatrix rm = new RotateMatrix();
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};
        rm.rotate(a);
    }
}
