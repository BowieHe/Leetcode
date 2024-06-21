/*
 * @lc app=leetcode.cn id=82 lang=java
 *
 * [82] 删除排序链表中的重复元素 II
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
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) {
            return head;
        }
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;

        while(pre.next != null && pre.next.next != null) {
            if(pre.next.val == pre.next.next.val) {
                int x = pre.next.val;
                while(pre.next != null && pre.next.val == x) {
                    pre.next = pre.next.next;
                }
            } else {
                pre = pre.next;
            }
        }

        return dummy.next;

    }
}
// @lc code=end
