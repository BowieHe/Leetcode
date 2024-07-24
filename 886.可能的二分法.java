import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.List;

/*
 * @lc app=leetcode.cn id=886 lang=java
 *
 * [886] 可能的二分法
 */

// @lc code=start
class Solution {

    public boolean possibleBipartition(int n, int[][] dislikes) {
        List<Integer>[] graph = build(n, dislikes);
        int[] group = new int[n + 1];
        Arrays.fill(group, 0);

        boolean valid = true;

        for (int i = 1; i <= n && valid; i++) {
            if (group[i] == 0) {

                valid = dfs(graph, i, 1, group);
            }

        }

        return valid;
    }

    boolean dfs(List<Integer>[] graph, int index, int color, int[] group) {
        if (group[index] == color) {
            return true;
        } else if (group[index] == (3 - color)) {
            return false;
        }

        group[index] = color;
        List<Integer> nums = graph[index];
        for (int num : nums) {
            if (!dfs(graph, num, (3 - color), group))
                return false;
        }

        return true;
    }

    List<Integer>[] build(int n, int[][] dislikes) {
        List<Integer>[] graph = new LinkedList[n + 1];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new LinkedList<>();
        }

        for (int[] dis : dislikes) {
            int a = dis[0];
            int b = dis[1];
            graph[a].add(b);
            graph[b].add(a);
        }

        return graph;
    }
}
// @lc code=end
