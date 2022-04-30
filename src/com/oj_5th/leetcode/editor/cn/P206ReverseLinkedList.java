//给你单链表的头节点 head ，请你反转链表，并返回反转后的链表。
// 
// 
// 
//
// 示例 1： 
//
// 
//输入：head = [1,2,3,4,5]
//输出：[5,4,3,2,1]
// 
//
// 示例 2： 
//
// 
//输入：head = [1,2]
//输出：[2,1]
// 
//
// 示例 3： 
//
// 
//输入：head = []
//输出：[]
// 
//
// 
//
// 提示： 
//
// 
// 链表中节点的数目范围是 [0, 5000] 
// -5000 <= Node.val <= 5000 
// 
//
// 
//
// 进阶：链表可以选用迭代或递归方式完成反转。你能否用两种方法解决这道题？
// 
// 
// Related Topics 递归 链表 
// 👍 1861 👎 0


package com.oj_5th.leetcode.editor.cn;

import java.util.ArrayList;
import java.util.List;

/*
*   [206] reverse-linked-list
*   2021-07-27 20:39:18
*/
public class P206ReverseLinkedList{
    public static void main(String[] args) {
        Solution solution = new P206ReverseLinkedList().new Solution();
        // TO TEST
    }
    //[206] reverse-linked-list
    //leetcode submit region begin(Prohibit modification and deletion)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList2(ListNode head) {
        if(head==null){
            return null;
        }

        List<Integer> list = new ArrayList<Integer>();
        while(head!=null){
            list.add(head.val);
            head = head.next;
        }
        ListNode ret = new ListNode(list.get(list.size()-1));
        ListNode p = ret;
        for(int i = list.size() - 2; i >=0; i--){
            ListNode tmp = new ListNode(list.get(i));
            p.next = tmp;
            p = p.next;
        }
        return ret;
    }
    public ListNode reverseList(ListNode head) {
        if(head==null){
            return null;
        }
        ListNode pre = null;
        ListNode next;
        ListNode curr = head;
        while(curr !=null){
            next = curr.next;
            curr.next = pre;
            pre =  curr;
            curr = next;
        }
        return pre;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}