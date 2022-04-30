//给定 n 个非负整数表示每个宽度为 1 的柱子的高度图，计算按此排列的柱子，下雨之后能接多少雨水。 
//
// 
//
// 示例 1： 
//
// 
//
// 
//输入：height = [0,1,0,2,1,0,1,3,2,1,2,1]
//输出：6
//解释：上面是由数组 [0,1,0,2,1,0,1,3,2,1,2,1] 表示的高度图，在这种情况下，可以接 6 个单位的雨水（蓝色部分表示雨水）。 
// 
//
// 示例 2： 
//
// 
//输入：height = [4,2,0,3,2,5]
//输出：9
// 
//
// 
//
// 提示： 
//
// 
// n == height.length 
// 0 <= n <= 3 * 104 
// 0 <= height[i] <= 105 
// 
// Related Topics 栈 数组 双指针 动态规划 单调栈 
// 👍 2490 👎 0


package com.oj_5th.leetcode.editor.cn;
/*
*   [42] trapping-rain-water
*   2021-07-17 21:21:00
*/
public class P42TrappingRainWater{
    public static void main(String[] args) {
        Solution solution = new P42TrappingRainWater().new Solution();
        // TO TEST
    }
    //[42] trapping-rain-water
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int trap(int[] height) {
        int res = 0, l = 0, r = height.length - 1;
        while (l < r) {
            int min = Math.min(height[l], height[r]);
            if (min == height[l]) {
                l++;
                while (l < r && height[l] < min) {
                    res += min - height[l++];
                }
            } else {
                r--;
                while (l < r && height[r] < min) {
                    res += min - height[r--];
                }
            }
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}