//给你一个未排序的整数数组 nums ，请你找出其中没有出现的最小的正整数。 
//请你实现时间复杂度为 O(n) 并且只使用常数级别额外空间的解决方案。
//
// 
//
// 示例 1： 
//
// 
//输入：nums = [1,2,0]
//输出：3
// 
//
// 示例 2： 
//
// 
//输入：nums = [3,4,-1,1]
//输出：2
// 
//
// 示例 3： 
//
// 
//输入：nums = [7,8,9,11,12]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= nums.length <= 5 * 105 
// -231 <= nums[i] <= 231 - 1 
// 
// Related Topics 数组 哈希表 
// 👍 1152 👎 0


package com.oj_5th.leetcode.editor.cn;

import java.util.HashSet;
import java.util.Set;

/*
*   [41] first-missing-positive
*   2021-08-01 22:44:00
*/
public class P41FirstMissingPositive{
    public static void main(String[] args) {
        Solution solution = new P41FirstMissingPositive().new Solution();
        // TO TEST
        int[] nums = {1,2,3,10,2147483647,9};
        System.out.println(solution.firstMissingPositive(nums));
    }
    //[41] first-missing-positive
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int firstMissingPositive(int[] nums) {
        if(nums==null||nums.length==0){
            return 0;
        }
        Set<Integer> s = new HashSet<Integer>();
        int max = Integer.MIN_VALUE;
        for(int i = 0; i < nums.length; i++){
            s.add(nums[i]);
            if(max< nums[i]){
                max = nums[i];
            }
        }
        if(max<Integer.MAX_VALUE){
            max++;
        }
        for(int i = 1; i <= max; i++){
            if(!s.contains(i)){
                return i;
            }
        }
        return 1;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}