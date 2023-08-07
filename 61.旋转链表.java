/*
 * @lc app=leetcode.cn id=61 lang=java
 *
 * [61] 旋转链表
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
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null || head.next == null || k == 0) {
            return head;
        }

        int num = 0;
        ListNode dummy = new ListNode();
        dummy.next = head;
        while(dummy.next != null) {
            dummy = dummy.next;
            num++;
        }
        int move = num - k % num;
        if(move == num) {
            return head;
        }

        dummy.next = head;
        while(move-- > 0) {
            dummy = dummy.next;

        }
        ListNode first = dummy.next;
        dummy.next = null;
        return first;
    }

}
// @lc code=end

