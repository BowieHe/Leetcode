import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
 * @lc app=leetcode.cn id=785 lang=java
 *
 * [785] 判断二分图
 */

// @lc code=start
class Solution {

    // dfs

    /*
     * int[] clas;
     * 
     * // 1 for class A, 2 for class B, 0 for undefined
     * public boolean isBipartite(int[][] graph) {
     * 
     * clas = new int[graph.length];
     * Arrays.fill(clas, 0);
     * 
     * boolean valid = true;
     * for (int i = 0; i < graph.length && valid; i++) {
     * if (clas[i] == 0) {
     * valid = dfs(graph, i, 1);
     * }
     * }
     * 
     * return valid;
     * }
     * 
     * boolean dfs(int[][] graph, int index, int color) {
     * clas[index] = color;
     * 
     * int neighbor = color == 1 ? 2 : 1;
     * int[] nums = graph[index];
     * for (int num : nums) {
     * if (clas[num] == color) {
     * return false;
     * } else if (clas[num] == neighbor) {
     * continue;
     * }
     * if (!dfs(graph, num, neighbor)) {
     * return false;
     * }
     * }
     * 
     * return true;
     * }
     */

    // bfs

    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        Arrays.fill(color, 0);

        int l = graph.length;

        Deque<Integer> deque = new LinkedList<>();

        for (int i = 0; i < l; i++) {
            if (color[i] != 0) {
                continue;
            }

            int c = 1;
            color[i] = c;
            deque.offer(i);
            while (!deque.isEmpty()) {
                int len = deque.size();
                int neightbor = c == 1 ? 2 : 1;
                for (int j = 0; j < len; j++) {
                    int index = deque.poll();
                    int[] nums = graph[index];
                    for (int num : nums) {
                        if (color[num] == c) {
                            System.out.println("wrong num: " + num + " and color:" + c + " and prev: " + index);
                            return false;
                        } else if (color[num] == neightbor) {
                            continue;
                        } else {
                            deque.offer(num);
                            color[num] = neightbor;
                        }
                    }

                }
                c = neightbor;
            }
        }

        return true;
    }

}
// @lc code=end
