/*
 * @lc app=leetcode.cn id=133 lang=java
 *
 * [133] 克隆图
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

class Solution {

    Map<Node, Node> visited = new HashMap<Node, Node>();
    public Node cloneGraph(Node node) {
        if(node == null) {
            return node;
        }

        if(visited.containsKey(node)) {
            return visited.get(node);
        }

        Node clone = new Node(node.val, new ArrayList<Node>());
        visited.put(node, clone);
        for(Node nei: node.neighbors) {
            clone.neighbors.add(cloneGraph(nei));
        }

        return clone;
    }
}
// @lc code=end

