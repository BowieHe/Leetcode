import java.util.LinkedList;

import javax.xml.soap.Node;

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

    LinkedList<Node> nodes = new LinkedList<>();

    public Node connect(Node root) {
        if(root == null) {
            return null;
        }
        traverse(root.left, root.right);
        return root;
    }

    void traverse(Node left, Node right) {
        if(left == null || right == null) {
            return;
        }
        left.next = right;
        traverse(left.left, left.right);
        traverse(left.right, right.left);
        traverse(right.left, right.right);
    }
}
// @lc code=end

