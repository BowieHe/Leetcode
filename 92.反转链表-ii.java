/*
 * @lc app=leetcode.cn id=92 lang=java
 *
 * [92] 反转链表 II
 */

// @lc code=start
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
    public ListNode reverseBetween(ListNode head, int left, int right) {
       if(left == 1) {
        return reversN(head, right);
       } 
       head.next = reverseBetween(head.next, left - 1, right - 1);
       return head;
    }

    ListNode dummy = null;

    public ListNode reversN(ListNode head, int right) {
        if(right == 1) {
            dummy = head.next;
            return head;
        }

        ListNode last = reversN(head.next, right - 1);
        head.next.next = head;
        head.next = dummy;
        return last;
    }

}
// @lc code=end 
