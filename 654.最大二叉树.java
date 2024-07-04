import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;

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
        Deque<Integer> dq = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            TreeNode t = new TreeNode(nums[i]);
            tree[i] = t;
            while (!dq.isEmpty() && nums[dq.peek()] < nums[i]) {
                right[dq.pop()] = i;
            }
            if (!dq.isEmpty()) {
                left[i] = dq.peek();
            }
            dq.push(i);
        }

        TreeNode root = null;

        for (int i = 0; i < n; i++) {
            if (left[i] == -1 && right[i] == -1) {
                root = tree[i];
            } else if (right[i] == -1 || (left[i] != -1 && nums[left[i]] < nums[right[i]])) {
                tree[left[i]].right = tree[i];
            } else {
                tree[right[i]].left = tree[i];
            }
        }

        return root;

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
