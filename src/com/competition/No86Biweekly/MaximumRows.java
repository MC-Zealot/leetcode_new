package com.competition.No86Biweekly;

import java.util.ArrayList;
import java.util.List;

public class MaximumRows {
    int[][] mat;
    int max = 0;
    public int maximumRows(int[][] mat, int cols) {
        this.mat = mat;
        dfs(mat[0].length, 0, cols, new ArrayList<>());
        return max;
    }
    public int[] getCols(int n){
        int[] ret = new int[n];

        return ret;
    }
    public void dfs(int m, int index, int n, List<Integer> tmp){
        if(tmp.size() == n){
//            System.out.println(tmp);
            int[][] newMat = new int[mat.length][mat[0].length];
            for(int i = 0; i < mat.length; i++){
                for(int j = 0; j < mat[0].length; j++){
                    newMat[i][j] = mat[i][j];
                }
            }
            resetMat(newMat, tmp);
//            System.out.println(newMat);
            int num = cal0rowNum(newMat);
            max = Math.max(max, num);
            return;
        }
        for(int i = index; i < m; i++){
            if(tmp.size() == n){
                return;
            }
            tmp.add(i);
            dfs(m, i + 1, n, tmp);
            tmp.remove(tmp.size() - 1);
        }
    }

    public void resetMat(int[][] mat, List<Integer> cols){
        for(int i = 0; i < cols.size(); i++){
            int col = cols.get(i);
            for(int j = 0; j < mat.length; j++){
                mat[j][col] = 0;
            }
        }
    }
    public int cal0rowNum(int[][] mat){
        int ret = 0;
        for(int i = 0; i < mat.length; i++){
            int flag = 0;
            for(int j = 0; j < mat[0].length; j++){
                if(mat[i][j] != 0){
                    flag = 1;
                    break;
                }
            }
            if(flag == 0){
                ret++;
            }
        }
        return ret;
    }
    public static void main(String[] args) {
        MaximumRows m = new MaximumRows();
//        m.dfs(6, 0, 3, new ArrayList<>());
        int[][] mat = { {0,0,0},
                        {1,0,1},
                        {0,1,1},
                        {0,0,1}};
        int ret = m.maximumRows(mat, 2);
        System.out.println(ret);
    }


}
