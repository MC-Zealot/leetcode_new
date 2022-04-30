//给定两个大小分别为 m 和 n 的正序（从小到大）数组 nums1 和 nums2。请你找出并返回这两个正序数组的 中位数 。 
//
// 
//
// 示例 1： 
//
// 
//输入：nums1 = [1,3], nums2 = [2]
//输出：2.00000
//解释：合并数组 = [1,2,3] ，中位数 2
// 
//
// 示例 2： 
//
// 
//输入：nums1 = [1,2], nums2 = [3,4]
//输出：2.50000
//解释：合并数组 = [1,2,3,4] ，中位数 (2 + 3) / 2 = 2.5
// 
//
// 示例 3： 
//
// 
//输入：nums1 = [0,0], nums2 = [0,0]
//输出：0.00000
// 
//
// 示例 4： 
//
// 
//输入：nums1 = [], nums2 = [1]
//输出：1.00000
// 
//
// 示例 5： 
//
// 
//输入：nums1 = [2], nums2 = []
//输出：2.00000
// 
//
// 
//
// 提示： 
//
// 
// nums1.length == m 
// nums2.length == n 
// 0 <= m <= 1000 
// 0 <= n <= 1000 
// 1 <= m + n <= 2000 
// -106 <= nums1[i], nums2[i] <= 106 
// 
//
// 
//
// 进阶：你能设计一个时间复杂度为 O(log (m+n)) 的算法解决此问题吗？ 
// Related Topics 数组 二分查找 分治 
// 👍 4263 👎 0


package com.oj_5th.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
*   [4] median-of-two-sorted-arrays
*   2021-07-18 22:15:11
*/
public class P4MedianOfTwoSortedArrays{
    public static void main(String[] args) {
        Solution solution = new P4MedianOfTwoSortedArrays().new Solution();
        // TO TEST
        int[] num1 = {3};
        int[] num2 = {-2,-1};
        System.out.println(solution.findMedianSortedArrays(num1, num2));

    }
    //[4] median-of-two-sorted-arrays
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double ret = 0d;
        int i = 0, j = 0;
        List<Integer> l = new ArrayList<>();
        while (i < nums1.length && j < nums2.length) {
            int n1 = nums1[i];
            int n2 = nums2[j];
            if (i + 1 < nums1.length && nums1[i + 1] < nums2[j]) {
                l.add(n1);
                i++;
                continue;
            } else if (j + 1 < nums2.length && nums2[j + 1] < nums1[i]) {
                l.add(n2);
                j++;
                continue;
            }
            if(n1<=n2){
                l.add(n1);
                l.add(n2);
            }else{
                l.add(n2);
                l.add(n1);
            }
            i++;
            j++;
        }
        while (i < nums1.length) {
            int n1 = nums1[i];
            l.add(n1);
            i++;
        }
        while (j < nums2.length) {
            int n2 = nums2[j];
            l.add(n2);
            j++;
        }
        int len = l.size();
        if (len % 2 == 1) {
            ret = Double.parseDouble(String.valueOf(l.get(len / 2)));
        } else {
            int a = l.get(len / 2 - 1);
            int b = l.get(len / 2);
            ret = ((double) a + b) / 2;
        }
        return ret;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}