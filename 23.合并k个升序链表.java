import java.util.PriorityQueue;

/*
 * @lc app=leetcode.cn id=23 lang=java
 *
 * [23] 合并K个升序链表
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

    public ListNode mergeKLists(ListNode[] lists) {
        // 0 is lists index, 1 is value of node
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> {
            return a.val - b.val;
        });

        for(ListNode head: lists) {
            if(head != null) {
                pq.add(head);
            }
        }

        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;

        while(!pq.isEmpty()) {
            ListNode pair = pq.poll();
            System.out.print(pair.val);
            res.next = pair;
            if(pair.next != null) {
                pq.add(pair.next);
            }
            res = res.next;
        }
        return dummy.next;
    }
}
// @lc code=end

