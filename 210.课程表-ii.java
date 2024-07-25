import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=210 lang=java
 *
 * [210] 课程表 II
 */

// @lc code=start
class Solution {
    List<Integer> res;

    public int[] findOrder(int numCourses, int[][] prerequisites) {

        res = new ArrayList<Integer>();

        int[] status = new int[numCourses];
        Arrays.fill(status, -1);

        List<Integer>[] graph = new ArrayList[numCourses];
        for (int i = 0; i < numCourses; i++) {
            graph[i] = new ArrayList<>();
        }
        for (int[] pre : prerequisites) {
            graph[pre[0]].add(pre[1]);
        }

        boolean valid = true;

        for (int i = 0; i < numCourses && valid; i++) {
            valid = dfs(graph, i, status);
        }

        if (!valid) {
            return new int[0];
        }

        int[] r = new int[numCourses];
        for (int i = 0; i < numCourses; i++) {
            r[i] = res.get(i);
        }

        return r;
    }

    boolean dfs(List<Integer>[] graph, int index, int[] status) {
        if (status[index] == 2) {
            // learned, skip
            return true;
        } else if (status[index] == 1) {
            // learning
            return false;
        }

        status[index] = 1;
        for (int num : graph[index]) {
            if (!dfs(graph, num, status)) {
                return false;
            }
        }
        status[index] = 2;
        res.add(index);

        return true;

    }
}

// @lc code=end
