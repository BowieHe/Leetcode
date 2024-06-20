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
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode dummy = new ListNode(-1);
        ListNode res = dummy;

        if (lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);
        for (ListNode ln : lists) {
            if (ln != null) {
                pq.offer(ln);
            }

        }

        while (!pq.isEmpty()) {
            ListNode node = pq.poll();
            res.next = node;
            if (node.next != null) {
                pq.add(node.next);
            }

            res = res.next;
        }

        return dummy.next;
    }
}
// @lc code=end
