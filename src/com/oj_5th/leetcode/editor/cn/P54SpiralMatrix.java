package com.oj_5th.leetcode.editor.cn;//给你一个 m 行 n 列的矩阵 matrix ，请按照 顺时针螺旋顺序 ，返回矩阵中的所有元素。
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,2,3],[4,5,6],[7,8,9]]
//输出：[1,2,3,6,9,8,7,4,5]
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,2,3,4],[5,6,7,8],[9,10,11,12]]
//输出：[1,2,3,4,8,12,11,10,9,5,6,7]
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 10 
// -100 <= matrix[i][j] <= 100 
// 
// Related Topics 数组 矩阵 模拟 
// 👍 811 👎 0




import java.util.ArrayList;
import java.util.List;

/*
*   [54] spiral-matrix
*   2021-07-05 22:46:17
*/
public class P54SpiralMatrix{
    public static void main(String[] args) {
        Solution solution = new P54SpiralMatrix().new Solution();
        // TO TEST
        int[][] input = {{1,2,3},{4,5,6},{7,8,9}};
        solution.spiralOrder(input);
    }

    //leetcode submit region begin(Prohibit modification and deletion)
    //[54] spiral-matrix
class Solution {
        int h = 0;//横向
        int s = 0;//纵向
        int d = 1;
        public List<Integer> spiralOrder(int[][] matrix) {
            List<Integer> res = new ArrayList<Integer>();
            int[][] flags = new int[matrix.length][matrix[0].length];
            while (res.size() < matrix[0].length * matrix.length) {
                //run
                flags = run(matrix, flags, res);
                //换方向
                d += 1;
                if (d > 4) {
                    d = 1;
                }
            }
            return res;
        }
        public int[][] run(int[][] matrix, int[][] flags, List<Integer> res) {
            int ss = s;
            int hh = h;
            if (d == 1) {//h动，s不动
                for (int i = 0; i < matrix[0].length; i++) {
                    if (flags[ss][i] == 0) {
                        res.add(matrix[ss][i]);
                        flags[ss][i] = 1;
                        h = i;
                    }
                }
            } else if (d == 2) {//s动，h不动
                for (int i = 0; i < matrix.length; i++) {
                    if (flags[i][hh] == 0) {
                        res.add(matrix[i][hh]);
                        flags[i][hh] = 1;
                        s=i;
                    }
                }
            } else if (d == 3) {//h动，s不动
                for (int i = matrix[0].length - 1; i >= 0; i--) {
                    if (flags[ss][i] == 0) {
                        res.add(matrix[ss][i]);
                        flags[ss][i] = 1;
                        h = i;
                    }
                }
            } else {//s动，h不动
                for (int i = matrix.length - 1; i >= 0; i--) {
                    if (flags[i][hh] == 0) {
                        res.add(matrix[i][hh]);
                        flags[i][hh] = 1;
                        s=i;
                    }
                }
            }  return flags;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}