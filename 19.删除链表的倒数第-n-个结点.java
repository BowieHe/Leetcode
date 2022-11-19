/*
 * @lc app=leetcode.cn id=19 lang=java
 *
 * [19] 删除链表的倒数第 N 个结点
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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode fastNode = head, slowNode = dummy; 
        for(int i = 0; i < n; i++) {
            fastNode = fastNode.next;
            System.out.println(i);
        }
        int index = 0;
        while(fastNode != null) {
            System.out.print("start move to next");
            fastNode = fastNode.next;
            slowNode = slowNode.next;
            System.out.println(index);
        } 
        // if(slowNode.next != null && slowNode.next.next != null) {
            slowNode.next = slowNode.next.next;
        // }
        
        return dummy.next;
    }
}
// @lc code=end

