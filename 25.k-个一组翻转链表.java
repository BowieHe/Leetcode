/*
 * @lc app=leetcode.cn id=25 lang=java
 *
 * [25] K 个一组翻转链表
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
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        ListNode succ = head;
        int i = 1;
        while (succ != null && succ.next != null && i < k) {
            succ = succ.next;
            i++;
        }
        if (i < k) {
            return head;
        }

        ListNode next = succ == null ? null : succ.next;
        ListNode h = reverse(head, k, next);

        head.next = reverseKGroup(next, k);
        return h;

    }

    public ListNode reverse(ListNode head, int n, ListNode next) {
        if (n == 1) {
            return head;
        }

        ListNode last = reverse(head.next, n - 1, next);
        head.next.next = head;
        head.next = next;
        return last;
    }
}
// @lc code=end
