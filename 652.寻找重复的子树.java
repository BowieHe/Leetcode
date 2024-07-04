import java.lang.Character.Subset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=652 lang=java
 *
 * [652] 寻找重复的子树
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 * int val;
 * TreeNode left;
 * TreeNode right;
 * TreeNode() {}
 * TreeNode(int val) { this.val = val; }
 * TreeNode(int val, TreeNode left, TreeNode right) {
 * this.val = val;
 * this.left = left;
 * this.right = right;
 * }
 * }
 */
class Solution {
    Map<String, Integer> map = new HashMap<>();
    List<TreeNode> res = new ArrayList<>();

    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {

        revrese(root);

        return res;
    }

    String revrese(TreeNode root) {
        if (root == null) {
            return "@";
        }

        String left = revrese(root.left);
        String right = revrese(root.right);
        String sub = left + "," + right + "," + root.val;

        int val = map.getOrDefault(sub, 0);

        if (val == 1) {
            res.add(root);
        }
        map.put(sub, val + 1);

        return sub;
    }
}
// @lc code=end
