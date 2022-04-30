//以数组 intervals 表示若干个区间的集合，其中单个区间为 intervals[i] = [starti, endi] 。请你合并所有重叠的区间，并返
//回一个不重叠的区间数组，该数组需恰好覆盖输入中的所有区间。 
//
// 
//
// 示例 1： 
//
// 
//输入：intervals = [[1,3],[2,6],[8,10],[15,18]]
//输出：[[1,6],[8,10],[15,18]]
//解释：区间 [1,3] 和 [2,6] 重叠, 将它们合并为 [1,6].
// 
//
// 示例 2： 
//
// 
//输入：intervals = [[1,4],[4,5]]
//输出：[[1,5]]
//解释：区间 [1,4] 和 [4,5] 可被视为重叠区间。 
//
// 
//
// 提示： 
//
// 
// 1 <= intervals.length <= 104 
// intervals[i].length == 2 
// 0 <= starti <= endi <= 104 
// 
// Related Topics 数组 排序 
// 👍 1037 👎 0


package oj_5th.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
*   [56] merge-intervals
*   2021-08-01 16:55:38
*/
public class P56MergeIntervals{
    public static void main(String[] args) {
        Solution solution = new P56MergeIntervals().new Solution();
//        int[][] intervals = {{8,10},{1,3},{2,6},{15,18}};
        int[][] intervals = {{1,4},{2,3}};
        int[][] ret = solution.merge(intervals);
        for(int i = 0; i < ret.length; i++){
            System.out.println(ret[i][0] + " " +ret[i][1]);
        }
        // TO TEST
    }
    //[56] merge-intervals
    //leetcode submit region begin(Prohibit modification and deletion)
class Solution {
    public int[][] merge(int[][] intervals) {
        if(intervals.length==0){
            return intervals;
        }
        Arrays.sort(intervals, Comparator.comparingInt(o -> o[0]));
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> l = new ArrayList<>();
        l.add(intervals[0][0]);
        l.add(intervals[0][1]);
        list.add(l);
        for(int i = 1; i < intervals.length; i++) {
            //if可以合并，则合并，
            //如果不能合并，则把当前interval加入到返回列表
            if (i < intervals.length && list.get(list.size() - 1).get(1) >= intervals[i][0]) {
                if(list.get(list.size() - 1).get(1)< intervals[i][1]){
                    list.get(list.size() - 1).set(1, intervals[i][1]);
                }
            } else {
                List<Integer> tmp = new ArrayList<>();
                tmp.add(intervals[i][0]);
                tmp.add(intervals[i][1]);
                list.add(tmp);
            }
        }
        int[][] ret = new int[list.size()][2];
        for(int i = 0; i < list.size(); i++){
            ret[i][0]=list.get(i).get(0);
            ret[i][1]=list.get(i).get(1);
        }
        return ret;
    }


}
//leetcode submit region end(Prohibit modification and deletion)

}