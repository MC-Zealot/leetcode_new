//给你两个 非空 链表来代表两个非负整数。数字最高位位于链表开始位置。它们的每个节点只存储一位数字。将这两数相加会返回一个新的链表。 
//
// 你可以假设除了数字 0 之外，这两个数字都不会以零开头。 
//
// 
//
// 示例1： 
//
// 
//
// 
//输入：l1 = [7,2,4,3], l2 = [5,6,4]
//输出：[7,8,0,7]
// 
//
// 示例2： 
//
// 
//输入：l1 = [2,4,3], l2 = [5,6,4]
//输出：[8,0,7]
// 
//
// 示例3： 
//
// 
//输入：l1 = [0], l2 = [0]
//输出：[0]
// 
//
// 
//
// 提示： 
//
// 
// 链表的长度范围为 [1, 100] 
// 0 <= node.val <= 9 
// 输入数据保证链表代表的数字无前导 0 
// 
//
// 
//
// 进阶：如果输入链表不能修改该如何处理？换句话说，不能对列表中的节点进行翻转。 
// Related Topics 栈 链表 数学 
// 👍 410 👎 0


package com.oj_5th.leetcode.editor.cn;
/*
*   [445] add-two-numbers-ii
*   2021-08-03 18:26:42
*/
public class P445AddTwoNumbersIi{
    public static void main(String[] args) {
        Solution solution = new P445AddTwoNumbersIi().new Solution();
        // TO TEST
    }
    //[445] add-two-numbers-ii
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        //翻转2个链表
        //链表相加
        //再翻转结果
        ListNode newL1 = reverseList(l1);
        ListNode newL2 = reverseList(l2);
        ListNode sum = addTwoNumbers2(newL1, newL2);
        return reverseList(sum);
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

    public ListNode addTwoNumbers2(ListNode l1, ListNode l2) {
        ListNode ret = new ListNode(-1);
        ListNode p = ret;
        //双指针开始循环，定义进位标志
        int carry = 0;
        while(l1!=null && l2!=null){
            int sum = l1.val + l2.val + carry;
            if(sum>=10){
                carry=1;
                sum-=10;
            }else{
                carry=0;
            }
            ListNode tmp = new ListNode(sum);
            p.next = tmp;
            p = p.next;
            l1 = l1.next;
            l2 = l2.next;
        }
        while(l1!=null){
            int sum = l1.val + carry;
            if(sum>=10){
                carry=1;
                sum-=10;
            }else{
                carry=0;
            }
            ListNode tmp = new ListNode(sum);
            p.next = tmp;
            p = p.next;
            l1 = l1.next;
        }
        while(l2!=null){
            int sum = l2.val + carry;
            if(sum>=10){
                carry=1;
                sum-=10;
            }else{
                carry=0;
            }
            ListNode tmp = new ListNode(sum);
            p.next = tmp;
            p = p.next;
            l2 = l2.next;
        }
        if(carry>0){
            ListNode tmp = new ListNode(1);
            p.next = tmp;
        }
        return ret.next;
    }
}
//leetcode submit region end(Prohibit modification and deletion)

}