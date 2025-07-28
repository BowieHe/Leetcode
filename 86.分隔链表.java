/*
 * @lc app=leetcode.cn id=86 lang=java
 *
 * [86] 分隔链表
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Collections;

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
    public ListNode partition(ListNode head, int x) {
        List<Integer> v = new ArrayList<>();

        ListNode slowDummy = new ListNode(-1);
        ListNode slow = slowDummy;
        ListNode largeDummy = new ListNode(-2);
        ListNode large = largeDummy;
        ListNode dummy = new ListNode(-3, head);
        dummy = dummy.next;

        while(dummy != null) {
            if(dummy.val < x) {
                slow.next = new ListNode(dummy.val);
                slow = slow.next;
            } else {
                large.next = new ListNode(dummy.val);
                large = large.next;
            }
            dummy = dummy.next;
        }
        slow.next = largeDummy.next;
        return slowDummy.next;
    }
}
// @lc code=end

