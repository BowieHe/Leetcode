import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=141 lang=java
 *
 * [141] 环形链表
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        //List<Integer> list = new ArrayList<>();
        /*HashMap<Integer, Integer> map = new HashMap<>();
        if(head == null) return false;
        while(head != null){
            if(head.next == null) return false;
            map.put(head.val, map.getOrDefault(head.val, 0) + 1);
            if(map.get(head.val) == 2)return true;
            head = head.next;
        }
        return false;*/
        Set<ListNode> node = new HashSet<>();
        while(head != null){
            if(node.contains(head))return true;
            else node.add(head);
            head = head.next;
        }
        return false;
    }
}
// @lc code=end

