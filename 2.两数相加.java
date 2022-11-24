/*
 * @lc app=leetcode.cn id=2 lang=java
 *
 * [2] 两数相加
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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(-1);
        ListNode begin = dummy;
        int addOne = 0, sum = 0;
        while(l1 != null || l2 != null) {
            int upVal = l1 == null? 0: l1.val;
            int downVal = l2 == null? 0: l2.val;
            sum = upVal + downVal + addOne;
         
            addOne = (sum / 10);
            sum = sum % 10;
            begin.next = new ListNode(sum);
            begin = begin.next;
            if(l1 != null) l1 = l1.next;
            if(l2 != null) l2 = l2.next;
        }
        if(addOne == 1) {
            begin.next = new ListNode(1);
        }
        return dummy.next;
    }
}
// @lc code=end

