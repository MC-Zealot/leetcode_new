package com.leetcode_6th.jianzhiOffer;

/**
 * 剑指 Offer 04. 二维数组中的查找
 * 在一个 n * m 的二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。请完成一个高效的函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 * 示例:
 *
 * 现有矩阵 matrix 如下：
 *
 * [
 *   [1,   4,  7, 11, 15],
 *   [2,   5,  8, 12, 19],
 *   [3,   6,  9, 16, 22],
 *   [10, 13, 14, 17, 24],
 *   [18, 21, 23, 26, 30]
 * ]
 * 给定 target=5，返回true。
 *
 * 给定target=20，返回false。
 *
 *
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode.cn/problems/er-wei-shu-zu-zhong-de-cha-zhao-lcof
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
public class FindNumberIn2DArray {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        int m = matrix.length;
        int n = matrix[0].length;
        int i = 0;
        int j = n - 1;
        while(i < m && j >= 0){
            if(matrix[i][j] == target){
                return true;
            }else if(matrix[i][j] > target){
                j--;
            }else{
                i++;
            }
        }
        return false;
    }
    public boolean findNumberIn2DArray2(int[][] matrix, int target) {
        int m = matrix.length;
        if(m == 0){
            return false;
        }
        int n = matrix[0].length;
        if(n == 0){
            return false;
        }
        int col = binarySearch(matrix[0], target);
        if(matrix[0][col] == target){
            return true;
        }
        int[] nums = new int[m];
        for(int i = 0; i < nums.length; i++){
            nums[i] = matrix[i][col];
        }
        int row = binarySearch(nums, target);
        if(matrix[row][col] == target){
            return true;
        }
        return false;
    }

    /**
     * 如果找到了，则返回下标
     * 如果没找到，则返回i（nums[i] < target）
     * @param nums
     * @param target
     * @return
     */
    public int binarySearch(int[] nums, int target){
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            int mid = i + (j - i) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                j = mid - 1;
            }else{
                i = mid + 1;
            }
        }
        return i;
    }
    public int binarySearch2(int[] nums, int target){
        int i = 0;
        int j = nums.length - 1;
        while(i < j){
            int mid = i + (j - i) / 2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] > target){
                j = mid - 1;
            }else{
                i = mid + 1;
            }
        }
        return j;
    }

    public static void main(String[] args) {
        FindNumberIn2DArray f = new FindNumberIn2DArray();
        int[][] matrix = 
                {
  {1,   4,  7, 11, 15},
  {2,   5,  8, 12, 19},
  {3,   6,  9, 16, 22},
  {10, 13, 14, 17, 24},
  {18, 21, 23, 26, 30}
};
        boolean ret = f.findNumberIn2DArray(matrix, 20);
        System.out.println(ret);
    }
}
