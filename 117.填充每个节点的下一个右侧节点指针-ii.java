/*
 * @lc app=leetcode.cn id=117 lang=java
 *
 * [117] 填充每个节点的下一个右侧节点指针 II
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}
    
    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, Node _left, Node _right, Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/

import java.util.Queue;
import java.util.Stack;

class Solution {
    Queue<Node> q = new LinkedList<Node>();
    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        q.add(root);
        while(!q.isEmpty()) {
            int len = q.size();
            Node pre = null;
            for(int i = 0; i < len; i++) {
                Node cur = q.poll();
                if(pre != null) {
                    pre.next = cur;
                }
                pre = cur;
                if(cur.left != null) {
                    q.add(cur.left);
                }
                if(cur.right != null) {
                    q.add(cur.right);
                }
            }
        }
        return root;
    }
}
// @lc code=end

