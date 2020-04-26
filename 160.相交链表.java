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
        Set<ListNode> node = new HashSet<>();
        while(headA != null){
            node.add(headA);
            headA = headA.next;
        }
        while(headB != null){
            if(node.contains(headB))return headB;
            headB = headB.next;
        }
        return null;
    }
}
// @lc code=end

