//给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。 
//
// 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。 
//
// 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。 
//
// 
//
// 示例 1： 
//
// 
//输入：[7,1,5,3,6,4]
//输出：5
//解释：在第 2 天（股票价格 = 1）的时候买入，在第 5 天（股票价格 = 6）的时候卖出，最大利润 = 6-1 = 5 。
//     注意利润不能是 7-1 = 6, 因为卖出价格需要大于买入价格；同时，你不能在买入前卖出股票。
// 
//
// 示例 2： 
//
// 
//输入：prices = [7,6,4,3,1]
//输出：0
//解释：在这种情况下, 没有交易完成, 所以最大利润为 0。
// 
//
// 
//
// 提示： 
//
// 
// 1 <= prices.length <= 105 
// 0 <= prices[i] <= 104 
// 
// Related Topics 数组 动态规划 
// 👍 1736 👎 0


package com.oj_5th.leetcode.editor.cn;
/*
*   [121] best-time-to-buy-and-sell-stock
*   2021-07-25 21:42:56
*/
public class P121BestTimeToBuyAndSellStock{
    public static void main(String[] args) {
        Solution solution = new P121BestTimeToBuyAndSellStock().new Solution();
        // TO TEST
    }
    //[121] best-time-to-buy-and-sell-stock
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int maxProfit(int[] prices) {
        int[] nums = new int[prices.length];
        nums[0]=0;
        for(int i = 1; i < prices.length; i++){
            nums[i] = prices[i] - prices[i - 1];
        }
        return maxSubArray(nums);
    }
    public int maxSubArray(int[] nums) {
        int ret = 0;
        int local_max = nums[0];
        for(int i = 0; i < nums.length; i++){
            local_max = Math.max(local_max + nums[i], nums[i]);
            ret = Math.max(local_max, ret);
        }

        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}