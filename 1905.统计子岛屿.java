/*
 * @lc app=leetcode.cn id=1905 lang=java
 *
 * [1905] 统计子岛屿
 */

// @lc code=start
class Solution {
    int m, n;
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        m = grid1.length;
        n = grid1[0].length;

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid1[i][j] == 0 && grid2[i][j] == 1) {
                    backtrace(grid2, i, j);
                }
            }
        }
        int res = 0;
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(grid2[i][j] == 1) {
                    backtrace(grid2, i, j);
                    res++;
                    
                }
            }
        }
        return res;
    }

    void backtrace(int[][] grid2, int x, int y) {
        if(x < 0 || x >= m || y < 0 || y >= n || grid2[x][y] != 1) {
            return ;
        }

        if(grid2[x][y] == 0) return;
        grid2[x][y] = 0;
        backtrace(grid2, x + 1, y);
        backtrace(grid2, x - 1, y);
        backtrace(grid2, x, y + 1);
        backtrace(grid2, x, y - 1);

    }
}
// @lc code=end

