/*
 * @lc app=leetcode.cn id=129 lang=java
 *
 * [129] 求根节点到叶节点数字之和
 */

// @lc code=start
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

import java.util.List;
import java.util.ArrayList;

class Solution {
    List<Integer> num = new ArrayList<Integer>();

    public int sumNumbers(TreeNode root) {
        // int base = root.val;
        iter(root, 0);
        // iter(root.right, base);

        int sum = 0;
        for (int v : num) {
            sum += v;
        }
        return sum;
    }

    public void iter(TreeNode root, int number) {
        if (root == null) {
            System.out.println(number);
            // num.add(number);
            return;
        }
        int n = number * 10 + root.val;
        if (root.left == null && root.right == null) {
            num.add(n);
            return;
        }
        iter(root.left, n);
        iter(root.right, n);
    }
}
// @lc code=end
