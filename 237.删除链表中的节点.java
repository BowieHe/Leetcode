/*
 * @lc app=leetcode.cn id=237 lang=java
 *
 * [237] 删除链表中的节点
 */

// @lc code=start
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        //如果只是node = node.next的话，只是修改了node指针指向的对象，并不是删除了改指针
        //这里是把node的值改为了下一个的值
        //同时nod.next = node.next.next，让node跳过下一个node，间接实现删除结点
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
// @lc code=end

