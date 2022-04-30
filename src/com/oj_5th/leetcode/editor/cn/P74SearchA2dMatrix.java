//编写一个高效的算法来判断 m x n 矩阵中，是否存在一个目标值。该矩阵具有如下特性： 
//
// 
// 每行中的整数从左到右按升序排列。 
// 每行的第一个整数大于前一行的最后一个整数。 
// 
//
// 
//
// 示例 1： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
//输出：true
// 
//
// 示例 2： 
//
// 
//输入：matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
//输出：false
// 
//
// 
//
// 提示： 
//
// 
// m == matrix.length 
// n == matrix[i].length 
// 1 <= m, n <= 100 
// -104 <= matrix[i][j], target <= 104 
// 
// Related Topics 数组 二分查找 矩阵 
// 👍 466 👎 0


package com.oj_5th.leetcode.editor.cn;
/*
*   [74] search-a-2d-matrix
*   2021-07-25 18:17:12
*/
public class P74SearchA2dMatrix{
    public static void main(String[] args) {
        Solution solution = new P74SearchA2dMatrix().new Solution();
        // TO TEST
        int[][] matrix = {{1}};
        int target = 1;
        System.out.println(solution.searchMatrix(matrix, target));
    }
    //[74] search-a-2d-matrix
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public boolean searchMatrix2(int[][] matrix, int target) {
        boolean ret = false;
        for(int i = 0; i < matrix.length; i++){
            for(int j = 0; j < matrix[0].length; j++){
                if(target == matrix[i][j]){
                    return true;
                }else if(target < matrix[i][j]){
                    return false;
                }
            }
        }
        return ret;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int i = binaryFindRow(matrix, target);
        if(i<0){
            return false;
        }
        return binaryFind(matrix[i], target);
    }
    public int binaryFindRow(int[][] matrix, int target){
        int i = -1;
        int j = matrix.length - 1;
        while(i < j){
            int mid = (i + j + 1) / 2;
            int mid_value = matrix[mid][0];
            if(mid_value==target){
                return mid;
            }else if(mid_value<target){
                i = mid;
            }else{
                j = mid - 1;
            }
        }
        return i;
    }
        public boolean binaryFind(int[] row, int target){
            int col = 0;
            int i = 0;
            int j = row.length - 1;
            while(i <= j){
                int mid = (i + j)/2;
                if(target == row[mid]){
                    return true;
                }else if(target > row[mid]){
                    i = mid+1;
                }else {
                    j = mid -1;
                }
            }
            return false;
        }
}
//leetcode submit region end(Prohibit modification and deletion)

}