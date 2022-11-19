import java.util.HashSet;

/*
 * @lc app=leetcode.cn id=160 lang=java
 *
 * [160] 相交链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        /*if(headA == null || headB == null) return null;
        ListNode pa = headA, pb = headB;
        while(pa != pb){
            pa = pa == null? headB: pa.next;
            pb = pb == null? headA: pb.next;
        }
        return pa;*/
        ListNode p1 = headA, p2 = headB;
        while(p1 != p2) {
            if(p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }
            if(p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }
        return p1;
    }
}
// @lc code=end

