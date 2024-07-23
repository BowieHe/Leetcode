import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.tree.TreeNode;

/*
 * @lc app=leetcode.cn id=96 lang=java
 *
 * [96] 不同的二叉搜索树
 */

// @lc code=start
class Solution {

    List<TreeNode> r;
    Map<Integer, Integer> m;

    public int numTrees(int n) {
        if (n == 0) {
            return 0;
        }
        m = new HashMap<>();
        return b(1, n);
        // r = build(1, n);
        // return r.size();
    }

    int b(int left, int right) {

        int k = left * 100 + right;

        if (left > right) {
            return 1;
        }

        if (m.containsKey(k)) {
            return m.get(k);
        }

        int res = 0;

        for (int i = left; i <= right; i++) {

            int l = b(left, i - 1);
            int r = b(i + 1, right);

            res += l * r;
        }

        m.put(k, res);

        return res;
    }
}
// @lc code=end
