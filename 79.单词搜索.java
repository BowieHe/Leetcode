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
    int len, len1;

    public boolean exist(char[][] board, String word) {
        Map<Character, List<int[]>> record = new HashMap<>();
        len = board.length;
        len1 = board[0].length;
        int[][] route = new int[len][len1];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len1; j++) {
                char ch = board[i][j];
                List<int[]> l = record.getOrDefault(ch, new ArrayList<>());
                l.add(new int[] { i, j });
                record.put(ch, l);

                route[i][j] = 0;
            }
        }

        char first = word.charAt(0);
        List<int[]> positions = record.getOrDefault(first, new ArrayList<>());
        if (positions.size() == 0) {
            return false;
        } else {
            for (int[] pos : positions) {
                route[pos[0]][pos[1]] = 1;
                if (dfs(board, route, record, word, 1, pos[0], pos[1])) {
                    return true;
                } else {
                    route[pos[0]][pos[1]] = 0;
                }
            }
        }

        return false;
    }

    public boolean dfs(char[][] board, int[][] route, Map<Character, List<int[]>> record, String word, int index, int x,
            int y) {
        if (index == word.length()) {
            return true;
        }

        char ch = word.charAt(index);
        List<int[]> positions = record.getOrDefault(ch, new ArrayList<>());
        if (positions.size() == 0) {
            return false;
        } else {
            for (int[] pos : positions) {
                if ((Math.abs(pos[0] - x) == 1 && pos[1] == y) || (Math.abs(pos[1] - y) == 1 && pos[0] == x)) {
                    if (route[pos[0]][pos[1]] == 1) {
                        // route passes, continue
                        continue;
                    }
                    route[pos[0]][pos[1]] = 1;
                    if (dfs(board, route, record, word, index + 1, pos[0], pos[1])) {
                        return true;
                    } else {
                        route[pos[0]][pos[1]] = 0;
                        continue;
                    }
                } else {
                    continue;
                }
            }
        }
        return false;
    }
    // public boolean exist(char[][] board, String word) {

    // if (word.length() == 0) {
    // return true;
    // }

    // len = board.length;
    // len1 = board[0].length;
    // int[][] route = new int[len][len1];
    // for (int i = 0; i < len; i++) {
    // int[] row = new int[len1];
    // Arrays.fill(row, 0);
    // route[i] = row;
    // }

    // for (int i = 0; i < len; i++) {
    // for (int j = 0; j < len1; j++) {
    // if (board[i][j] == word.charAt(0)) {

    // if (word.length() == 1) {
    // return true;
    // }
    // route[i][j] = 1;
    // if (dfs(board, route, word, 1, i, j)) {
    // return true;
    // }
    // route[i][j] = 0;
    // }
    // }
    // }

    // return false;

    // }

    // public boolean dfs(char[][] board, int[][] route, String word, int index, int
    // row, int col) {
    // char ch = word.charAt(index);
    // List<int[]> place = contains(board, ch, row, col);
    // if (place.size() == 0) {
    // return false;
    // }

    // for (int[] p : place) {
    // for (int i : p) {
    // System.out.print(i);
    // }
    // System.out.println();
    // }
    // System.out.println();

    // for (int i = 0; i < len; i++) {
    // for (int j = 0; j < len1; j++) {
    // System.out.print(route[i][j]);
    // }
    // System.out.println();
    // }
    // for (int[] pos : place) {
    // if ((route[pos[0]][pos[1]]) == 0) {
    // if (index == word.length() - 1) {
    // System.out.println("finish");
    // return true;
    // }
    // route[pos[0]][pos[1]] = 1;
    // if (dfs(board, route, word, index + 1, pos[0], pos[1])) {
    // return true;
    // }
    // route[pos[0]][pos[1]] = 0;
    // }
    // }

    // return false;

    // }

    public List<int[]> contains(char[][] board, char ch, int row, int col) {
        List<int[]> points = new ArrayList<>();
        if (row > 0 && board[row - 1][col] == ch) {
            points.add(new int[] { row - 1, col });
        }
        if (col > 0 && board[row][col - 1] == ch) {
            points.add(new int[] { row, col - 1 });
        }
        if (row < len - 1 && board[row + 1][col] == ch) {
            points.add(new int[] { row + 1, col });
        }
        if (col < len1 - 1 && board[row][col + 1] == ch) {
            points.add(new int[] { row, col + 1 });
        }
        return points;
    }
}
// @lc code=end
