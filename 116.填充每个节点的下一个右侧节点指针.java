import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

/*
 * @lc app=leetcode.cn id=116 lang=java
 *
 * [116] 填充每个节点的下一个右侧节点指针
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

class Solution {

    /*
     * Deque<Node> dq;
     * 
     * public Node connect(Node root) {
     * if (root == null) {
     * return null;
     * }
     * this.dq = new ArrayDeque<>();
     * dq.add(root);
     * 
     * bfs(root);
     * return root;
     * }
     * 
     * void bfs(Node root) {
     * if (root == null) {
     * return;
     * }
     * int len = dq.size();
     * for (int i = 0; i < len; i++) {
     * Node n = dq.poll();
     * if (n.left != null) {
     * dq.add(n.left);
     * dq.add(n.right);
     * }
     * if (i < len - 1) {
     * n.next = dq.peek();
     * }
     * }
     * 
     * bfs(root.left);
     * }
     */

    // solution 2
    public Node connect(Node root) {
        if (root == null || root.left == null) {
            return root;
        }
        root.left.next = root.right;
        if (root.next != null) {
            root.right.next = root.next.left;
        }
        connect(root.left);
        connect(root.right);

        return root;
    }
}
// @lc code=end
