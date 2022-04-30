//将两个升序链表合并为一个新的 升序 链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
//
// 
//
// 示例 1： 
//
// 
//输入：l1 = [1,2,4], l2 = [1,3,4]
//输出：[1,1,2,3,4,4]
// 
//
// 示例 2： 
//
// 
//输入：l1 = [], l2 = []
//输出：[]
// 
//
// 示例 3： 
//
// 
//输入：l1 = [], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 两个链表的节点数目范围是 [0, 50] 
// -100 <= Node.val <= 100 
// l1 和 l2 均按 非递减顺序 排列 
// 
// Related Topics 递归 链表 
// 👍 1800 👎 0


package com.oj_5th.leetcode.editor.cn;
/*
*   [21] merge-two-sorted-lists
*   2021-07-19 22:27:03
*/
public class P21MergeTwoSortedLists{
    public static void main(String[] args) {
        Solution solution = new P21MergeTwoSortedLists().new Solution();
        // TO TEST
    }

    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * */
 public class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 }
    //[21] merge-two-sorted-lists
class Solution {
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