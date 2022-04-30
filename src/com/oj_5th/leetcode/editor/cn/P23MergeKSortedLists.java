//给你一个链表数组，每个链表都已经按升序排列。 
//
// 请你将所有链表合并到一个升序链表中，返回合并后的链表。 
//
// 
//
// 示例 1： 
//
// 输入：lists = [[1,4,5],[1,3,4],[2,6]]
//输出：[1,1,2,3,4,4,5,6]
//解释：链表数组如下：
//[
//  1->4->5,
//  1->3->4,
//  2->6
//]
//将它们合并到一个有序链表中得到。
//1->1->2->3->4->4->5->6
// 
//
// 示例 2： 
//
// 输入：lists = []
//输出：[]
// 
//
// 示例 3： 
//
// 输入：lists = [[]]
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// k == lists.length 
// 0 <= k <= 10^4 
// 0 <= lists[i].length <= 500 
// -10^4 <= lists[i][j] <= 10^4 
// lists[i] 按 升序 排列 
// lists[i].length 的总和不超过 10^4 
// 
// Related Topics 链表 分治 堆（优先队列） 归并排序 
// 👍 1392 👎 0


package com.oj_5th.leetcode.editor.cn;


/*
*   [23] merge-k-sorted-lists
*   2021-07-19 21:56:53
*/
public class P23MergeKSortedLists{
    public static void main(String[] args) {
        Solution solution = new P23MergeKSortedLists().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)


  public class ListNode {
      int val;
      ListNode next;

      ListNode() {
      }

      ListNode(int val) {
          this.val = val;
      }

      ListNode(int val, ListNode next) {
          this.val = val;
          this.next = next;
      }
  }
    //[23] merge-k-sorted-lists
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode ret = new ListNode(Integer.MIN_VALUE);
        for(int i = 0; i < lists.length; i++){
            ret = mergeTwoLists(ret, lists[i]);
        }

        return ret.next;
    }
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null && l2==null){
            return null;
        }
        if(l1==null && l2!=null){
            return l2;
        }
        if(l1!=null && l2==null){
            return l1;
        }
        //新建一个链表，用于返回的
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;
        //遍历这两个链表。
        // 如果某个数比较小，则使用该链表的数，该链表指针再往下移动一位。
        //使用该链表的数：新建一个节点，赋值。然后该节点为ret的next。
        while (l1 != null && l2 != null) {
            ListNode tmp = new ListNode(-1);
            if(l1.val <= l2.val){
                tmp.val = l1.val;
                l1 = l1.next;
            }else{
                tmp.val = l2.val;
                l2 = l2.next;
            }
            p.next = tmp;
            p = p.next;
        }
        while (l1 != null) {
            ListNode tmp = new ListNode(-1);
            tmp.val = l1.val;
            l1 = l1.next;
            p.next = tmp;
            p = p.next;
        }
        while (l2 != null) {
            ListNode tmp = new ListNode(-1);
            tmp.val = l2.val;
            l2 = l2.next;
            p.next = tmp;
            p = p.next;
        }
        return dummy.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}