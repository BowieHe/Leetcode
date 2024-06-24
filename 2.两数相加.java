/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;
        int extra = 0;
        while (l1 != null || l2 != null || extra != 0) {
            int v1 = l1 == null ? 0 : l1.val;
            int v2 = l2 == null ? 0 : l2.val;
            int val = v1 + v2 + extra;
            extra = 0;
            if (val >= 10) {
                val = val % 10;
                extra = 1;
            }
            ListNode cur = new ListNode(val);
            l1 = l1 == null ? null : l1.next;
            l2 = l2 == null ? null : l2.next;
            pre.next = cur;
            pre = pre.next;

        }

        return dummy.next;
    }
}
// @lc code=end
