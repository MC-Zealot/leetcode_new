//中位数是有序列表中间的数。如果列表长度是偶数，中位数则是中间两个数的平均值。 
//
// 例如， 
//
// [2,3,4] 的中位数是 3 
//
// [2,3] 的中位数是 (2 + 3) / 2 = 2.5 
//
// 设计一个支持以下两种操作的数据结构： 
//
// 
// void addNum(int num) - 从数据流中添加一个整数到数据结构中。 
// double findMedian() - 返回目前所有元素的中位数。 
// 
//
// 示例： 
//
// addNum(1)
//addNum(2)
//findMedian() -> 1.5
//addNum(3) 
//findMedian() -> 2 
//
// 进阶: 
//
// 
// 如果数据流中所有整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 如果数据流中 99% 的整数都在 0 到 100 范围内，你将如何优化你的算法？ 
// 
// Related Topics 设计 双指针 数据流 排序 堆（优先队列） 
// 👍 449 👎 0


package com.oj_5th.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

/*
 *   [295] find-median-from-data-stream
 *   2021-08-03 18:48:13
 */
public class P295FindMedianFromDataStream {
    public static void main(String[] args) {
        MedianFinder solution = new P295FindMedianFromDataStream().new MedianFinder();
        // TO TEST
    }

    //[295] find-median-from-data-stream
    //leetcode submit region begin(Prohibit modification and deletion)
    class MedianFinder {
        PriorityQueue<Integer> min ;
        PriorityQueue<Integer> max ;
        /** initialize your data structure here. */
        public MedianFinder() {
            min = new PriorityQueue<>();
            max = new PriorityQueue<>((a, b) -> b - a);
        }

        public void addNum(int num) {
            max.add(num);
            min.add(max.poll());//最大堆的堆顶元素，小于或者等于最小堆的堆顶元素；
            if (min.size() > max.size()){
                max.add(min.poll());//最大堆的元素个数或者与最小堆的元素个数相等，或者多 1。
            }

        }

        public double findMedian() {
            if (max.size() == min.size())
                return (max.peek() + min.peek()) / 2.0;
            else
                return max.peek();
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
//leetcode submit region end(Prohibit modification and deletion)

}