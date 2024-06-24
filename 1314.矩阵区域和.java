/*
 * @lc app=leetcode.cn id=1314 lang=java
 *
 * [1314] 矩阵区域和
 */

// @lc code=start
class Solution {
    public int[][] matrixBlockSum(int[][] mat, int k) {
        int row = mat.length, col = mat[0].length;
        int[][] res = new int[row][col];
        int[][] dp = new int[row + 1][col + 1];

        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= col; j++) {
                dp[i][j] = mat[i - 1][j - 1] + dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1];
            }
        }

        for(int i = 1; i <= row; i++) {
            for(int j = 1; j <= col; j++) {
                int x0 = Math.max(i - k - 1, 0);
                int x1 = Math.min(i + k, row);
                int y1 = Math.min(j + k, col);
                int y0 = Math.max(j - k - 1, 0);
                res[i - 1][j - 1] = dp[x1][y1] - dp[x1][y0] - dp[x0][y1] + dp[x0][y0];
            }
        }

        return res;
    }
}
// @lc code=end

