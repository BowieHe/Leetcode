import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N 叉树的前序遍历
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
    public List<Integer> preorder(Node root) {
        List<Integer> res = new ArrayList<>();
        
        dfs(root, res);

        return res;
    }

    void dfs(Node root, List<Integer> res) {
        if(root != null) {
            res.add(root.val);
            List<Node> children = root.children;
            for(int i = 0; i < children.size(); i++) {
                Node node = children.get(i);
                dfs(node, res);
            }
        }
    }
}
// @lc code=end

