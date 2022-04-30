//给你一个会议时间安排的数组 intervals ，每个会议时间都会包括开始和结束的时间 intervals[i] = [starti, endi] ，为避免
//会议冲突，同时要考虑充分利用会议室资源，请你计算至少需要多少间会议室，才能满足这些会议安排。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[0,30],[5,10],[15,20]]
//输出：2
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[7,10],[2,4]]
//输出：1
// 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// 0 <= starti < endi <= 106 
// 
// Related Topics 贪心 数组 双指针 排序 堆（优先队列） 
// 👍 294 👎 0


package com.oj_5th.leetcode.editor.cn;
/*
*   [253] meeting-rooms-ii
*   2021-07-17 22:11:03
*/
public class P253MeetingRoomsIi{
    public static void main(String[] args) {
        Solution solution = new P253MeetingRoomsIi().new Solution();
        // TO TEST
    }
    //[253] meeting-rooms-ii
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int minMeetingRooms(int[][] intervals) {
        int res = 0;
        if (intervals.length == 0) {
            return res;
        }
        int max_len = 0;
        for (int i = 0; i < intervals.length; i++) {
            if(intervals[i].length==2) {
                max_len = Math.max(max_len, intervals[i][1]);
            }
        }
        int[] flags = new int[max_len + 1];

        for (int i = 0; i < intervals.length; i++) {
            for (int j = intervals[i][0]; j < intervals[i][1]; j++) {
                flags[j] += 1;
            }
        }

        for (int i = 0; i < flags.length; i++) {
            res = Math.max(res, flags[i]);
        }
        return res;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}