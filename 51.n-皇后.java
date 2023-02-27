import java.util.ArrayList;
import java.util.HashMap;

/*
 * @lc app=leetcode.cn id=51 lang=java
 *
 * [51] N 皇后
 */

// @lc code=start
class Solution {
    List<List<String>> res;
    public List<List<String>> solveNQueens(int n) {
        res = new ArrayList<>();
        if(n == 0) {
            return res;
        }

        int[][] pos = new int[n][n];
        dp(pos, 0, n);
        return res;

    }

    Map memo = new HashMap<String, Boolean>();
    
    void dp(int[][] pos, int level, int n) {
        if(level == n) {
            List<String> cur = new LinkedList<>();
            for(int[] po: pos) {
                String p = convert(po);
                cur.add(p);
            }
            res.add(cur);
            return;
        }

        boolean canExecute = true;
        for(int i = 0; i < n; i++) {
            canExecute = true;
            for(int j = 0; j < level; j++) {
                int gap = Math.abs(j - level);
                int leftBound = i - gap;
                int rightBound = i + gap;
                // System.out.println(leftBound + " " + rightBound);
                if(pos[j][i] == 1 || (leftBound >= 0 && pos[j][leftBound] == 1) || (rightBound < n && pos[j][rightBound] == 1)) {
                    canExecute = false;
                    break;
                }
            }
            if(canExecute) {
                pos[level][i] = 1;
                dp(pos, level + 1, n);
                pos[level][i] = 0;
            }
        }
    }

    String convert(int[] nums) {
        StringBuilder sb = new StringBuilder();
        for(int num: nums) {
            if(num == 0) {
                sb.append(".");
            } else {
                sb.append("Q");
            }
        }
        return sb.toString();
    }
}
// @lc code=end

