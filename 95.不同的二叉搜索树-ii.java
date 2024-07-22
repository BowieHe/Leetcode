import java.util.ArrayList;

/*
 * @lc app=leetcode.cn id=95 lang=java
 *
 * [95] 不同的二叉搜索树 II
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

    List<TreeNode> res;

    public List<TreeNode> generateTrees(int n) {
        res = new ArrayList<>();

        return build(1, n);
    }

    List<TreeNode> build(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        if (left > right) {
            res.add(null);
            return res;
        }

        for (int i = left; i <= right; i++) {
            List<TreeNode> leftNodes = build(left, i - 1);
            List<TreeNode> rightNodes = build(i + 1, right);

            for (TreeNode l : leftNodes) {
                for (TreeNode r : rightNodes) {
                    TreeNode root = new TreeNode(i);
                    root.left = l;
                    root.right = r;

                    res.add(root);
                }
            }
        }

        System.out.println("left:" + left + " and right:" + right + " and res size: " + res.size());
        return res;

    }
}
// @lc code=end
