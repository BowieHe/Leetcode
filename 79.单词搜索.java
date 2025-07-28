/*
 * @lc app=leetcode.cn id=79 lang=java
 *
 * [79] 单词搜索
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    int m, n;

    public boolean exist(char[][] board, String word) {
        m = board.length;
        n = board[0].length;
        char[] ws = word.toCharArray();

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] == ws[0]) {
                    if (dfs(board, ws, 0, i, j)) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean dfs(char[][] board, char[] word, int index, int x, int y) {
        if (index == word.length) {
            return true;
        }
        if (x < 0 || x >= m || y < 0 || y >= n || board[x][y] != word[index]) {
            return false;
        }

        char temp = board[x][y];
        board[x][y] = '#'; // 标记为已访问

        boolean found = dfs(board, word, index + 1, x + 1, y) ||
                        dfs(board, word, index + 1, x - 1, y) ||
                        dfs(board, word, index + 1, x, y + 1) ||
                        dfs(board, word, index + 1, x, y - 1);

        board[x][y] = temp; // 恢复单元格
        return found;
    }
}
// @lc code=end
