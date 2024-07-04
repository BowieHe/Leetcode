import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.List;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=654 lang=java
 *
 * [654] 最大二叉树
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

    public TreeNode constructMaximumBinaryTree(int[] nums) {

        // return dfs(nums, 0, nums.length - 1);

        int n = nums.length;
        int[] left = new int[n], right = new int[n];
        Arrays.fill(left, -1);
        Arrays.fill(right, -1);
        TreeNode[] tree = new TreeNode[n];
        List<Integer> dq = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            TreeNode t = new TreeNode(nums[i]);
            tree[i] = t;
            while (dq.size() > 0 && nums[dq.get(dq.size() - 1)] < nums[i]) {
                tree[i].left = tree[dq.get(dq.size() - 1)];
                dq.remove(dq.size() - 1);
            }
            if (dq.size() > 0) {
                tree[dq.get(dq.size() - 1)].right = tree[i];
            }
            dq.add(i);
        }

        return tree[dq.get(0)];

    }

    TreeNode dfs(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int max = -1;
        int index = -1;
        for (int i = start; i <= end; i++) {
            if (nums[i] > max) {
                max = nums[i];
                index = i;
            }
        }

        TreeNode root = new TreeNode(max);
        root.left = dfs(nums, start, index - 1);
        root.right = dfs(nums, index + 1, end);

        System.out.println(root.val);
        return root;

    }
}
// @lc code=end
