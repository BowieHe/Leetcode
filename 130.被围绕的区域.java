/*
 * @lc app=leetcode.cn id=130 lang=java
 *
 * [130] 被围绕的区域
 */

// @lc code=start

import java.util.Arrays;

class Solution {

    int n, m;

    public void solve(char[][] board) {

        m = board.length;
        n = board[0].length;
        // int[][] graph = new int[m][n];
        // for (int i = 0; i < m; i++) {
        // int[] a = new int[n];
        // Arrays.fill(a, 0);
        // graph[i] = a;
        // }

        for (int i = 0; i < n; i++) {
            if (board[0][i] == 'O') {
                dfs(board, 0, i);
            }

            if (board[m - 1][i] == 'O') {
                dfs(board, m - 1, i);
            }
        }
        for (int i = 0; i < m; i++) {
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            if (board[i][n - 1] == 'O') {
                dfs(board, i, n - 1);
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                // System.out.print(graph[i][j]);
                if (board[i][j] == 'X') {
                    continue;
                } else if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                } else if (board[i][j] == 'A') {
                    board[i][j] = 'O';
                }
            }
            System.out.println();
        }

        return;

    }

    void dfs(char[][] board, int x, int y) {
        // System.out.println("run in dfs, x:" + x + " and y:" + y);
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] == 'A') {
            return;
        }
        if (board[x][y] == 'O') {
            board[x][y] = 'A';
            dfs(board, x - 1, y);
            dfs(board, x + 1, y);
            dfs(board, x, y - 1);
            dfs(board, x, y + 1);
        }
        return;
    }
}
// @lc code=end
