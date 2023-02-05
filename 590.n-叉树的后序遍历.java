import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=590 lang=java
 *
 * [590] N 叉树的后序遍历
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
    
    public List<Integer> postorder(Node root) {

        List<Integer> res = new ArrayList<>();
        if(root != null) {
            res.add(dfs(root, res));
        }

        return res;
    }

    int dfs(Node root, List<Integer> res) {
        if(root.children == null || root.children.size() == 0) {
            return root.val;
        }

        for(Node node: root.children) {
            res.add(dfs(node, res));
        }
        return root.val;
    }
}
// @lc code=end

