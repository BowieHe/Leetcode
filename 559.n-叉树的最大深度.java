/*
 * @lc app=leetcode.cn id=559 lang=java
 *
 * [559] N 叉树的最大深度
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    int max = 0;

    public int maxDepth(Node root) {
        traverse(root, 0);
        
        return max;
    }

    void traverse(Node root, int depth) {
        if(root != null) {
            max = Math.max(max, depth + 1);
            List<Node> children = root.children;
            for(int i = 0; i < children.size(); i++) {
                traverse(children.get(i), depth + 1);
            }
        }
    }
}
// @lc code=end

