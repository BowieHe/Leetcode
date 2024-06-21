/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (left == 1) {
            return reverse(head, right);
        }
        head.next = reverseBetween(head.next, left - 1, right - 1);
        return head;
    }

    // always the last point, since the last value is keep updating
    ListNode succ = null;

    ListNode reverse(ListNode head, int n) {
        if (n == 1) {
            succ = head.next;
            return head;
        }

        ListNode last = reverse(head.next, n - 1);
        head.next.next = head;
        head.next = succ;
        // System.out.println("get succ:" + succ.val + " and val: " + head.val);
        return last;
    }

}
// @lc code=end
